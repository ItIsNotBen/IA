// Second in power - Manages the game state including the components such as player, pouch, word library. Has methods that manages interactions between those components.

public class Game {
    private Player player;
    private Pouch pouch;
    private WordLibrary wordLibrary;



   Game(String playerName, int numOfTiles) {
       player = new Player(playerName);
       pouch = new Pouch(numOfTiles);
       wordLibrary = new WordLibrary();
   }


   public WordLibrary getWordLibrary() {
       return wordLibrary;
   }

   public void dealTiles(int amountTilesGiven) {
       char[] givenTiles = pouch.yieldTiles(amountTilesGiven);
       player.assignTiles(givenTiles);
       }

       public void addTile() {
       char givenTile = pouch.yieldTile();
       player.assignTile(givenTile);
       }

       public boolean isPouchEmpty() {
       return pouch.isEmpty();
       }



   public void displayState() {
       System.out.println("Pouch tiles: ");
       pouch.displayTiles();
       System.out.println(player.getName() +"'s tiles: ");
       player.displayConsoleTiles();
       player.displayConsoleGrid();
       // include methods that can display player tiles & grid in the window
       // could make a window object in here and change that
       }


       public void displayPlayerTiles() {
           System.out.println(player.getName() + "'s tiles: ");
           player.displayConsoleTiles();
       }

       public Player getPlayer() {
       return player;
       }

}

