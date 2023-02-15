public class Game {
    private Player[] players;
    private Pouch pouch;


   Game(String[] playerNames, int numOfTiles) {
       players = new Player[playerNames.length];
       for(int i = 0; i < players.length; i++) {
           players[i] = new Player(playerNames[i]);
       }

       pouch = new Pouch(numOfTiles);

   }
   public void dealTiles(int amountTilesGiven) {
       for(int i = 0; i < players.length; i++) {
           char[] givenTiles = pouch.yieldTiles(amountTilesGiven);
           players[i].assignTiles(givenTiles);
       }
   }

   public void displayState() {
       System.out.println("Pouch tiles: ");
       pouch.displayTiles();
       for (int i = 0; i < players.length; i++) {
           System.out.println(players[i].getName() +"'s tiles: ");
           players[i].displayTiles();
       }
   }

}
