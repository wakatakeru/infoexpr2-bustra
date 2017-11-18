package bustra;

import java.lang.Thread;

public class Main {

  private int boardSize;
  
  public static void main(String args[]) {
    /* Pending
      Thread startMenu = new Thread(new StartMenu());
    */
    
    Thread startMenu = new Thread(new Menu());
    Thread endMenu;
    Thread game;
    Thread timer = new Thread(new Timer());
    
    startMenu.start();

    try {
      startMenu.join();
    } catch (InterruptedException e) { /* do nothing */ }

    game = new Thread(new Game(Menu.getBoardSize()));

    game.start();
    timer.start();
    
    try {
      game.join();
      timer.join();
    } catch (InterruptedException e) { /* do nothing */ }

    /* Pending
       endMenu = new Thread(new Menu(Game.getScore()));
    */
    
    endMenu = new Thread(new Menu(Game.getScore()));

    endMenu.start();

    try {
      endMenu.join();
    } catch (InterruptedException e) { /* do nothing */ }
  }
}
