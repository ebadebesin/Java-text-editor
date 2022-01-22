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
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


/**
 *
 * @author ebadebesin
 */
public class TextEdit  extends JFrame implements ActionListener{
  JFrame f1EA=new JFrame();
  JFrame f2EA=new JFrame("Help Document");
  JFrame f3EA=new JFrame("Format");
  JPanel panelEA= new JPanel();
  JLabel statusBarEA= new JLabel("|| Ln 1, Col 1  ",JLabel.LEFT);//sets the status of the lines and columns
  JLabel LaEA;
  JButton b1EA= new JButton("Ok");
  JButton b2EA= new JButton("Cancel");
  JMenuBar menuBarEA= new JMenuBar();
  JMenu fileEA,editEA,formatEA,helpEA;
  JMenuItem newEA,openEA,saveEA,exitEA,replaceEA,statusEA,goToEA,greenEA,redEA,fontEA,viewhelpEA;
  JTextArea textEA= new JTextArea();
 // JScrollBar scrollEA= new JScrollBar();
  JFileChooser pickEA= new JFileChooser();
  //JScrollPane jsp;
 //JFileChooser pickEA= new JFileChooser();
  JComboBox cB1EA;
  JComboBox cB2EA;
  JComboBox cB3EA;
  Font wordEA;
  ImageIcon iconEA= new ImageIcon("NotepadIcon.png");
  Scanner inpEA= null;
  JLabel labl_replaceEA, labl_replacewithEA;
  JTextField text_replaceEA, text_replacewithEA;
  JButton butn_changeEA, butn_closeEA;
    
 // File flEA= new File("");
 // FileReader red = new FileReader("HelpDoc.txt");
  
  //how to show line number of the text in the file on the LHS
  //JFileChooser, JMenuBar and JMenu
 
  /*public static void ReadHelpDoc(){
   try
           {
                FileReader red = new FileReader("HelpDoc.txt");
                //BufferedReader bufR = new BufferedReader(red);l = bufR.readLine()) != null
                Scanner in = new Scanner(red);
                
                
                while(in.hasNextLine()){
                     
                    String l = in.nextLine();
                    //textEA.append(l + "n");
                    System.out.println(l);
                }
            }
            catch (IOException exep)
            {
                exep.printStackTrace();
            }
} */
        
