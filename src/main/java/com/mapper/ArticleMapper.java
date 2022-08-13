package com.mapper;

import com.pojo.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {
    int addArticle(Article article);
    List<Article> getArticle();
    Article getArticleById(String id);
    int updateArticle(Article article);
    int deleteArticle(String id);
}
