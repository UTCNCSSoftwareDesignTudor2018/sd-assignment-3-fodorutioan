package com.osut;

import com.osut.networking.Client;
import com.osut.presentation.controller.MainController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class OSUTApplication {

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.connectToServer();
        MainController mainController = new MainController(client);
    }
}
