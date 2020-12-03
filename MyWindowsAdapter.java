import java.awt.*;  
import java.awt.event.*;  
import java.io.*;  
import java.util.*;  
public class MyWindowsAdapter extends WindowAdapter  
     {  
         Texteditor tt;  
         public MyWindowsAdapter(Texteditor ttt)  
         {  
             tt=ttt;  
         }  
         
         public void windowClosing(WindowEvent we)  
         {  
             tt.dispose();  
         }  
     }   