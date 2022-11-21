/*
 * File: WordsController.java
 * Created Date: 2022-11-21
 * Author:Kovács Dorina
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

import views.MainWindow;

public class WordsController {
    MainWindow mainWindow;
    //Az osztály konstruktora
    public WordsController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.mainWindow.exitButton.addActionListener(event ->{
            System.exit(0);
        });
    }
    
}

/**
 * 2021-09-24 Kezdés
 * 2021-09-26 Szemetelés
 */