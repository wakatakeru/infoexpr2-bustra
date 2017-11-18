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

public class EndMenu extends Menu implements Runnable {
  
  private String userName;
  private int userScore;
  private int width, hight;
  private JLabel labelEnd, labelScore;
  private JButton sendButton;
  
  public EndMenu(int score, String name) {
    
    width = 300;
    hight = 200;
    userScore = score;
    userName = name;
    setPreferredSize(new Dimension(width, hight));
    setFocusable(true);
    this.disp();
    
  }
  
  
  @Override
  public boolean disp() {
    
    // action
    labelEnd = new JLabel("Game End!");
    labelEnd.setFont(new Font("Arial", Font.PLAIN, 24));
    labelScore = new JLabel("Your score is " + String.valueOf(userScore));
    sendButton = new JButton("Send your score");
    sendButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Client(userName, userScore).postData();
      }
    });
    
    // add and layout
    this.add(labelEnd);
    this.add(getLine(width, 0));
    this.add(labelScore);
    this.add(getLine(width - 18, 1));
    this.add(sendButton);
    
    return true;
    
  }
  
  @Override
  public void run() {
    
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("EndMenu");
      
      frame.add(new EndMenu());
      frame.pack();
      frame.setVisible(true);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
    
  }
  
  /* デバック用
  public static void main(String args[]) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("EndMenu");
      
      frame.add(new EndMenu());
      frame.pack();
      frame.setVisible(true);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
  */
  
}