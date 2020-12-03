 import java.awt.*;  
 import java.awt.event.*;  
 import java.io.*;  
 import java.util.*;  

 class Texteditor extends Frame implements ActionListener  
 {  
     TextArea ta=new TextArea();  
     int i,len1,len,pos1;  
     String str="",s3="",s2="",s4="",s32="",s6="",s7="",s8="",s9="";  
     public Texteditor()  
     {  
         MenuBar mb=new MenuBar();  
         setLayout(new BorderLayout());  
         add("Center",ta);  
         setMenuBar(mb);  
         Menu m1=new Menu("File");  
         Menu m2=new Menu("Edit");  
         
         mb.add(m1);  
         mb.add(m2);  

         MenuItem mi1[]={  
             new MenuItem("New"),
             new MenuItem("Open"),
             new MenuItem("Save As"),
             new MenuItem("Exit")};  
         MenuItem mi2[]={
             new MenuItem("Delete"),
             new MenuItem("Cut"),  
             new MenuItem("Copy"),
             new MenuItem("Paste")};  
             
         for(int i=0;i<mi1.length;i++ ){  
             m1.add(mi1[i]);  
             mi1[i].addActionListener(this);  
         }  
         
         for(int i=0;i<mi2.length;i++){
             m2.add(mi2[i]);  
             mi2[i].addActionListener(this);  
         }  
         
         MyWindowsAdapter mw=new MyWindowsAdapter(this);  
         addWindowListener(mw);  
         setSize(500,500);  
         setTitle("Notepad");  
         setVisible(true);  
     }  
     
     public void actionPerformed(ActionEvent ae)  
     {  
         String arg=(String)ae.getActionCommand();  
         if(arg.equals("New"))  
         { 
             dispose();  
             Texteditor t11=new Texteditor();  
             t11.setSize(500,500);  
             t11.setVisible(true);  
         }   
         
         try 
         {  
             if(arg.equals("Open"))  
             {  
                 FileDialog fd1=new FileDialog(this,"Select File",FileDialog.LOAD);  
                 fd1.setVisible(true);  
                 String s4="";  
                 s2=fd1.getFile();  
                 s3=fd1.getDirectory();  
                 s32=s3+s2;  
                 File f=new File(s32);  
                 FileInputStream fii=new FileInputStream(f);  
                 len=(int)f.length();  
                 for(int j=0;j<len1;j++ ){  
                     char s5=(char)fii.read();  
                     s4=s4 + s5;  
                 }  
                 ta.setText(s4);  
             }  
         }  
         catch(IOException e)   {   }  
         
         try  
         {  
             if(arg.equals("Save As"))  
             {  
                 FileDialog dialog1=new FileDialog(this,"Save As",FileDialog.SAVE);  
                 dialog1.setVisible(true);  
                 s7=dialog1.getDirectory();  
                 s8=dialog1.getFile();  
                 s9=s7+s8+".txt";  
                 s6=ta.getText();  
                 len1=s6.length();  
                 byte buf[]=s6.getBytes();  
                 File f1=new File(s9);  
                 FileOutputStream fobj1=new FileOutputStream(f1);  
                 for(int k=0;k<len1;k++){  
                     fobj1.write(buf[k]);  
                 }  
                 fobj1.close();  
             }  
             this.setTitle(s8 +" Texteditor File");  
         }  
         catch(IOException e){}  
         
         if(arg.equals("Exit"))  
         {  
             System.exit(0);  
         }  
         
         if(arg.equals("Cut"))  
         {  
             str=ta.getSelectedText();  
             i=ta.getText().indexOf(str);  
             ta.replaceRange(" ",i,i+str.length());  
         }  
         
         if(arg.equals("Copy"))  
         {  
             str=ta.getSelectedText();  
         }  
         
         if(arg.equals("Paste"))  
         {  
             pos1=ta.getCaretPosition();  
             ta.insert(str,pos1);  
         }  
         
         if(arg.equals("Delete"))  
         {  
             String msg=ta.getSelectedText();  
             i=ta.getText().indexOf(msg);  
             ta.replaceRange(" ",i,i+msg.length());  
             msg="";  
         }  
     }
 }