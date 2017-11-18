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
import java.awt.Desktop;

import java.net.URI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

public class EndMenu extends JFrame implements Runnable {
  
  private String userName;
  private int userScore;
  private int width, height;
  private JLabel labelEnd, labelScore, labelName;
  private JTextField fieldName;
  private JButton sendButton;
  private static JPanel p;
  private Container contentPane;
  private Client client;
  Desktop desktop;
  URI uri;
  
  public EndMenu(int score) {
    
    p = new JPanel();
    contentPane = getContentPane();  
    width = 300;
    height = 200;
    userScore = score;
    
    setTitle("EndMenu");
    setSize(width, height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    
    p.setPreferredSize(new Dimension(width, height));
    p.setFocusable(true);
    
    labelEnd = new JLabel("Game End");
    labelEnd.setFont(new Font("Arial", Font.PLAIN, 24));
    labelScore = new JLabel("Your score is " + String.valueOf(userScore));
    fieldName = new JTextField("", 8);
    labelName = new JLabel("Your Name :");
    sendButton = new JButton("Send your score");
    sendButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        userName = fieldName.getText();
        client = new Client(userName, userScore);
        client.postData();
        desktop = Desktop.getDesktop();
        try{
          uri = new URI( Constants.URL );
          desktop.browse( uri );
        } catch( Exception ie ) {
          ie.printStackTrace();
        }
        System.exit(0);
      }
    });
    
    this.add(labelEnd);
    this.add(getLine(width, 0));
    this.add(labelScore);
    this.add(getLine(width - 25, 1));
    this.add(labelName);
    this.add(fieldName);
    this.add(getLine(width, 0));
    this.add(sendButton);
    
    contentPane.add(p);
    
  }
  
  public static JSeparator getLine(int wid, int hig) {
    JSeparator sp = new JSeparator(JSeparator.HORIZONTAL);
    sp.setPreferredSize(new Dimension(wid, hig));
    return sp;
  }
  
  @Override
  public void run() {
    
    EndMenu frame = new EndMenu(userScore);
    frame.setVisible(true);
  
  }
  
}
