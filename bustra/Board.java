package bustra;

import java.util.ArrayList;

import java.awt.Color;
import java.awt.Color.*;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel {
  private static final long serialVersionUID = 1L;
  private int size;
  private int eraseBlocksCount = 0;
  private int erasingCount = 0;
  private int blockSize;
  private Block[][] blocks;

  // コンストラクタ
  public Board(int boardSize) {
    this.size = boardSize;
    this.blockSize = Constants.BLOCKSIZE;

    // ボード上のブロックの定義
    blocks = new Block[boardSize][boardSize];

    // ボードの初期配置設定
    this.initBoard();
    
    setPreferredSize(new Dimension(size * Constants.CIRCLE, size * Constants.CIRCLE));
    setFocusable(true);
  }

  public boolean eraseDetectedLines() {
    Point erasingPoint = new Point();
    ArrayList<Point> detectedLine = new ArrayList<Point>();

    // 連の検出数とブロックの個数を初期化
    eraseBlocksCount = 0;
    erasingCount = 0;
    
    // 3連を検出
    detectedLine = this.detectLine();
    
    // 3連がなくなるまで削除を続ける
    while ( detectedLine.size() != 0 ) {
      for ( int i = 0; i < detectedLine.size(); i++ ) {
        // 消す連の左端の一つを取得                                                                                                                                                                                                   
        erasingPoint = detectedLine.get(i);

        // ボードの更新処理                                                                                                                                                                                                           
        this.eraseBlocks(erasingPoint);
        this.slideBlocks(erasingPoint);
        this.appendBlocks(erasingPoint);
      }

      detectedLine = this.detectLine();                                                                                                                                                                                              
    }

    return true;
  }
  
  // プレイヤの移動にともなって石を移動させる
  public boolean moveBlock(Point userPoint, int key) {
    Point dp = new Point((int)userPoint.getX(), (int)userPoint.getY());

    switch ( key ) {
    case KeyEvent.VK_LEFT:
      if ( (int)userPoint.getX() - 1 < 0 ) { return false; }
      dp.move((int)dp.getX() - 1, (int)dp.getY());
      swapBlocks(userPoint, dp);
      break;
    case KeyEvent.VK_RIGHT: 
      if ( (int)userPoint.getX() + 1 > this.size ) { return false; }
      dp.move((int)dp.getX() + 1, (int)dp.getY());
      swapBlocks(userPoint, dp);
      break;
    case KeyEvent.VK_UP:
      if ( (int)userPoint.getY() - 1 < 0 ) { return false; }
      dp.move((int)dp.getX(), (int)dp.getY() - 1);
      swapBlocks(userPoint, dp);
      break;
    case KeyEvent.VK_DOWN:
      if ( (int)userPoint.getY() + 1 > this.size ) { return false; }
      dp.move((int)dp.getX(), (int)dp.getY() + 1);
      swapBlocks(userPoint, dp);
      break;
    default:
      return false;
    }

    repaint();
    return true;
  }

  // 消したブロックの個数を返却
  public int getErasedBlocksCount() {
    return eraseBlocksCount;
  }

  // コンボした回数を返却する
  public  int getErasingCount() {
    return erasingCount;
  }

  // ボードの初期設定
  private boolean initBoard() {
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

  // 連の検出
  private ArrayList<Point> detectLine() {
    ArrayList<Point> points = new ArrayList<Point>();

    for ( int y = 0; y < size; y++ ) {
      for ( int x = 1; x < size - 1; x++ ) {
        if ( !blocks[x][y].isEqual(blocks[x - 1][y]) ) { continue; }
        if ( !blocks[x][y].isEqual(blocks[x + 1][y]) ) { continue; }
        points.add(new Point(x - 1, y));
      }
    }

    eraseBlocksCount += points.size() * Constants.COMBO_LINE;
    erasingCount += points.size();
    
    return points;
  }

  // ボードの描写
  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;
    
    for ( int y = 0; y < size; y++ ) {
      for ( int x = 0; x < size; x++ ) {
        if ( blocks[x][y] == null ) { continue; }
        g2.drawImage(blocks[x][y].getFaceImage(),
                     x * Constants.CIRCLE + Constants.GAP,
                     y * Constants.CIRCLE + Constants.GAP,
                     Constants.CIRCLE - 2 * Constants.GAP,
                     Constants.CIRCLE - 2 * Constants.GAP,
                     null
                     );
      } 
    }
  }

  // 任意の点とその右隣の点をCOMBO_LINE個だけ削除するメソッド
  private boolean eraseBlocks(Point point) {
    int x, y;
    int dx;

    x = (int)point.getX();
    y = (int)point.getY();

    for ( dx = x; dx < x + Constants.COMBO_LINE; dx++ ) {
      blocks[dx][y] = null;
    }
    
    return true;
  }

  // ブロックを盤面の下にずらす
  private boolean slideBlocks(Point point) {
    int x, y;
    int dx, dy;
    
    x = (int)point.getX();
    y = (int)point.getY();

    for ( dy = y - 1; dy >= 0; dy-- ) {
      for ( dx = x; dx < x + Constants.COMBO_LINE; dx++ ) {
        blocks[dx][dy + 1] = blocks[dx][dy];
      }
    }
    
    return true;
  }

  // 盤面の空白となった場所にブロックを追加
  private boolean appendBlocks(Point point) {
    int x;
    int dx, dy;
    
    x = (int)point.getX();

    for ( dx = x; dx < x + Constants.COMBO_LINE; dx++ ) {
      blocks[dx][0] = new Block();    // ブロックが最後までずらされると一番上がブロック無しになるからy=0
    }

    return true;
  }

  // ブロック同士を交換する
  private boolean swapBlocks(Point p1, Point p2) {
    // p1についてのバリデーション
    if ( (int)p1.getX() < 0 || (int)p1.getX() >= size ) { return false; }
    if ( (int)p1.getY() < 0 || (int)p1.getY() >= size ) { return false; }

    // p2についてのバリデーション
    if ( (int)p2.getX() < 0 || (int)p2.getX() >= size ) { return false; }
    if ( (int)p2.getY() < 0 || (int)p2.getY() >= size ) { return false; }

    Block tmp = new Block();

    tmp = blocks[(int)p1.getX()][(int)p1.getY()];
    blocks[(int)p1.getX()][(int)p1.getY()] = blocks[(int)p2.getX()][(int)p2.getY()];
    blocks[(int)p2.getX()][(int)p2.getY()] = tmp;
    
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
