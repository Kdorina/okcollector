/*
 * File: Page.java
 * Created Date: 2022-11-21 8:20:46
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

package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Page {
    public String url;
    public ArrayList<String> getContent() {
        String result = "semmi";
        ArrayList<String> wordList = new ArrayList<>();
        if (!url.isEmpty()) {
            try {
                Connection connectPage = Jsoup.connect(this.url);
                Document document = connectPage.get();
                result = document.body().text();
                
                } catch (IOException e) {
                    System.err.println("Hiba! A weblap nem olvasható");
                }
                result = result.replaceAll("\\p{Punct}", "");
                result = result.replaceAll("[©0-9]", "");
                result = result.trim().replaceAll(" +", "\n");
        
        }else {
            System.err.println("Hiba! Az url nincs beállítva!");
        }

        Scanner scanner = new Scanner(result);
        while(scanner.hasNextLine()) {
            wordList.add(scanner.nextLine());
        }
        scanner.close();
        Collections.sort(wordList);
        return wordList;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
