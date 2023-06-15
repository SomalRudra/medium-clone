package com.mediumclone.articleservice.controller;

import com.mediumclone.articleservice.domain.Article;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/article")
public class ArticleController {
    @PostMapping("/save")
    public void save(@RequestBody Article user){
        System.out.println("saved successfully");
    }
    @GetMapping("/list")
    public List<Article> getAll(){
        System.out.println("Retrived Successfully");
        return null;
    }
    @GetMapping("/{id}")
    public void getOne(@PathVariable long id){
        System.out.println("Retrived one successfully");
    }
}
