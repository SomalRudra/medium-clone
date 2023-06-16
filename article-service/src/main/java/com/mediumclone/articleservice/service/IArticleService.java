package com.mediumclone.articleservice.service;

import com.mediumclone.articleservice.domain.Article;

public interface IArticleService {
    public Iterable<Article> getArticles();
    public Article getArticle(Long id);
    public boolean saveArticle(Article article) ;
    public boolean updateArticle(Article article);
    public boolean deleteArticle(Article article);
}
