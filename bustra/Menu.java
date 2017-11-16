package bustra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Menu extends JPanel {
  private int boardSize;
  
  public Menu() {
    boardSize = 0;
    setPreferredSize(new Dimension(240, 320));
  }

  @Override
  public void paint(Graphics g) {

  }

  public static boolean dispGameStart(int hand) {
    // hotfix
    return true;
  }

  public static boolean dispGameEnd(int hand) {
    // hotfix
    return true;
  }

  public static int getBoardSize() {
    // hotfix
    return 0;
  }

  public static boolean setBoardSize(int hand) {
    // hotfix
    return true;
  }

  // デバッグ用メイン関数
  public static void main(String args[]) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Menu");
      
      frame.add(new Menu());
      frame.pack();
      frame.setVisible(true);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}
