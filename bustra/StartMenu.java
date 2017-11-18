package bustra;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

public class StartMenu extends JFrame implements Runnable {
  
  private static String userName;
  private static int width, height;
  private static JLabel labelTitle, labelName;
  private static JTextField fieldName;
  private static JButton startButton;
  private static JPanel p;
  private Container contentPane;
  private static boolean inputFlag;
  
  public StartMenu() {
    p = new JPanel();
    contentPane = getContentPane();  

    inputFlag = false;
    
    width = 300;
    height = 200;

    setTitle("StartMenu");
    setSize(width, height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    
    p.setPreferredSize(new Dimension(width, height));
    p.setFocusable(true);


    fieldName = new JTextField("", 10);
    startButton = new JButton("ゲームスタート");

    startButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        userName = fieldName.getText();
        inputFlag = true;
      }
    });

    labelTitle = new JLabel("Bustra!");
    labelTitle.setFont(new Font("Arial", Font.PLAIN, 24));
    labelName = new JLabel("Your Name");

    p.add(labelTitle);
    p.add(getLine(width, 0));
    p.add(labelName);
    p.add(fieldName);
    p.add(getLine(width, 0));
    p.add(getLine(width - 18, 1));
    p.add(startButton);
    p.add(getLine(width, 0));
    
    contentPane.add(p);
  }
  
  
  // userName 返却
  public static String getUserName() {
    return userName;
  }

  public static JSeparator getLine(int wid, int hig) {
    JSeparator sp = new JSeparator(JSeparator.HORIZONTAL);
    sp.setPreferredSize(new Dimension(wid, hig));
    return sp;
  }
  
  @Override
  public void run() {
    StartMenu frame = new StartMenu();
    frame.setVisible(true);
  }
  
  public static void main(String args[]) {
    StartMenu frame = new StartMenu();
    frame.setVisible(true);
  }
}
