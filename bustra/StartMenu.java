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
import java.awt.event.WindowEvent;

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
  private static JLabel labelTitle;
  private static JPanel p;
  private Container contentPane;
  
  public StartMenu() {
    p = new JPanel();
    contentPane = getContentPane();  

    width = 300;
    height = 100;

    setTitle("StartMenu");
    setSize(width, height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    
    p.setPreferredSize(new Dimension(width, height));
    p.setFocusable(true);

    labelTitle = new JLabel("Bustra!");
    labelTitle.setFont(new Font("Arial", Font.PLAIN, 24));

    p.add(labelTitle);
    
    contentPane.add(p);
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
    try{
      Thread.sleep(2000);
    }catch (InterruptedException e) {}
  }
  
  public static void main(String args[]) {
    StartMenu frame = new StartMenu();
    frame.setVisible(true);
  }
}
