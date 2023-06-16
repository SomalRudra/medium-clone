package com.mediumclone.articleservice.service;

import com.mediumclone.articleservice.dao.ArticleDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mediumclone.articleservice.domain.Article;

import java.util.Date;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ArticleService implements IArticleService{

    @Autowired
    private ArticleDao articleDao;

    public Iterable<Article> getArticles() {
        return articleDao.findAll();
    }

    public Article getArticle(Long id) {
        return articleDao.getById(id);
    }

    public boolean saveArticle(Article article) {
        try {
            Article savedArticle = articleDao.save(article);
            if (savedArticle != null) return true;
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateArticle(Article articleUpdate) {
        try {
            Article article = articleDao.findById(articleUpdate.getId()).orElse(null);
            if (article != null) {
                // Apply changes received in the PATCH request to the fetched item
                // For example, assuming the updatedItem contains new values for specific fields
                article.setTitle(articleUpdate.getTitle());
                article.setContent(articleUpdate.getContent());
                article.setAuthor(articleUpdate.getAuthor());
                article.setUpdated_at(new Date());
                // Save the updated item back to the database
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
