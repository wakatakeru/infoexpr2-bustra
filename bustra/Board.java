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
  // 定数はConstantsクラスに格納したい…したくない？
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

    this.setupBoard();
    
    setPreferredSize(new Dimension(size * blockSize, size * blockSize));
    setFocusable(true);
  }

  // 未実装(Userクラスできたら作ります(はず))
  protected boolean moveBlock(int hand) {
    return true; 
  }

  protected int getErasedBlocksCount() {
    return eraseBlocksCount;
  }

  protected int getErasingCount() {
    return erasingCount;
  }
  
  private boolean setupBoard() {
    ArrayList<Point> points = new ArrayList<Point>();

    // ボードの初期化
    for ( int y = 0; y < size; y++ ) {
      for ( int x = 0; x < size; x++ ) {
        blocks[x][y] = new Block();
      }
    }

    // 初期ボードからの連検出
    points = detectLine();

    // 連が検出されなくなるまで連の削除を続ける
    while ( points.size() != 0 ) {
      for ( int i = 0; i < points.size(); i++ ) {
        eraseBlocks(points.get(i));      
        slideBlocks(points.get(i));
        appendBlocks(points.get(i));
      }
      points = detectLine();
    }

    return true;
  }

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

  // 任意の点とその右隣の点をCOMBO_LINE個だけ削除するメソッド
  private boolean eraseBlocks(Point point) {
    int x, y;
    int dx;

    x = (int)point.getX();
    y = (int)point.getY();

    for ( dx = x; dx < x + COMBO_LINE; dx++ ) {
      blocks[dx][y] = null;
    }
    
    return true;
  }
  
  private boolean slideBlocks(Point point) {
    int x, y;
    int dx, dy;
    
    x = (int)point.getX();
    y = (int)point.getY();

    for ( dy = y - 1; dy >= 0; dy-- ) {
      for ( dx = x; dx < x + COMBO_LINE; dx++ ) {
        blocks[dx][dy + 1] = blocks[dx][dy];
      }
    }
    
    return true;
  }
  
  private boolean appendBlocks(Point point) {
    int x;
    int dx, dy;
    
    x = (int)point.getX();

    for ( dx = x; dx < x + COMBO_LINE; dx++ ) {
      blocks[dx][0] = new Block();    // ブロックが最後までずらされると一番上がブロック無しになるからy=0
    }

    return true;
  }

  // デバッグ用メイン関数
  public static void main(String args[]) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Board");
      
      frame.add(new Board(8));
      frame.pack();
      frame.setVisible(true);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}
