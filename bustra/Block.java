package bustra;

import java.awt.Color;
import java.util.Random;

public class Block {
  private static Color face;
  private static int RANGE_OF_COLOR = 4;

  // コンストラクタ
  public Block() {
    face = getRandomColor();
  }

  // ブロックの色を返却するメソッド
  public static Color getFace() {
    return face;
  }

  // ランダムな色を生成するメソッド
  private static Color getRandomColor() {
    Random rand = new Random();
    int sw = rand.nextInt(RANGE_OF_COLOR);
    Color color = Color.RED;
    
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

  // テスト用のメインメソッド
  public static void main(String args[]) {
    Block block = new Block();
    System.out.println(block.getFace());
  }
}
