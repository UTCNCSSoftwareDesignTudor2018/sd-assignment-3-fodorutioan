package com.osut.entity;

import java.util.Objects;

public class Article {

    private Long id;
    private String title;
    private String body;
    private Writer author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
            return title;
        }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Writer getAuthor() {
        return author;
    }

    public void setAuthor(Writer author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title) &&
                Objects.equals(body, article.body) &&
                Objects.equals(author, article.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, body, author);
    }

    @Override
    public String toString() {
        return "Article{" +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", writer=" + author +
                '}';
    }

}
