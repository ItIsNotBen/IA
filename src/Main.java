import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


//        Player player = new Player("Ben");
//
//        Controller controller = new Controller();
////        controller.run();
//
//        Game game = controller.getGame();
//        WordLibrary wl = game.getWordLibrary();
//        System.out.println(wl.checkWordHash("tetrabasic"));
//
//        System.out.println(player.hasValidWords(wl));
//

//        System.out.println(Arrays.toString(player.findWords()));

        char[] hand = {'a', 'b', 'c', 'd', 'e'};
        char[][] grid = {{' ', 'd', 'e', ' ', ' '}, {' ',' ',' ',' ',' '}, {' ',' ',' ',' ',' '},{' ', ' ', ' ', ' ', ' '}};


        Window window = new Window(hand, grid);




    }
}