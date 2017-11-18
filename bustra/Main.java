package bustra;

import java.lang.Thread;

public class Main {

  private int boardSize;
  
  public static void main(String args[]) {
    /* Pending
      Thread startMenu = new Thread(new StartMenu());
    */
    
    Thread startMenu = new Thread(new StartMenu());
    Thread endMenu;
    Thread game;
    Thread timer = new Thread(new Timer());
    String userName;
    
    startMenu.start();

    try {
      startMenu.join();
    } catch (InterruptedException e) { /* do nothing */ }

    userName = StartMenu.getUserName();
    game = new Thread(new Game(userName));

    game.start();
    timer.start();
    
    try {
      game.join();
      timer.join();
    } catch (InterruptedException e) { /* do nothing */ }

    /* Pending
       endMenu = new Thread(new Menu(Game.getScore()));
    */
    
    endMenu = new Thread(new EndMenu(Game.getScore(), userName));

    endMenu.start();

    try {
      endMenu.join();
    } catch (InterruptedException e) { /* do nothing */ }
  }
}
