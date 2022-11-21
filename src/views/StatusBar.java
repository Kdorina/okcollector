/*
 * File: StatusBar.java
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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class StatusBar extends JPanel {
   
    JLabel statusJLabel;

    public StatusBar(int width) {        
        setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        sizeStatusLine(width, 25);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        statusJLabel = new JLabel("Kész");
        this.setMessage("Kész");
        this.add(statusJLabel);
    }
    
    public void sizeStatusLine(int x, int y) {
     
        setMaximumSize(new Dimension(x, y));
        setMinimumSize(new Dimension(x, y));
        setPreferredSize(new Dimension(x, y));
    } 

    public void setMessage(String message) {

        this.statusJLabel.setText(message);
    } 
}
