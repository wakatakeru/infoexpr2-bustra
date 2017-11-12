package bustra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class Base extends JPanel {
  private Board board;
  private User player;

  public Base() {
    setPreferredSize(new Dimension(240, 320));

    // TODO: board size call by Constants Class
    // Temporary Board Size = 10
    board = new Board(10);
    player = new User();

    setFocusable(true);
    addKeyListener(this);
  }

  @Override
  public void paint(Graphics g) {
    
  }

  public void keyPressed(KeyEvent e) {}
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
