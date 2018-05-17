package com.osut.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.osut.entity.Article;
import com.osut.entity.Writer;
import com.osut.networking.Client;
import com.osut.presentation.Views.ArticleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ArticleController {

    private ArticleView articleView;
    private WriterController writerController;
    private Client client;
    private Writer writer;
    private Article article;

    public ArticleController(Client client, Article article, Writer writer) {
        this.articleView = new ArticleView();
        this.articleView.setVisible(true);
        this.articleView.addSaveArticleListener(new SaveArticleButtonListener());
        this.articleView.addBackListener(new BackButtonListener());
        this.client = client;
        this.article = article;
        this.writer = writer;
        this.articleView.setTitle(article.getTitle());
        this.articleView.setAuthor(article.getAuthor().toString());
        this.articleView.setBody(article.getBody());
    }

    public class SaveArticleButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ObjectMapper objectMapper = new ObjectMapper();
            String writerStr = articleView.getAuthor();
            try {
                Writer writer1 = objectMapper.readValue(writerStr, Writer.class);
                if (writer1 != null) {
                    article.setTitle(articleView.getArticleTitle());
                    //article.setAuthor(writer1);
                    article.setBody(articleView.getBody());
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            client.sendRequest(new SaveArticleRequest(article, writer));
        }

    }

    public class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            articleView.setVisible(false);
            writerController = new WriterController(client, writer);
        }
    }
}
