package bustra;

import java.awt.Point;
import java.awt.event.KeyEvent;

public class User {
  
  //-- フィールド
  private int score;
  private int boardSize;
  private Score userScore;
  private Point position;
  
  //-- コンストラクタ
  public User(int boardSize) {
    
    score = 0;
    this.boardSize = boardSize;
    
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
      case KeyEvent.VK_RIGHT:
        if ( position.x+1 > this.boardSize ) { return; }
        position.move(position.x+1, position.y); break;  // right
      case KeyEvent.VK_LEFT:
        if ( position.x-1 < 0 ) { return; }
        position.move(position.x-1, position.y); break;  // left
      case KeyEvent.VK_UP:
        if ( position.y-1 < 0 ) { return; }
        position.move(position.x, position.y-1); break;  // up
      case KeyEvent.VK_DOWN:
        if ( position.y+1 > this.boardSize ) { return; }
        position.move(position.x, position.y+1); break;  // down
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
