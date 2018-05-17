package com.osut.presentation.controller;

import com.osut.entity.Article;
import com.osut.entity.Writer;
import com.osut.networking.request.Request;

public class SaveArticleRequest implements Request {
    private Article article;
    private Writer writer;

    public SaveArticleRequest(Article article, Writer writer) {
        this.article = article;
        this.writer = writer;
    }

    @Override
    public String toJson() {
        return "{\"request_type\":\"saveArticle\", \"request_body\":\"\"title\": \""
                + article.getTitle()
                + "\", \"body\": \""
                + article.getBody()
                + "\", \"author\":\""
                + "\"name\":\"" + writer.getName()
                + ",\"email\":\"" + writer.getEmail()
                + ",\"address\":\"" + writer.getAddress()
                + ",\"username\":\"" + writer.getUsername()
                + ",\"password\":\"" + writer.getPassword()
                + "\" \" \" \"}";
    }
}
