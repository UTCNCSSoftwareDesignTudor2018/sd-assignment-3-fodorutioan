package com.osut.presentation.Views;

import com.osut.entity.Article;

import javax.swing.*;
import java.awt.event.ActionListener;

public class WriterView extends JFrame {
    private JTable table1;
    private JPanel backPanel;
    private JButton editArticleButton;
    private JButton newArticleButton;

    public WriterView() {
        this.setContentPane(backPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void addEditArticleListener(ActionListener listenForLogInButton) {
        editArticleButton.addActionListener(listenForLogInButton);
    }

    public int getSelectedArticle() {
        int index = table1.getSelectedRow();
        return index;
    }
}
