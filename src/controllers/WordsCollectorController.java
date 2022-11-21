/*
 * File: WordsCollectorController.java
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

package controllers;

import java.util.ArrayList;

import models.Page;
import views.MainWindow;


public class WordsCollectorController extends MainController { 

    public WordsCollectorController(MainWindow mainWindow) {
        super(mainWindow);

        mainWindow.pasteJButton.addActionListener(event -> {
            System.out.println("beillesztés");
            mainWindow.urlJTextField.paste();
        });


        mainWindow.startJButton.addActionListener(event -> {
         
            String url = mainWindow.urlJTextField.getText();
            if (url.isEmpty()) {
                url = "https://index.hu";
            }

            Page webPage = new Page();
            webPage.setUrl(url);

            ArrayList<String> collectedWords = webPage.getContent();

            for(String word : collectedWords) {
                if (mainWindow.wordsDefaultListModel.indexOf(word)<0) {
                    mainWindow.wordsDefaultListModel.addElement(word);
                }                
            } 
            Integer wordCount = mainWindow.wordsDefaultListModel.getSize();
            mainWindow.statusBar.setMessage("Szavak: " + wordCount.toString());
        }); 

    }   
}
