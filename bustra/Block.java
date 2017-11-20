package bustra;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;

import javax.imageio.ImageIO;

import java.io.*;

public class Block {
  private Color face;
  private BufferedImage faceImage;
  
  // コンストラクタ
  public Block() {
    this.face = getRandomColor();
    setFaceImage(this.face);
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

  protected BufferedImage getFaceImage() {
    return faceImage;
  }
  
  // ランダムな色を生成
  private static Color getRandomColor() {
    double rand;
    int sw;
    Color color = Color.RED;

    rand = Math.random();
    sw = (int)(rand * Constants.RANGE_OF_COLOR);
    
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
  
  // 色に応じて画像を設定
  private void setFaceImage(Color faceColor) {
    /*
    try{
      if ( faceColor == Color.RED    ) { faceImage = ImageIO.read(new File(getClass().getResource("bin//red_block.png"))); }
      if ( faceColor == Color.BLUE   ) { faceImage = ImageIO.read(new File(getClass().getResource("bin//blue_block.png"))); }
      if ( faceColor == Color.YELLOW ) { faceImage = ImageIO.read(new File(getClass().getResource("bin//yellow_block.png"))); }
      if ( faceColor == Color.GREEN  ) { faceImage = ImageIO.read(new File(getClass().getResource("bin//green_block.png"))); }
    } catch( IOException e ) { }
    */
    try{
      if ( faceColor == Color.RED    ) { faceImage = ImageIO.read(new File(getClass().getResource("bin//red_block.png"))); }
      if ( faceColor == Color.BLUE   ) { faceImage = ImageIO.read(new File(getClass().getResource("bin//blue_block.png"))); }
      if ( faceColor == Color.YELLOW ) { faceImage = ImageIO.read(new File(getClass().getResource("bin//yellow_block.png"))); }
      if ( faceColor == Color.GREEN  ) { faceImage = ImageIO.read(new File(getClass().getResource("bin//green_block.png"))); }
    } catch( IOException e ) { }
  }
}
