package com.osut.presentation.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.osut.entity.Article;
import com.osut.entity.Writer;
import com.osut.networking.Client;
import com.osut.networking.request.GetArticlesByUsernameRequest;
import com.osut.networking.request.LogInRequest;
import com.osut.presentation.Views.WriterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriterController {

    private WriterView writerView;
    private ArticleController articleController;
    private Client client;
    private Writer writer;
    private List<Article> articles;

    public WriterController(Client client, Writer writerObj) {
        this.writer = writerObj;
        this.writerView.setVisible(true);
        this.writerView.addEditArticleListener(new EditArticleButtonListener());
        this.client = client;
        client.sendRequest(new GetArticlesByUsernameRequest());
        String articleList = client.getResponse();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        try {
            Article[] articles1 = objectMapper.readValue(articleList, Article[].class);
            articles = Arrays.asList(articles1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(articleList);
    }

    public class EditArticleButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = writerView.getSelectedArticle();
            Article article = articles.get(i);
            if (article != null) {
                writerView.setVisible(false);
                articleController = new ArticleController(client, article, writer);
            }
        }
    }
}
