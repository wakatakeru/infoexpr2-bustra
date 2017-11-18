package bustra;

public class Constants {
  private Constants() {}

  protected static final int BOARD_SIZE = 6;
  protected static final int BLOCKSIZE = 64;
  protected static final int COMBO_LINE = 3;
  protected static final int RANGE_OF_COLOR = 4;
  protected static final int GAP = 4;
  protected static final int CIRCLE = BLOCKSIZE - GAP;
  protected static final int LIMIT_TIME = 1 * 20 * 1000;
  protected static final String URL = "http://localhost:3000/scores/create";
}
