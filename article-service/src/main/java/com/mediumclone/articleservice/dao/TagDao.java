package com.mediumclone.articleservice.dao;

import com.mediumclone.articleservice.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagDao extends JpaRepository<Tag, Long> {
    boolean existsByTagName(String tagName);
    Tag findFirstByTagName(String tagName);
}
