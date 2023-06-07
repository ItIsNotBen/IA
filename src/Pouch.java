import java.util.ArrayList;
import java.util.Random;

//Third level class - Creates the pouch of letters and has methods to organise each players' take

public class Pouch {
    private ArrayList tiles;


    Pouch(int tileAmount){
        tiles = new ArrayList();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for(int i = 0; i < tileAmount; i++){
            Random random = new Random();
            int pos = random.nextInt(26);

            tiles.add(alphabet[pos]);
        }
    }

    public void displayTiles() {
        System.out.println(tiles.toString());
    }

    public char[] yieldTiles(int amount) {
        char[] yieldedTiles = new char[amount];
        for (int i = 0; i < amount; i++) {
            yieldedTiles[i] = (char) tiles.remove(0);
        }
        return yieldedTiles;
    }

    public char yieldTile() {
        char yieldedTile = (char) tiles.remove(0);
        return yieldedTile;
    }

    public boolean isEmpty() {
        return tiles.isEmpty();
    }

    // give out and receive tiles methods




}
