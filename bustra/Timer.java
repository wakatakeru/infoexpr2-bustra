package bustra;

import java.lang.Thread;

public class Timer extends Thread implements Runnable {
  private static int time = 0;
  private static final int SLEEP_TIME = 100;

  @Override
  public void run() {
    while ( time <= Constants.LIMIT_TIME ) {
      try {
        Thread.sleep(SLEEP_TIME);
      } catch (InterruptedException e) { /* do nothing */ }
      time += SLEEP_TIME;
    }
  }

  public static int getTime() {
    return time;
  }
}
