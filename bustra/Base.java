package bustra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;    

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.util.ArrayList;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class Base extends JPanel implements KeyListener {
  private Board board;
  private User player;

  private int boardSize;
  private boolean toggle;
  
  public Base() {
    boardSize = 10;

    setPreferredSize(new Dimension(boardSize * Constants.CIRCLE, boardSize * Constants.CIRCLE));
    
    // TODO: board size call by Constants Class
    // Temporary Board Size = 10
    board = new Board(boardSize);
    player = new User(boardSize);

    toggle = false;
    
    setFocusable(true);
    addKeyListener(this);
  }

  @Override
  public void paint(Graphics g) {
    // バックグラウンドの削除
    g.clearRect(0, 0, boardSize * Constants.BLOCKSIZE, boardSize * Constants.BLOCKSIZE);

    // フォーカスの描写
    if ( toggle ) {
      g.setColor(Color.BLACK);
    } else {
      g.setColor(Color.GRAY);
    }
    
    g.fillOval(
               (int)player.getPosition().getX() * Constants.CIRCLE,
               (int)player.getPosition().getY() * Constants.CIRCLE,
               Constants.CIRCLE,
               Constants.CIRCLE
               );
    board.paint(g);
  }

  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    Point erasingPoint = new Point();
    ArrayList<Point> detectedLine = new ArrayList<Point>();
    
    // In GameかIn Menuかで処理変わりそう
    // ひとまずIn Gameの実装
    switch ( key ) {
    case VK_SPACE:
      toggle = !toggle;
      if ( !toggle ) {
        //==== Determination Process
        // 消す場所の左端を取ってくる
        detectedLine = board.detectLine();
        while ( detectedLine.size() != 0 ) {
          for ( int i = 0; i < detectedLine.size(); i++ ) {
            // 消す連の左端の一つを取得
            erasingPoint = detectedLine.get(i);

            // ボードの更新処理
            board.eraseBlocks(erasingPoint);
            board.slideBlocks(erasingPoint);
            board.appendBlocks(erasingPoint);
          }

          detectedLine = board.detectLine();
        }
        // 得点更新する(Pending)
      }
      break;
    default:
      // movePositionにキーを渡してplayerを移動させる
      if ( toggle ) { board.moveBlock(player.getPosition(), key); }
      player.movePosition(key);
    }

    repaint();
  }
  
  public void keyReleased(KeyEvent e) {}

  public void keyTyped(KeyEvent e) {}
  
  public static void main(String args[]) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Bustra!");       

      frame.add(new Base());
      frame.pack();
      frame.setVisible(true);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}
