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

public class Menu extends JPanel implements Runnable {
  
  private int width = 300;
  private int hight = 200;
  
  public Menu() {
    
    setPreferredSize(new Dimension(width, hight));
    setFocusable(true);
    
  }

  // ディスプレイ
  public boolean disp() {
  
    return true;
  
  }

  // 引数の縦横に応じたラインを返却 ( (width,0)でフローレイアウトの改行として利用 )
  public JSeparator getLine(int wid, int hig) {
    JSeparator sp = new JSeparator(JSeparator.HORIZONTAL);
    sp.setPreferredSize(new Dimension(wid, hig));
    return sp;
  }

  @Override
  public void run() {
    
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Menu");
      
      frame.add(new Menu());
      frame.pack();
      frame.setVisible(true);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
    
  }
  
}
