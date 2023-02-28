public class Controller {

    private Game game;



    Controller() {
        String[] playerNames = {"Ben", "Sam", "Adam"};
        game = new Game(playerNames, 144);

    }

    public void run() {
        game.dealTiles(14);
        game.displayState();

    }


}
