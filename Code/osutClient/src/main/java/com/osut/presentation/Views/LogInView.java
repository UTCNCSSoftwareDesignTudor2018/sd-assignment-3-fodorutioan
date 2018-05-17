package com.osut.presentation.Views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LogInView extends JFrame{
    private JPasswordField passwordField1;
    private JPanel backPanel;
    private JTextField textField1;
    private JButton logInButton;

    public LogInView() {
        this.setContentPane(backPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void addLogInListener(ActionListener listenForLogInButton) {
        logInButton.addActionListener(listenForLogInButton);
    }
}
