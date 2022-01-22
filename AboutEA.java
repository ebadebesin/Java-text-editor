/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitexteditor;
import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author ebadebesin
 */
public class AboutEA extends JFrame{
    
    AboutEA(){
    setTitle("About Text Editor");
    setBounds( 100, 100, 500, 400 );
    setDefaultCloseOperation(DISPOSE_ON_CLOSE );
    setLayout(null);
    
    JLabel helpD= new JLabel("\"Ebun Blessing Adebesin\\n\" +\n" +
"\"           Java II\\n\" +\n" +
"\"           Dr Primo Abena\\n\" +\n" +
"\"           11/18/2021\\n\" +\n" +
"\"           \\n\" +\n" +
"\"           Notepad Help doc\\n\" +\n" +
"\"           \\n\" +\n" +
"\"           This application is a simple GUI JAVA Application with features that works similar to the Microsoft notepad. Here are the following functions/ features that the application has. This application will enable a user of the application to view and edit a text file.\\n\" +\n" +
"\"           \\n\" +\n" +
"\"           When the application is opened, the first thing the user sees is a blank text area with menus at the top, scrollbars horizontally and vertically and the line and column number at the bottom right of the page. Here is an image below.\\n\" +\n" +
"\"           \\n\" +\n" +
"\"           \\n\" +\n" +
"\"           The next feature is the menu bar. \\n\" +\n" +
"\"           Firstly, we have the file section. \\n\" +\n" +
"\"           The file section comprises of the new, open, save and exit menu item\\n\" +\n" +
"\"           •	The “new” menu item in the file section essentially creates a new text field and clears the previous document. It can also be activated by CTRL N.\\n\" +\n" +
"\"           •	The “open” menu item in the file section is able to open an existing .txt document in the available pane. It can also be activated by CTRL O.\\n\" +\n" +
"\"           \\n\" +\n" +
"\"           •	The “save” menu item in the file section saves all open documents. It can also be activated by CTRL S.\\n\" +\n" +
"\"           \\n\" +\n" +
"\"           •	The “exit” menu item in the file section closes and saves the open document then closes the application. It can also be activated by CTRL X.\\n\" +\n" +
"\"           \\n\" +\n" +
"\"           The second feature on the menu bar is the edit section.\\n\" +\n" +
"\"           The Edit section consist of the Go To, replace, font and line bar menu item\\n\" +\n" +
"\"           •	The “Go To” menu item in the edit section takes the user to a particular line number in the open \\n\" +\n" +
"\"           document.\\n\" +\n" +
"\"           •	The “Replace” menu item in the edit section allows the user to replace a supplied string with \\n\" +\n" +
"\"           another supplied string in the open document.\\n\" +\n" +
"\"           \\n\" +\n" +
"\"           •	The “Font” menu item in the edit section allows the user to edit the font style, font type and font size.\\n\" +\n" +
"\"            \\n\" +\n" +
"\"           \\n\" +\n" +
"\"           The third feature on the menu bar is the Format section.\\n\" +\n" +
"\"           The Format section consist of green and red menu item.\\n\" +\n" +
"\"           •	The “Green” menu item in the format section displays all the lines in the open file in the color green.\\n\" +\n" +
"\"           \\n\" +\n" +
"\"           •	The “Red” menu item in the format section displays all the lines in the open file in the color red.\\n\" +\n" +
"\"            \\n\" +\n" +
"\"           \\n\" +\n" +
"\"           The last feature on the menu bar is the Help section\\n\" +\n" +
"\"           The help section provides the user with a text document explaining all the options coded into the application which is the document you are reading now.\\n\" +\n" +
"\"           \\n\" +\n" +
"\"           \"");
    helpD.setBounds(100, 50, 500, 500);
    add(helpD);
    
    }
    public static void main(String[] args) {
        new AboutEA().setVisible(true);
    }
    
    /*TextEdit guiEA;
    
    public AboutEA(TextEdit guiEA){
        this.guiEA = guiEA;
    }
    
    
    public void ReadHelpDoc(){
   try
           {
                FileReader redEA = new FileReader("C:\\Users\\ebadebesin\\OneDrive - Huston-Tillotson University\\Documents\\HelpDoc.txt");
                BufferedReader bufR = new BufferedReader(redEA);
                guiEA.textEA.setText("");
                String lEA;
                
                
                while((lEA = bufR.readLine()) != null){
                     
                   
                    guiEA.textEA.append(lEA + "\n");
                }
                bufR.close();
            }
            catch (Exception exep)
            {
                System.out.println("File not opened");
            }
} */

    
}
