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

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

import static java.awt.event.KeyEvent.*;

public class Game extends JPanel implements KeyListener, Runnable {
  private Board board;
  private static User player;

  private int boardSize;
  private boolean toggle;
  
  public Game() {
    boardSize = Constants.BOARD_SIZE;

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
  
  public static int getScore() {
    return player.getScore();
  }

  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    Clip clip = null;
    AudioInputStream audioInputStream;
    
    try {
      File soundFile = new File("bin//se_move01.wav");
      audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      AudioFormat audioFormat = audioInputStream.getFormat();
      DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
      clip = (Clip)AudioSystem.getLine(info);
      clip.open(audioInputStream);
      switch ( key ) {
      case VK_SPACE:
        toggle = !toggle;
        if ( !toggle ) {
          board.eraseDetectedLines();
          // 得点更新する(Pending)
          player.addScore(board.getErasingCount(), board.getErasedBlocksCount());

          // 得点のコンソール表示
          System.out.println(player.getScore());
        }
        break;
      default:
        // movePositionにキーを渡してplayerを移動させる
        if ( toggle ) {
          clip.start();
          board.moveBlock(player.getPosition(), key);
        }
        player.movePosition(key);
      }
      clip.stop();
    } catch (UnsupportedAudioFileException ex) {
      ex.printStackTrace();
    } catch (IOException ex) {
      ex.printStackTrace();
    } catch (LineUnavailableException ex) {
      ex.printStackTrace();
    }

    repaint();
  }
  
  public void keyReleased(KeyEvent e) {}

  public void keyTyped(KeyEvent e) {}
  
  @Override
  public void run() {
    JFrame frame = new JFrame("Bustra!");       

    try {
      Thread.sleep(1000);
      SwingUtilities.invokeLater(() -> {
          frame.add(new Game());
          frame.pack();
          frame.setVisible(true);

          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    } catch (InterruptedException e) { }
  }
}
