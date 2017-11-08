package bustra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import static java.awt.Color.*;

public class Board extends JPanel {
  private static final long serialVersionUID = 1L;
  private int size;
  private int eraseBlocksCount = 0;
  private int erasingCount = 0;
  private int blockSize;
  private Block[][] blocks;
 
  public Board(int boardSize) {
    this.size = boardSize;
    this.blockSize = Constants.BLOCKSIZE;

    blocks = new Block[boardSize][boardSize];
    
    for ( int y = 0; y < size; y++ ) {
      for ( int x = 0; x < size; x++ ) {
        blocks[x][y] = new Block();
      }
    }

    setPreferredSize(new Dimension(size * blockSize, size * blockSize));
    setFocusable(true);
  }

  public static boolean moveBlock(int hand) {
    return true; 
  }

  // detectLineを定義する

  public void paint(Graphics g) {
    for (int y = 0; y < size; y++) {
      for (int x = 0; x < size; x++) {
        g.setColor(blocks[x][y].getFace());
        g.fillOval(x * this.blockSize, y * this.blockSize, this.blockSize, this.blockSize);
      } 
    }
  }
  
  public static int getErasedBlocksCount() {

    // 動作テスト
    return 0;
  }

  public static int getErasingCount() {
    
    // 動作テスト
    return 0;
  }

  private static boolean  eraseBlocks() {

    // 動作テスト
    return true;
  }
  
  private static boolean slideBlocks() {

    // 動作テスト
    return true;
  }
  
  private static boolean appendBlocks() {

    // 動作テスト
    return true;
  }

  // デバッグ用メイン関数
  public static void main(String args[]) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Board");
      
      frame.add(new Board(10));
      frame.pack();
      frame.setVisible(true);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}
