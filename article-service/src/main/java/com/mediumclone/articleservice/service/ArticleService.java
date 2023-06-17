package com.mediumclone.articleservice.service;

import com.mediumclone.articleservice.dao.ArticleDao;

import com.mediumclone.articleservice.dao.TagDao;
import com.mediumclone.articleservice.domain.Tag;
import com.mediumclone.articleservice.dto.ArticleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mediumclone.articleservice.domain.Article;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ArticleService implements IArticleService{

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private TagDao tagDao;

    public Iterable<Article> getArticles() {
        return articleDao.findAll();
    }

    public Article getArticle(Long id) {
        return articleDao.getById(id);
    }

    public boolean saveArticle(ArticleDto article) {
        try {
            Article savedArticle = articleDao.save(dtoToEntityMapper(article));
            if (savedArticle != null) return true;
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Article dtoToEntityMapper(ArticleDto dtoArticle){
        Article article = new Article();
        article.setTitle(dtoArticle.getTitle());
        article.setContent(dtoArticle.getContent());
        article.setAuthor(dtoArticle.getAuthor());
        article.setCreated_at(new Date());
        article.setUpdated_at(new Date());
//      article = this.addTags(dtoArticle.getTags());
        article = this.addTags(article, dtoArticle.getTags());

        return  article;
    }
    
    public Article addTags(Article article, String tags){
        String tagsArr[] = tags.split(",");
        for (String tag: tagsArr) {
            Tag tagObj = new Tag(tag);
            System.out.println("Tag Exists? :: "+tagDao.existsByTagName(tag));
            if (!tagDao.existsByTagName(tag)){
                tagDao.save(tagObj);
            } else {
                tagObj = tagDao.findFirstByTagName(tag);
            }
            article.setTag(tagObj);

        }
        return article;
    } 
    public boolean updateArticle(Article articleUpdate) {
        try {
            Article article = articleDao.findById(articleUpdate.getId()).orElse(null);
            if (article != null) {
                article.setTitle(articleUpdate.getTitle());
                article.setContent(articleUpdate.getContent());
                article.setAuthor(articleUpdate.getAuthor());
                article.setCreated_at(article.getCreated_at());
                article.setUpdated_at(new Date());
                articleDao.save(article);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Failed to update item
        }
    }

    public boolean deleteArticle(Article article) {
        try {
            articleDao.delete(article);
            return (!articleDao.existsById(article.getId()));
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
