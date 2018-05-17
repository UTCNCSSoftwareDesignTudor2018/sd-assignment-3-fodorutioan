package com.osut;

import com.osut.entity.Article;
import com.osut.entity.Writer;
import com.osut.networking.Server;
import com.osut.service.ArticleService;
import com.osut.service.WriterService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;


import java.net.ServerSocket;

/**
     * A server program which accepts requests from clients to
     * capitalize strings.  When clients connect, a new thread is
     * started to handle an interactive dialog in which the client
     * sends in a string and the server thread sends back the
     * capitalized version of the string.
     *
     * The program is runs in an infinite loop, so shutdown in platform
     * dependent.  If you ran it from a console window with the "java"
     * interpreter, Ctrl+C generally will shut it down.
     */

@SpringBootApplication
public class OSUTApplication implements CommandLineRunner {
    /**
     * Application method to run the server runs in an infinite loop
     * listening on port 9898.  When a connection is requested, it
     * spawns a new thread to do the servicing and immediately returns
     * to listening.  The server keeps a unique client number for each
     * client that connects just to show interesting logging
     * messages.  It is certainly not necessary to do this.
     */

    @Autowired
    private ArticleService articleService;

    @Autowired
    private WriterService writerService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(OSUTApplication.class, args);
        System.out.println("The OSUT server is running.");
        int clientNumber = 0;
        ServerSocket listener = new ServerSocket(9898);
        try {
            while (true) {
                new Server(listener.accept(), clientNumber++).start();
            }
        } finally {
            listener.close();
        }
    }

    @Override
    public void run(String... args) throws Exception {
        Writer ioan = new Writer("ioan","add","email","fodorutioan","pass");
        writerService.save(ioan);
        articleService.save(new Article("copac","body",ioan));
        //System.out.println(articleService.getAllArticles());
    }
}

