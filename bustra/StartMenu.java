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

public class StartMenu extends Menu implements Runnable {
  
  private String userName;
  private static int boardSize;
  private int width, hight;
  private JLabel labelTitle, labelName, labelSize;
  private JTextField fieldName;
  private JTextField fieldSize;
  private JButton startButton;
  
  public StartMenu() {
    
    width = 300;
    hight = 200;
    setPreferredSize(new Dimension(width, hight));
    setFocusable(true);
    this.disp();
    
  }
  
  // userName 返却
  public String getUserName() {
    
    return this.userName;
  
  }

  // boardSize 返却
  public int getBoardSize() {
    
    return this.boardSize;
  
  }
  
  @Override
  public boolean disp() {
    
    // action
    fieldName = new JTextField("", 10);
    fieldSize = new JTextField("", 10);
    startButton = new JButton("ゲームスタート");
    startButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        userName = fieldName.getText();
        boardSize = Integer.parseInt(fieldSize.getText());
      }
    });
    labelTitle = new JLabel("Bustra!");
    labelTitle.setFont(new Font("Arial", Font.PLAIN, 24));
    labelName = new JLabel("Your Name");
    labelSize = new JLabel("Board Size");
    
    // add and layout
    setLayout(new FlowLayout());
    this.add(labelTitle);
    this.add(getLine(width, 0));
    this.add(labelName);
    this.add(fieldName);
    this.add(getLine(width, 0));
    this.add(labelSize);
    this.add(fieldSize);
    this.add(getLine(width, 0));
    this.add(getLine(width - 18, 1));
    this.add(startButton);
    this.add(getLine(width, 0));
    
    return true;
    
  }
  
  public void run() {
    
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("StartMenu");
      
      frame.add(new StartMenu());
      frame.pack();
      frame.setVisible(true);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
    
  }
  
  /* デバック用
  public static void main(String args[]) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("StartMenu");
      
      frame.add(new StartMenu());
      frame.pack();
      frame.setVisible(true);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
  */
  
}