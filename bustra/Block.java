package bustra;

import java.awt.Color;
import java.awt.Graphics;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Block extends JPanel {
  private static Color face;
  private static int RANGE_OF_COLOR = 4;

  // コンストラクタ
  public Block() {
    face = getRandomColor();
  }

  // ブロックの色を返却するメソッド
  public static Color getFace() {
    return face;
  }

  public void paint(Graphics g) {
    g.setColor(this.getRandomColor());
    g.fillOval(0, 0, 64, 64);
    
  }
  
  // ランダムな色を生成するメソッド
  private static Color getRandomColor() {
    Random rand = new Random();
    int sw = rand.nextInt(RANGE_OF_COLOR);
    Color color = Color.RED;
    
    switch ( sw ) {
    case 0:
      break;
    case 1:
      color = Color.BLUE;
      break;
    case 2:
      color = Color.YELLOW;
      break;
    case 3:
      color = Color.GREEN;
      break;
    }

    return color;
  }

  // テスト用のメインメソッド
  public static void main(String args[]) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Bustra!");       

      frame.add(new Block());
      frame.pack();
      frame.setVisible(true);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      });
  }
}

