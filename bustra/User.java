package bustra;

import java.awt.Point;
import java.awt.event.KeyEvent;

public class User {
  
  //-- フィールド
  private int score;
  private Score user_score;
  private Point position;
  
  //-- コンストラクタ
  public User() {
    
    score = 0;
    user_score = new Score();
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
      
      case VK_RIGHT: position.x++; break;  // right
      case VK_LEFT:  position.x--; break;  // left
      case VK_UP:    position.y--; break;  // up
      case VK_DOWN:  position.y++; break;  // down
      
      default: /* do not move */ break;
      
    }
    
  }

  // scoreを返却
  public int getScore() {
    
    return score;
    
  }

  // スコアにpointを加算 (true,falseの扱い)(getScoreとsetScoreの明確な役割)
  private boolean setScore() {
    
    score = user_score.getPoint();
    
    return true;
    
  }

}
