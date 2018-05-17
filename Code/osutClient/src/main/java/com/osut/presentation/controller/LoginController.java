package com.osut.presentation.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.osut.entity.Article;
import com.osut.entity.Writer;
import com.osut.networking.Client;
import com.osut.networking.request.GetArticlesRequest;
import com.osut.networking.request.LogInRequest;
import com.osut.presentation.Views.LogInView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginController {

    private LogInView logInView;
    private WriterController writerController;
    private Client client;

    public LoginController(Client client) {
        this.logInView = new LogInView();
        this.logInView.setVisible(true);
        this.logInView.addLogInListener(new LogInButtonListener());
        this.client = client;
    }

    public class LogInButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            client.sendRequest(new LogInRequest());
            String writer = client.getResponse();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Writer writerObj = objectMapper.readValue(writer, Writer.class);
                if (writerObj != null) {
                    logInView.setVisible(false);
                    writerController = new WriterController(client, writerObj);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
