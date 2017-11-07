package bustra;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.awt.event.KeyEvent.*;

import java.util.*;  // Mapで必要?

public class User implements KeyListener {
  
  //-- フィールド
  private int score;
  private Map<Character, Integer> position = new HashMap<Character, Integer>();
  
  //-- コンストラクタ
  public User() {
    
    addKeyListener(this);
    
    score = 0;
    position.put(x, 0);
    position.put(y, 0);
    
  }

  //-- メソッド
  // キー入力をint型に変換 (他キーも追加可能) (現時点での return 5　の有無相談)
  public int getHand(KeyEvent e) {
    
    switch ( e ) {
      
      case VK_RIGHT: return 0;    // right
      case VK_LEFT:  return 1;    // left
      case VK_UP:    return 2;    // up
      case VK_DOWN:  return 3;    // down
      case VK_SPACE: return 4;    // space
      case default:  return 5;    // another key
      
    }
    
  }

  // キー入力によるpositionの移動を行った後positionを返却 (単にposition返すだけでも良い?)
  public Map getPosition() {
    
    switch ( getHand() ) {
      
      case 0: position.put(x, position.get(x) + 1); break;  // right
      case 1: position.put(x, position.get(x) - 1); break;  // left
      case 2: position.put(y, position.get(y) - 1); break;  // up
      case 3: position.put(y, position.get(y) + 1); break;  // down
      
      case default: /* do not move */ break;
      
    }
    
    return position;
    
  }

  // Scoreクラスからpointを取り出す
  public int getScore() {
    
    return getPoint();
    
  }

  // スコアにpointを加算 (true,falseの扱い)(getScoreとsetScoreの明確な役割)
  private boolean setScore {
    
    score += getScore();
    
    return true;
    
  }

  //-- keyListener
  // keypress時の処理をどうするか
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
  }

  public void keyReleased(KeyEvent e) {}

  public void keyTyped(KeyEvent e) {}
}
