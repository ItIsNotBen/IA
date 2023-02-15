import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Player {
    private String name;
    private int points;
    private char[][] grid;
    private ArrayList hand;
    private char selectedTile;
    private char selectedHandTile;


    Player(String name){
        this.name = name;
        points = 0;
        grid = new char[10][10];
        initGrid();
        hand = new ArrayList();
        selectedTile = ' ';
    }

    public void moveTile(int row, int column){
        grid[row][column] = selectedTile;
        selectedTile = ' ';
    }
    
    // do select tile method
    public char getSelectedTile(){
        return selectedTile;
    }

    public void selectGridTile(int row, int column) {
        selectedTile = grid[row][column];
    }

    public void selectHandTile(int i) {
        selectedHandTile = (char) hand.get(i);
    }



    public void placeTile(int row, int col) {


    }

    public int getPoints() {
        return points;
    }

    public void displayGrid() {
        for(int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    private void initGrid() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {

                grid[i][j] = ' ';
            }
        }

    }

    public void assignTiles(char[] tiles) {
        for(int i = 0; i < tiles.length; i++) {
            hand.add(tiles[i]);
        }
    }

    public void displayTiles() {
        System.out.println(hand.toString());
    }

    public String getName() {
        return name;
    }

    public String[] findWords() {

        char[][] tempGrid = {{0, 0, 0, 't', 'r', 'e', 'e', 0, 0}, {0, 0, 0, 'r', 0, 0, 0, 0, 0}, {0, 0, 0, 'u', 0, 0, 0, 0, 0}, {0, 0, 0, 'c', 0, 0, 0, 0, 0}, {0, 0, 0, 'k', 0, 0, 0, 0, 0}};

        grid = tempGrid;

        ArrayList<String> words = new ArrayList<String>();

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 0) {
                    continue;
                }

                // while south is occupied, add letter until vacant spot reached
                if (i + 1 < grid.length && grid[i + 1][j] != 0) {
                    StringBuilder word = new StringBuilder();
                    int x = i;
                    while (x < grid.length && grid[x][j] != 0) {
                        word.append(grid[x][j]);
                        x++;
                    }
                    words.add(word.toString());
                }
                // while west is occupied, add letter until blank spot reached
                if (j + 1 < grid[i].length && grid[i][j + 1] != 0) {
                    StringBuilder word = new StringBuilder();
                    int x = j;
                    while (x < grid[i].length && grid[i][x] != 0) {
                        word.append(grid[i][x]);
                        x++;
                    }
                    words.add(word.toString());
                }
            }
        }

        return words.toArray(new String[1000]);
    }

}
