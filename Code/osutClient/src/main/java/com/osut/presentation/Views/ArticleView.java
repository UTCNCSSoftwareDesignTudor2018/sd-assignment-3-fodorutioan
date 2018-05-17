package com.osut.presentation.Views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ArticleView extends JFrame {
    private JTextField authorTextField;
    private JTextField titleTextField;
    private JTextField bodyTextField;
    private JButton saveArticleButton;
    private JButton backButton;
    private JPanel backPanel;

    public String getAuthor() {
        return authorTextField.getText();
    }

    public void setAuthor(String author) {
        this.authorTextField.setText(author);
    }

    public String getArticleTitle() {
        return titleTextField.getText();
    }

    public void setArticleTitle(String title) {
        this.titleTextField.setText(title);
    }

    public String getBody() {
        return bodyTextField.getText();
    }

    public void setBody(String body) {
        this.bodyTextField.setText(body);
    }
    public void addSaveArticleListener(ActionListener listenForSaveArticleButton) {
        saveArticleButton.addActionListener(listenForSaveArticleButton);
    }

    public void addBackListener(ActionListener listenForBackButton) {
        backButton.addActionListener(listenForBackButton);
    }
}
