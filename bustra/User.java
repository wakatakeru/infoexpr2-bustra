package bustra;

import java.awt.Point;

import java.util.*;  // Mapで必要?

public class User implements KeyListener {
  
  //-- フィールド
  private int score;
  private Score user_score = new Score();
  private Point position;
  
  //-- コンストラクタ
  public User() {
    
    score = 0;
    position.put("x", 0);
    position.put("y", 0);
    
  }

  //-- メソッド
  // positionの返却
  public Map getPosition() {
    
    return position;
    
  }
  
  // getHandで返却される整数値でのpositionの更新
  public void movePosition(int hand) {
    
    switch ( hand ) {
      
      case 0: position.put("x", position.get("x") + 1); break;  // right
      case 1: position.put("x", position.get("x") - 1); break;  // left
      case 2: position.put("y", position.get("y") - 1); break;  // up
      case 3: position.put("y", position.get("y") + 1); break;  // down
      
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
