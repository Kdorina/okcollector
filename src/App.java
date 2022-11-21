/*
 * File: App.java
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

import controllers.WordsCollectorController;
import controllers.MainController;
import controllers.WordsController;
import views.MainWindow;

public class App {
public static void main(String[] args) throws Exception {
MainWindow mainWindow = new MainWindow();
new MainController(mainWindow);
new WordsCollectorController(mainWindow);
new WordsController(mainWindow);
mainWindow.setVisible(true);
}
}
