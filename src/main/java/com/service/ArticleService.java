package com.service;

import com.pojo.Article;

import java.util.List;

public interface ArticleService {
    int addArticle(Article article);
    List<Article> getArticle();
    Article getArticleById(String id);
    int updateArticle(Article article);
    int deleteArticle(String id);
}
