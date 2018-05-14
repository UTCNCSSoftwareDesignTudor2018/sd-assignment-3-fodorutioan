package com.osut.networking;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.osut.entity.Writer;
import com.osut.networking.request.LoginRequest;
import com.osut.networking.request.PersistAccountRequest;
import com.osut.service.ArticleService;
import com.osut.service.WriterService;

import java.io.IOException;

public class Interpreter {

    private WriterService writerService;
    private ArticleService articleService;

    public Interpreter() {
        this.writerService = new WriterService();
        this.articleService = new ArticleService();
    }

    public Object interpret(String request) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode root = objectMapper.readTree(request);
            String requestType = root.at("request_type").asText();
            String requestBody = root.at("request_body").asText();
            JsonNode root1 = objectMapper.readTree(requestBody);
            String password;
            String username;
            String name;
            String email;
            String address;
            switch (requestType) {
                case "logIn":
                    username = root1.at("username").asText();
                    password = root1.at("password").asText();
                    return writerService.logIn(username, password);
                case "saveAccount":
                    name = root1.at("name").asText();
                    email = root1.at("email").asText();
                    address = root1.at("address").asText();
                    username = root1.at("username").asText();
                    password = root1.at("password").asText();
                    return writerService.save(new Writer(name, email, address, username, password));
                case "getArticles":
                    return articleService.getAllArticles();
                case "getArticlesByUsername":
                    name = root1.at("name").asText();
                    email = root1.at("email").asText();
                    address = root1.at("address").asText();
                    username = root1.at("username").asText();
                    password = root1.at("password").asText();
                    Writer writer = new Writer(name, email, address, username, password);
                    return articleService.getArticlesByAuthor(writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
