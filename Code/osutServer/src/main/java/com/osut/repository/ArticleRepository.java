package com.osut.repository;

import com.osut.entity.Article;
import com.osut.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAll();
    Optional<Article> findById(Long id);
    List<Article> findAllByAuthor(Writer writer);
    Article save(Article article);
}
