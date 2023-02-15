import java.util.ArrayList;
import java.util.Random;

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




}
