import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        String[] playerNames = {"Sam", "Ben"};
//        Game game = new Game(playerNames, 144);
//
//        game.dealTiles(14);
//        game.displayState();


        Player player = new Player("Ben");

        System.out.println(Arrays.toString(player.findWords()));

    }
}