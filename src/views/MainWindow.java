/*
 * File: MainWindow.java
 * Created Date: 2022-11-21  8:20:46
 * Author: Kovács Dorina
 * Github: https://github.com/Kdorina
 * -----
 * Last Modified: 2022-11-21
 * Modified By: Kovács Dorina
 * -----
 * Copyright (c) 2022 Kovács Dorina
 * 
 * GNU GPL v2
 */

package views;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MainWindow extends JFrame {

    public JLabel appJLabel;
    public JTextField urlJTextField;

    public JPanel collectorJPanel;
    public JButton pasteJButton;
    public JButton startJButton;
    public JButton aboutJButton;
    public JButton exitJButton;


    public JPanel listJPanel;
    public JLabel FoundWordsJLabel;

    public DefaultListModel<String> wordsDefaultListModel;
    public JList<String> wordsJList;
    public JScrollPane wordsJScrollPane;

    public JButton deleteJButton;
    public JButton sortJButton;
    public JButton filterJButton;
    public JButton saveJButton;

    public JPanel listButtonsJPanel;

    public JPanel bottomJPanel;
    public StatusBar statusBar;

    public MainWindow() {
            appJLabel = new JLabel("Szógyűjtő");
            urlJTextField = new JTextField();        
   
            collectorJPanel = new JPanel();
            collectorJPanel.setLayout(new BoxLayout(collectorJPanel, BoxLayout.LINE_AXIS));
            pasteJButton = new JButton("Beillesztés");
            startJButton = new JButton("Indít");
            aboutJButton = new JButton("Névjegy");
            exitJButton = new JButton("Kilépés");

        CollectorPanel();
        }
       

        public void CollectorPanel(){

            this.collectorJPanel.add(pasteJButton);
            this.collectorJPanel.add(startJButton);
            this.collectorJPanel.add(aboutJButton);
            this.collectorJPanel.add(exitJButton);

        ListWords();
        }
      
        public void ListWords(){
        
            listJPanel = new JPanel();
            listJPanel.setLayout(new BoxLayout(listJPanel, BoxLayout.PAGE_AXIS));
            FoundWordsJLabel = new JLabel("Talált szavak");

        DefaultListModel();
        }

        public void DefaultListModel(){

            wordsDefaultListModel = new DefaultListModel<>();
            wordsJList = new JList<>(wordsDefaultListModel);
            wordsJScrollPane = new JScrollPane(wordsJList);
            listJPanel.add(FoundWordsJLabel);
            listJPanel.add(wordsJScrollPane);

        Delete();
        }

        public void Delete(){

            deleteJButton = new JButton("Törlés");
            deleteJButton.setMinimumSize(new Dimension(110, 25));
            deleteJButton.setMaximumSize(new Dimension(110, 25));
            deleteJButton.setPreferredSize(new Dimension(110, 25));
            deleteJButton.setMargin(new Insets(20, 20, 20, 20));

        Sort();
        }
     
        public void Sort(){

            sortJButton = new JButton("Rendezés");
            sortJButton.setMinimumSize(new Dimension(110, 25));
            sortJButton.setMaximumSize(new Dimension(110, 25));
            sortJButton.setPreferredSize(new Dimension(110, 25));

        Filter();
        }

        public void Filter(){

            filterJButton = new JButton("Szűrés");
            filterJButton.setMinimumSize(new Dimension(110, 25));
            filterJButton.setMaximumSize(new Dimension(110, 25));
            filterJButton.setPreferredSize(new Dimension(110, 25));

        Save();
        }

        public void Save(){

            saveJButton = new JButton("Mentés");
            saveJButton.setMinimumSize(new Dimension(110, 25));
            saveJButton.setMaximumSize(new Dimension(110, 25));
            saveJButton.setPreferredSize(new Dimension(110, 25));

        ListButtons();
        }
        
        public void ListButtons(){
            
            listButtonsJPanel = new JPanel();
            listButtonsJPanel.setLayout(new BoxLayout(listButtonsJPanel, BoxLayout.PAGE_AXIS));
            listButtonsJPanel.add(Box.createVerticalGlue());
            listButtonsJPanel.add(Box.createVerticalGlue());
            listButtonsJPanel.add(deleteJButton);
            listButtonsJPanel.add(Box.createVerticalGlue());
            listButtonsJPanel.add(sortJButton);
            listButtonsJPanel.add(Box.createVerticalGlue());
            listButtonsJPanel.add(filterJButton);
            listButtonsJPanel.add(Box.createVerticalGlue());
            listButtonsJPanel.add(saveJButton);
            listButtonsJPanel.add(Box.createVerticalGlue());
            listButtonsJPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            
        BottomPanel();
        }

        public void BottomPanel(){

            bottomJPanel = new JPanel();
            bottomJPanel.setLayout(new BoxLayout(bottomJPanel, BoxLayout.LINE_AXIS));
            bottomJPanel.add(listJPanel);
            bottomJPanel.add(listButtonsJPanel);

        Add();
        }

        public void Add(){

            this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

            this.add(appJLabel);
            this.add(urlJTextField);
            this.add(collectorJPanel);
            this.add(bottomJPanel);
            
        Status();
        }
       
        public void Status(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
            this.pack();
        
            statusBar = new StatusBar(this.getWidth());
            this.add(statusBar);

    }
    
}
