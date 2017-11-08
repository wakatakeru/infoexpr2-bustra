package bustra;

import java.awt.Color;
import java.awt.Graphics;

public class Block {
  private Color face;
  private static int RANGE_OF_COLOR = 4;

  // コンストラクタ
  public Block() {
    this.face = getRandomColor();
  }

  // ブロックの色を返却するメソッド
  protected Color getFace() {
    return this.face;
  }

  // 対象のブロックが同じ色かどうかを判定する
  protected boolean isEqual(Block block) {
    if ( face != block.getFace() ) { return false; }
    return true;
  }
  
  // ランダムな色を生成するメソッド
  private static Color getRandomColor() {
    double rand;
    int sw;
    Color color = Color.RED;

    rand = Math.random();
    sw = (int)(rand * RANGE_OF_COLOR);
    
    switch ( sw ) {
    case 0:
      break;
    case 1:
      color = Color.BLUE;
      break;
    case 2:
      color = Color.YELLOW;
      break;
    case 3:
      color = Color.GREEN;
      break;
    }

    return color;
  }

  
}
