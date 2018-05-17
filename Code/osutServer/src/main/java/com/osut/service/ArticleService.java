package com.osut.service;

import com.osut.entity.Article;
import com.osut.entity.Writer;
import com.osut.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() { return this.articleRepository.findAll(); }
    public List<Article> getArticlesByAuthor(Writer writer) { return this.articleRepository.findAllByAuthor(writer);}
    public Article save(Article article) { return this.articleRepository.save(article); }

}
