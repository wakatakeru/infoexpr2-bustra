package bustra;

import java.awt.Point;
import java.awt.event.KeyEvent;

public class User {
  
  //-- フィールド
  private int score;
  private Score userScore;
  private Point position;
  
  //-- コンストラクタ
  public User() {
    
    score = 0;
    userScore = new Score();
    position = new Point();
    
  }

  //-- メソッド
  // positionの返却
  public Point getPosition() {
    
    return position;
    
  }
  
  // key入力によるpositionの更新
  public void movePosition(int key) {
    
    switch ( key ) {
      
    case KeyEvent.VK_RIGHT: position.move((int)position.getX() + 1, (int)position.getY()); break;  // right
    case KeyEvent.VK_LEFT:  position.move((int)position.getX() - 1, (int)position.getY()); break;  // left
    case KeyEvent.VK_UP:    position.move((int)position.getX(), (int)position.getY() - 1); break;  // up
    case KeyEvent.VK_DOWN:  position.move((int)position.getX(), (int)position.getY() + 1); break;  // down
    default: /* do not move */ break;
      
    }
    
  }

  // scoreをセットし返却
  public int getScore() {
    
    setScore();
    return score;
    
  }

  // スコアにpointを加算
  private boolean setScore() {
    
    score = userScore.getPoint();
    return true;
    
  }

}
