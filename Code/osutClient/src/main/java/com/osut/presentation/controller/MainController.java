package com.osut.presentation.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.osut.entity.Article;
import com.osut.networking.Client;
import com.osut.networking.request.GetArticlesRequest;
import com.osut.presentation.Views.MainView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainController {

    private MainView mainView;
    private LoginController loginController;
    private Client client;

    public MainController(Client client) {
        this.client = client;
        client.sendRequest(new GetArticlesRequest());
        String articleList = client.getResponse();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        ArrayList<Article> articleArray = null;
        try {
            Article[] articles = objectMapper.readValue(articleList, Article[].class);
            articleArray = new ArrayList<Article>(Arrays.asList(articles));
            System.out.println("Articles " + articleArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainView = new MainView(articleArray);
        mainView.setVisible(true);
        mainView.addLogInListener(new LogInButtonListener());
    }

    public class LogInButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mainView.setVisible(false);
            loginController = new LoginController(client);
        }
    }
}
