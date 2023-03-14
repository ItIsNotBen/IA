public class Game {
    private Player player;
    private Pouch pouch;


   Game(String playerName, int numOfTiles) {
       player = new Player(playerName);
       pouch = new Pouch(numOfTiles);

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
       player.displayTiles();
       }


       public void displayPlayerTiles() {
           System.out.println(player.getName() + "'s tiles: ");
           player.displayTiles();
       }

       public Player getPlayer() {
       return player;
       }

}

