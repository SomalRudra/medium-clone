package com.mediumclone.articleservice.service;

import com.mediumclone.articleservice.domain.Article;
import com.mediumclone.articleservice.dto.ArticleDto;

public interface IArticleService {
    public Iterable<Article> getArticles();
    public Article getArticle(Long id);
    public boolean saveArticle(ArticleDto article) ;
    public boolean updateArticle(Article article);
    public boolean deleteArticle(Article article);
}
