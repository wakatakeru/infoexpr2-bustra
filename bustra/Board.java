package bustra;

public class Board {
  private int size;
  private int eraseBlocksCount = 0;
  private int erasingCount = 0;
  private Block[][] blocks;
 
  public Board(int boardSize) {
    this.size = boardSize;
    setBoard(this.size);
  }

  public static boolean moveBlock(int hand) {
    return true; 
  }

  // detectLineを定義する
  
  public static boolean setBoard(int size) {

    // 動作テスト
    return true;
  }

  public static int getErasedBlocksCount() {

    // 動作テスト
    return 0;
  }

  public static int getErasingCount() {
    
    // 動作テスト
    return 0;
  }

  private static boolean  eraseBlocks() {

    // 動作テスト
    return true;
  }
  
  private static boolean slideBlocks() {

    // 動作テスト
    return true;
  }
  
  private static boolean appendBlocks() {

    // 動作テスト
    return true;
  }

  // デバッグ用メイン関数
  public static void main(String args[]) {
    Board board = new Board(10);
  }
}
