package com.mediumclone.articleservice.dto;

import com.mediumclone.articleservice.domain.Tag;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private Long author;
    private Date created_at;
    private Date updated_at;
    private String tags;
}
