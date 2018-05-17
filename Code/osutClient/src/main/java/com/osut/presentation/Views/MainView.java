package com.osut.presentation.Views;

import com.osut.entity.Article;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionListener;
import java.util.List;

public class MainView extends JFrame implements ListSelectionListener {
    private JButton logInButton;
    private JPanel backPanel;
    private JScrollPane listScrollPane;
    private JTable articlesTable;

    public MainView(List<Article> articles) {
        this.setContentPane(backPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        Object columnNames[] = {"Title", "Author", "Body" };
        articlesTable.addColumn(new TableColumn() );
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (Article e: articles) {
            Object rowData[] = {
                    e.getTitle(),
                    e.getAuthor().getName(),
                    e.getBody()};
            model.addRow(rowData);
        }
        articlesTable.setModel(model);

    }

    public void addLogInListener(ActionListener listenForLogInButton) {
        logInButton.addActionListener(listenForLogInButton);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

}
