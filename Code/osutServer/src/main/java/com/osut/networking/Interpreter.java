package com.osut.networking;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.osut.entity.Article;
import com.osut.entity.Writer;
import com.osut.networking.request.LoginRequest;
import com.osut.networking.request.PersistAccountRequest;
import com.osut.service.ArticleService;
import com.osut.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Interpreter {

    @Autowired
    private WriterService writerService;

    @Autowired
    private ArticleService articleService;

    public Interpreter() {
    }

    public Object interpret(String request) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode root = objectMapper.readTree(request);
            String requestType = root.get("request_type").asText();
            String requestBody = root.get("request_body").asText();
            JsonNode root1 = objectMapper.readTree(requestBody);
            String password, username, name, email, address, title, body;
            switch (requestType) {
                case "logIn":
                    username = root1.at("username").asText();
                    password = root1.at("password").asText();
                    return writerService.logIn(username, password);
//                case "saveAccount":
//                    name = root1.get("name").asText();
//                    email = root1.get("email").asText();
//                    address = root1.get("address").asText();
//                    username = root1.get("username").asText();
//                    password = root1.get("password").asText();
//                    return writerService.save(new Writer(name, email, address, username, password));
                case "getArticles":
                    List<Article> articles = articleService.getAllArticles();
                    System.out.println(articleService.getAllArticles());
                    return articles;
                case "getArticlesByUsername":
                    name = root1.get("name").asText();
                    email = root1.get("email").asText();
                    address = root1.get("address").asText();
                    username = root1.get("username").asText();
                    password = root1.get("password").asText();
                    Writer writer = new Writer(name, email, address, username, password);
                    return articleService.getArticlesByAuthor(writer);
                case "saveArticle":
                    String author = root1.get("author").asText();
                    JsonNode root2 = objectMapper.readTree(author);
                    title = root1.get("title").asText();
                    body = root1.get("body").asText();
                    name = root2.get("name").asText();
                    email = root2.get("email").asText();
                    address = root2.get("address").asText();
                    username = root2.get("username").asText();
                    password = root2.get("password").asText();
                    Writer writer1 = new Writer(name, email, address, username, password);
                    Article article = new Article(title, body, writer1);
                    return articleService.save(article);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
