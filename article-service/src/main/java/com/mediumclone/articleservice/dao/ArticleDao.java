package com.mediumclone.articleservice.dao;

import com.mediumclone.articleservice.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Article, Long> {
}
