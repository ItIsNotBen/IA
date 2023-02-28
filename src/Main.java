import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        String[] playerNames = {"Sam", "Ben"};
//        Game game = new Game(playerNames, 144);
//
//        game.dealTiles(14);
//        game.displayState();

//
        Player player = new Player("Ben");
//



        player.placeTile(5,5,'t');
//        player.placeTile(6,4,'r');
//        player.placeTile(7,4,'e');
//        player.placeTile(8,4,'e');
//
//
        player.displayGrid();

        player.extendGrid(5,5);


        player.displayGrid();

        player.extendGrid(5,5);

//        System.out.println(Arrays.toString(player.findWords()));



    }
}