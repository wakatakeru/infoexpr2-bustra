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
      
      case VK_RIGHT: point.move(point.getX()+1, point,getY()); break;  // right
      case VK_LEFT:  point.move(point.getX()-1, point,getY()); break;  // left
      case VK_UP:    point.move(point.getX(), point,getY()-1); break;  // up
      case VK_DOWN:  point.move(point.getX(), point,getY()+1); break;  // down
      default: /* do not move */ break;
      
    }
    
  }

  // scoreを返却
  public int getScore() {
    
    return score;
    
  }

  // スコアにpointを加算 (true,falseの扱い)(getScoreとsetScoreの明確な役割)
  private boolean setScore() {
    
    score = userScore.getPoint();
    return true;
    
  }

}
