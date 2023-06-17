package com.mediumclone.articleservice.controller;

import com.mediumclone.articleservice.domain.Article;
import com.mediumclone.articleservice.dto.ArticleDto;
import com.mediumclone.articleservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/v1/article")
public class ArticleController {
    @Autowired
    private ArticleService as;
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ArticleDto article){
        System.out.println("\narticle:: " + article);
        if(as.saveArticle(article)){
            return ResponseEntity.status(HttpStatus.OK).body("added successfully");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong while saving");
        }
    }
    @GetMapping("/list")
    public Iterable<Article> getAll(){
        return as.getArticles();
    }
    @GetMapping("/{id}")
    public Article getOne(@PathVariable Long id){
        return as.getArticle(id);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Article article){
        if(as.updateArticle(article)){
            return ResponseEntity.status(HttpStatus.OK).body("updated successfully");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("article not found");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Article article = as.getArticle(id);
        if(article == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("article not found");
        }
        if(as.deleteArticle(article)){
            return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong while deleting");
        }
    }
}
