package bustra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import java.util.ArrayList;

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
  private final int COMBO_LINE = 3;
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

    //---- デバッグ用プログラム
    ArrayList<Point> points = new ArrayList<Point>();

    points = detectLine();

    for ( int i = 0; i < points.size(); i++ ) {
      eraseBlocks(points.get(i));      
    }
    //---- デバッグ用プログラム終
    
    setPreferredSize(new Dimension(size * blockSize, size * blockSize));
    setFocusable(true);
  }

  public static boolean moveBlock(int hand) {
    return true; 
  }

  // detectLineを定義する
  private ArrayList<Point> detectLine() {
    ArrayList<Point> points = new ArrayList<Point>();

    for ( int y = 0; y < size; y++ ) {
      for ( int x = 1; x < size - 1; x++ ) {
        if ( !blocks[x][y].isEqual(blocks[x - 1][y]) ) { continue; }
        if ( !blocks[x][y].isEqual(blocks[x + 1][y]) ) { continue; }
        points.add(new Point(x - 1, y));
      }
    }
    
    return points;
  }
  
  public void paint(Graphics g) {
    for (int y = 0; y < size; y++) {
      for (int x = 0; x < size; x++) {
        if ( blocks[x][y] == null ) { continue; }
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

  private boolean eraseBlocks(Point point) {
    int x, y;
    int dx;

    x = (int)point.getX();
    y = (int)point.getY();
    
    for ( dx = x; dx < x + COMBO_LINE; dx++ ) {
      blocks[dx][y] = null;
    }
    
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
      
      frame.add(new Board(15));
      frame.pack();
      frame.setVisible(true);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}
