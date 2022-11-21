/*
 * File: CollectorController.java
 * Created Date: 2022-11-21
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

/**********************KEZDÉS************************************* */

/* 
    FIXME Az öröklés felesleges. 
    Ha megszüntetjük szükség lesz egy mainWindow adattagra. 
*/

// A CollectorController osztály
public class CollectorController extends MainController {
    //A CollectorController osztály konstruktora    
    public CollectorController(MainWindow mainWindow) {
        super(mainWindow);
        //A vágólap tartalmát beillesztjük


        /**************** pasteButton ****************************/

        mainWindow.pasteButton.addActionListener(event -> {
            System.out.println("beillesztés");
            mainWindow.urlField.paste();
        }); // A pasteButton eseménykezelő vége


        /**************** startButton ****************************/


        //Indul a szógyűjtés
        mainWindow.startButton.addActionListener(event -> {
            // URL
            String utvonal = mainWindow.urlField.getText();
            if (utvonal.isEmpty()) {
                utvonal = "https://index.hu";
            }
            //Egy weblap
            Page page = new Page();
            page.setUrl(utvonal);
            //Gyűjtött szavak ide kerülnek:
            ArrayList<String> w = page.getContent();

            for(String word : w) {
                if (mainWindow.wordsModel.indexOf(word)<0) {
                    mainWindow.wordsModel.addElement(word);
                }                
            } // for ciklus vége
            Integer wordCount = mainWindow.wordsModel.getSize();
            mainWindow.statusBar.setm("Szavak: " + wordCount.toString());
        }); //A start eseménykezelő vége

         /**************** VÉGE ****************************/


    }   
}