  public TextEdit () {
    f1EA.setTitle("Ebunoluwa's NotePad");
    f1EA.setSize( 600, 600 );
    f1EA.setDefaultCloseOperation(EXIT_ON_CLOSE );
    f1EA.setVisible(true);
    
    String FntTyp[]={"Arial", "TimesRoman", "Copper"};
    cB1EA= new JComboBox(FntTyp);
    String FntDes[]={"BOLD","ITALIC"};
    cB2EA= new JComboBox(FntDes);
    String FntSze[]={"40","35","30","25","20","18","15","14","13","12","11","10"};
    cB3EA= new JComboBox(FntSze);
    
   f3EA.setSize(300,300);
   f3EA.setLayout(new FlowLayout());
   
   // perform AcListener on button
   b2EA.addActionListener(this);
   b1EA.addActionListener(this);
   
   // Set front style and Size
   wordEA= new Font("Arial",Font.BOLD,20);
   
   // Set Jtextarea
   textEA = new JTextArea(60,60);
   textEA.setFont(wordEA);
   textEA.setBounds(0,20,800,500);
   
   // Set the location of Menu bar
   menuBarEA.setBounds(0,0,800,30);
   
   //Create Menu Bar
   fileEA=new JMenu("File");
   editEA=new JMenu("Edit");
   formatEA=new JMenu("Format");
   helpEA=new JMenu("Help");
   
    // Create menu
   newEA=new JMenuItem("New");
   openEA=new JMenuItem("Open");
   saveEA=new JMenuItem("Save");
   exitEA=new JMenuItem("Exit");
   replaceEA=new JMenuItem("Replace");
   statusEA= new JMenuItem("Line Bar");
   goToEA=new JMenuItem("Go To");
   greenEA=new JMenuItem("Green");
   redEA=new JMenuItem("Red");
   fontEA=new JMenuItem("Font");
   viewhelpEA=new JMenuItem("Help");
   
   LaEA= new JLabel(iconEA);
   f2EA.add(LaEA);
   
   //Add menu inside the mnu bar
   menuBarEA.add(fileEA);
   menuBarEA.add(editEA);
   menuBarEA.add(formatEA);
   menuBarEA.add(helpEA);
   
   panelEA.add(menuBarEA, BorderLayout.NORTH);
   panelEA.setLayout(new BorderLayout());
   
   //Add menu inside the file menu
   fileEA.add(newEA);
   fileEA.addSeparator();
   fileEA.add(openEA);
   fileEA.addSeparator();
   fileEA.add(saveEA);
   fileEA.addSeparator();
   fileEA.add(exitEA);
   fileEA.addSeparator();
   
   //Add menu inside the edit menu
   editEA.add(replaceEA);
   fileEA.addSeparator();
   editEA.add(goToEA);
   fileEA.addSeparator();
   editEA.add(fontEA);
   fileEA.addSeparator();
   
   editEA.add(statusEA);
   fileEA.addSeparator();
   
   //Add menu inside the 
   formatEA.add(greenEA);
   fileEA.addSeparator();
   formatEA.add(redEA);
   fileEA.addSeparator();
    
    helpEA.add(viewhelpEA);
    //fileEA.addSeparator();
    
    f3EA.add(cB1EA);
    f3EA.add(cB2EA);
    f3EA.add(cB3EA);
    f3EA.add(b1EA);
    f3EA.add(b2EA);
    
    fileEA.setMnemonic(KeyEvent.VK_F);
    editEA.setMnemonic(KeyEvent.VK_E);
    formatEA.setMnemonic(KeyEvent.VK_T);
    //helpEA.setMnemonic(KeyEvent.VK_H);
    
    KeyStroke nw =KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
    newEA.setAccelerator(nw);
    
    KeyStroke opn =KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
    openEA.setAccelerator(opn);
    
    KeyStroke sv =KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
    saveEA.setAccelerator(sv);
    
    KeyStroke ex =KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
    exitEA.setAccelerator(ex);
    
    // add action listener on menu element
   newEA.addActionListener(this);
   openEA.addActionListener(this);
   saveEA.addActionListener(this);
   exitEA.addActionListener(this);
   replaceEA.addActionListener(this);
   statusEA.addActionListener(this);
   goToEA.addActionListener(this);
   greenEA.addActionListener(this);
   redEA.addActionListener(this);
   viewhelpEA.addActionListener(this);
   fontEA.addActionListener(this);
   
   JScrollPane scroll = new JScrollPane(textEA);
   scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   
   scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
   
   panelEA.add(scroll,BorderLayout.CENTER);
   panelEA.add(menuBarEA, BorderLayout.NORTH);
   panelEA.add(statusBarEA, BorderLayout.SOUTH);
   f1EA.add(panelEA);
   
   addWindowListener(
   new WindowAdapter(){
       public void windowClosing(WindowEvent ww){
          int nEA;
          nEA= JOptionPane.showOptionDialog(null, "Do you want to save your changes?", "Ebunoluwa's Notepad", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, iconEA, null, null);
          
          if(nEA==JOptionPane.CLOSED_OPTION){
              System.exit(0);
              
          }else if(nEA==JOptionPane.YES_OPTION){
              System.out.println("hi");
              JFrame EA= new JFrame();
              int pc= pickEA.showSaveDialog(EA);
              if(pc==JFileChooser.APPROVE_OPTION){
                  try{
                      FileWriter fEA= new FileWriter(pickEA.getSelectedFile());
                      BufferedWriter bf= new BufferedWriter(fEA);
                      inpEA= new Scanner(textEA.getText());
                      while(inpEA.hasNext()){
                          bf.write(inpEA.nextLine());
                          bf.newLine();
                      }
                      bf.close();
                  }catch(IOException ee){
                      System.out.println(ee);
                  }
              }
          }
          System.exit(0);
       }
   });
   
   textEA.addCaretListener(
   new CaretListener(){
       public void caretUpdate(CaretEvent ce){
           int lineNumberEA=0, columnEA=0, posEA=0;
           try{
               posEA=textEA.getCaretPosition();
               lineNumberEA= textEA.getLineOfOffset(posEA);
               columnEA= posEA-textEA.getLineStartOffset(lineNumberEA);
           }catch(Exception ext){}
           if(textEA.getText().length()==0){
               lineNumberEA=0; columnEA=0;
           }
           statusBarEA.setText("||Ln " + (lineNumberEA +1)+ "Col "+ (columnEA +1)+ " ||          ");
       }
   });
  }
  public void replaceWordEA(){
      JDialog jdEA= new JDialog(f3EA, "Replace");
      jdEA.setSize (400, 140) ;
      jdEA.setLocationRelativeTo(f3EA);
      jdEA.setVisible(true);
      JPanel pEA = new JPanel();
      
      labl_replaceEA=new JLabel("Find: ");
      labl_replacewithEA= new JLabel ("Replace With: ") ;
      
      text_replaceEA= new JTextField(20);
      text_replacewithEA= new JTextField(20);
      
      butn_changeEA= new JButton("Change");
      butn_changeEA.addActionListener(this);
      butn_closeEA= new JButton("Close");
      butn_closeEA.addActionListener(this);
      
      pEA.add(labl_replaceEA);
      pEA.add(labl_replacewithEA);
      pEA.add(text_replaceEA);
      pEA.add(text_replacewithEA);
      pEA.add(butn_changeEA);
      pEA.add(butn_closeEA);
      
      pEA.setLayout(new GridLayout(3,2));
      pEA.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      jdEA.add(pEA);
      
     /*
      labl_replaceEA, labl_replacewithEA;
  TextField text_replaceEA, text_replacewithEA;
  Button butn_changeEA, butn_closeEA;
      */

      
  }
  void goTo(){
      int lineNumber=0;
      try{
          lineNumber = textEA.getLineOfOffset(textEA.getCaretPosition()) + 1;
          String tempts= JOptionPane.showInputDialog(f3EA, "Go To the Line Number: ", ""+lineNumber);
          if(tempts==null){
              return;
          }
          lineNumber=Integer.parseInt(tempts);
          textEA.setCaretPosition(textEA.getLineStartOffset(lineNumber -1));
      }catch(Exception ovrIt){
          
      }
  }
  
