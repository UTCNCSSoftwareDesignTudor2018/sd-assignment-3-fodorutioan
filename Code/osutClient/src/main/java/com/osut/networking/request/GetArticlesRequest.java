package com.osut.networking.request;

public class GetArticlesRequest implements Request {
    public String toJson() {
        System.out.println("get articles");
        return "{\"request_type\":\"getArticles\", \"request_body\":\"\" }";
    }
}
