package com.osut.networking;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Server extends Thread {

    private Socket socket;
    private int clientNumber;
    private Interpreter interpreter;

    public Server(Socket socket, int clientNumber) {
        this.socket = socket;
        this.clientNumber = clientNumber;
        this.interpreter = new Interpreter();
        log("New connection with client# " + clientNumber + " at " + socket);
    }

    /**
     * Services this thread's client by first sending the
     * client a welcome message then repeatedly reading strings
     * and sending back the capitalized version of the string.
     */
    public void run() {

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello, you are client #" + clientNumber + ".");
            out.println("Enter a line with only a period to quit\n");

            while (true) {
                String request = in.readLine();
                if (request == null || request.equals(".")) {
                    break;
                }
                Object response = interpreter.interpret(request);
                out.println(objectMapper.writeValueAsString(response));
            }

        } catch (IOException e) {
            log("Error handling client# " + clientNumber + ": " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                log("Couldn't close a socket, what's going on?");
            }
            log("Connection with client# " + clientNumber + " closed");
        }
    }

    /**
     * Logs a simple message.  In this case we just write the
     * message to the server applications standard output.
     */
    private void log(String message) {
        System.out.println(message);
    }

}