  /*class replaceBox extends JDialog implements ActionListener{
      Label labl_replace, labl_replacewith;
      TextField text_replace, text_replacewith;
      Button butn_change, butn_close;
      
    void replaceBox(){
          setLayout(null);
          
          labl_replace= new Label("Replace");
          labl_replace.setBounds(50, 50, 100, 30);
          add(labl_replace);
          
          text_replace= new TextField();
          text_replace.setBounds(100, 50, 100, 30);
          add(text_replace);
          
          labl_replacewith= new Label("Replace With");
          labl_replacewith.setBounds(50, 100, 100, 30);
          add(labl_replacewith);
          
          text_replacewith= new TextField();
          text_replacewith.setBounds(100, 100, 100, 30);
          add(text_replacewith);
          
          butn_change= new Button("Change");
          butn_change.setBounds(50, 150, 50, 30);
          add(butn_change);
          
          butn_close= new Button("Close");
          butn_close.setBounds(75, 150, 125, 30);
          add(butn_close);
          
          addWindowListener(new WindowAdapter()
          {
              public void windowClosing(WindowEvent we){
                  System.exit(0);
              }
          });
      }
      public void actionPerformed(ActionEvent ae){
          if(ae.getSource().equals(butn_change))
          {
              
          }
      }
  } */  
  public void actionPerformed(ActionEvent e){
       
       if(e.getSource().equals(newEA))
       {
           textEA.setText("");
       }
       if(e.getSource().equals(exitEA))
       {
           System.exit(0);
       }
       if(e.getSource().equals(openEA))
       {
           textEA.setText("");
           int idk = pickEA.showOpenDialog(this);
           
           if(idk == JFileChooser.APPROVE_OPTION)
           {
               try{
                   Scanner scann= new Scanner(pickEA.getSelectedFile());
                   while(scann.hasNext())
                   {
                       String strung = scann.nextLine();
                       textEA.append(strung + "n");
                   }
               }
               catch(FileNotFoundException fnE){
                   System.out.println(fnE);
               }
           }
        
       }
       if(e.getSource().equals(saveEA)){
          int wta= pickEA.showSaveDialog(this);
           if(wta== JFileChooser.APPROVE_OPTION){
               
               try{
                   FileWriter saved = new FileWriter(pickEA.getSelectedFile());
                   File select = pickEA.getSelectedFile();
                   if(select.exists()){
                       JOptionPane.showMessageDialog(null, "file exists, enter another name");
                   }
                   else{
                       BufferedWriter writ = new BufferedWriter(saved);
                       inpEA= new Scanner(textEA.getText());
                       while(inpEA.hasNext()){
                           writ.write(inpEA.nextLine());
                           writ.newLine();
                       }
                       writ.close();
                   }
               }
               catch(IOException exc){
                   System.out.println(exc);
               }
           
            }
        }
       //if statement for replace*************************************************************************************************
       if(e.getSource().equals(replaceEA))
       {
          //replaceBox();
          try{
              String oldSEA= text_replaceEA.getText();
              String newSEA= text_replacewithEA.getText();
              String wordToReplace= textEA.getText().replaceAll(oldSEA, newSEA);
              textEA.setText(wordToReplace);
              
              if(e.getActionCommand().equals("Close")){
                  f3EA.setVisible(false);
              }
          }catch(Exception be){
              System.out.println(e);
          }
       }
       
       if(e.getSource().equals(goToEA))
       {
         goTo();
       }
       //if statement for green
       if(e.getSource().equals(greenEA))
       {
           textEA.setForeground(Color.green);
           
       }
       //if statement for red
       if(e.getSource().equals(redEA))
       {
           textEA.setForeground(Color.red);
           
       }
       //if statement for help to open the word doc i created.*****************************************************************************
       if(e.getSource().equals(helpEA))
       {
           new AboutEA().setVisible(true);

           
           /*System.out.println("Ebun Blessing Adebesin\n" +
"           Java II\n" +
"           Dr Primo Abena\n" +
"           11/18/2021\n" +
"           \n" +
"           Notepad Help doc\n" +
"           \n" +
"           This application is a simple GUI JAVA Application with features that works similar to the Microsoft notepad. Here are the following functions/ features that the application has. This application will enable a user of the application to view and edit a text file.\n" +
"           \n" +
"           When the application is opened, the first thing the user sees is a blank text area with menus at the top, scrollbars horizontally and vertically and the line and column number at the bottom right of the page. Here is an image below.\n" +
"           \n" +
"           \n" +
"           The next feature is the menu bar. \n" +
"           Firstly, we have the file section. \n" +
"           The file section comprises of the new, open, save and exit menu item\n" +
"           •	The “new” menu item in the file section essentially creates a new text field and clears the previous document. It can also be activated by CTRL N.\n" +
"           •	The “open” menu item in the file section is able to open an existing .txt document in the available pane. It can also be activated by CTRL O.\n" +
"           \n" +
"           •	The “save” menu item in the file section saves all open documents. It can also be activated by CTRL S.\n" +
"           \n" +
"           •	The “exit” menu item in the file section closes and saves the open document then closes the application. It can also be activated by CTRL X.\n" +
"           \n" +
"           The second feature on the menu bar is the edit section.\n" +
"           The Edit section consist of the Go To, replace, font and line bar menu item\n" +
"           •	The “Go To” menu item in the edit section takes the user to a particular line number in the open \n" +
"           document.\n" +
"           •	The “Replace” menu item in the edit section allows the user to replace a supplied string with \n" +
"           another supplied string in the open document.\n" +
"           \n" +
"           •	The “Font” menu item in the edit section allows the user to edit the font style, font type and font size.\n" +
"            \n" +
"           \n" +
"           The third feature on the menu bar is the Format section.\n" +
"           The Format section consist of green and red menu item.\n" +
"           •	The “Green” menu item in the format section displays all the lines in the open file in the color green.\n" +
"           \n" +
"           •	The “Red” menu item in the format section displays all the lines in the open file in the color red.\n" +
"            \n" +
"           \n" +
"           The last feature on the menu bar is the Help section\n" +
"           The help section provides the user with a text document explaining all the options coded into the application which is the document you are reading now.\n" +
"           \n" +
"           ");*/
           
           //if(wta== JFileChooser.APPROVE_OPTION){
           /* try
           {
                FileReader red = new FileReader("HelpDoc.txt");
                BufferedReader bufR = new BufferedReader(red);
                //Scanner in = new Scanner(red);
                String l;
                while((l = bufR.readLine()) != null)
                {
                     
                    textEA.append(l + "n");
                    System.out.println(l);
                }
                red.close();
            }
            catch (IOException exep)
            {
                exep.printStackTrace();
            }*/
            
            //new MyDialog().setVisible(true);
            
           //}  
            //ReadHelpDoc.setVisible(true);
           //"C:\\Users\\ebadebesin\\OneDrive-Huston-Tillotson University\\Documents\\Notepad Help doc.docx");
       }
       
       if(e.getSource().equals(fontEA))
       {
           f3EA.setVisible(true);
       }
       if(e.getSource().equals(b1EA))
       {
           String ng= (String)cB1EA.getSelectedItem();
           String ng2= (String)cB2EA.getSelectedItem();
           int i1= Integer.parseInt((String)cB3EA.getSelectedItem());
           Font fnt= new Font("Cooper",Font.BOLD,10);
           if(ng2.equals("BOLD"))
           {
               fnt= new Font (ng, Font.BOLD,i1);
           }
           if(ng2.equals("ITALIC"))
           {
               fnt= new Font(ng, Font.ITALIC,i1);
           }
           textEA.setFont(fnt);
           JOptionPane.showMessageDialog(null,"font changed");
           f3EA.setVisible(false);
       }
       if(e.getSource().equals(b2EA))
        f3EA.setVisible(false);
       
       
   }
   
   /*public void AboutEA(){
       
       //f3EA.setVisible(true);
       try
           {
                FileReader redEA = new FileReader("C:\\Users\\ebadebesin\\OneDrive - Huston-Tillotson University\\Documents\\HelpDoc.txt");
                BufferedReader bufR = new BufferedReader(redEA);
                textEA.setText("");
                String lEA;
                
                
                while((lEA = bufR.readLine()) != null){
                     
                   
                   textEA.append(lEA + "\n");
                }
                bufR.close();
            }
            catch (Exception exep)
            {
                System.out.println("File not opened");
            }
   }*/
   

}

