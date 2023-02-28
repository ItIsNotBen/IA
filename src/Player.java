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



    public void placeTile(int i, int j, char tile) {
        grid[i][j] = tile;
    }


    public void maximum(){

    }

    public void extendGrid(int i, int j) {
        char[][] newGridRight = new char[grid.length][j+5];
        char[][] newGridTop = new char[grid.length + (5-i)][grid[i].length];
        char[][] newGridLeft = new char[grid.length][grid[i].length + (5 - j)];
        char[][] newGridBottom = new char[(i+1) + 5][grid[i].length];
        char[][] newGrid = new char[i + 5][j+5];

        if (grid.length> grid.length + (5-i) && grid.length > (i+1) + 5) {
            newGrid = newGridRight;
        }
        if (grid.length + (5-i) > grid.length && grid.length + (5-i) > (i+1) + 5) {
            newGrid = newGridTop;
        }
        if (grid[i].length > grid[i].length + (5 - j) && grid[i].length > j+5) {
            newGrid = newGridLeft;
        }
        if ((i+1) + 5 > grid.length && (i+1) + 5 > grid.length + (5-i)) {
            newGrid = newGridBottom;
        }



        if (grid.length - i < 5) {

        }



        for(int n = 0; n < newGrid.length; n++) {
            for(int m = 0; m < newGrid[n].length; m++) {
                newGrid[n][m] = ' ';
            }
        }

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                newGrid[x][y] = grid[x][y];
            }
        }
        grid = newGrid;
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

//        char[][] tempGrid = {{0, 0, 0, 't', 'r', 'e', 'e', 0, 0}, {0, 0, 0, 'r', 0, 0, 0, 0, 0}, {0, 0, 0, 'u', 0, 0, 0, 0, 0}, {0, 0, 0, 'c', 0, 0, 0, 0, 0}, {0, 0, 0, 'k', 0, 0, 0, 0, 0}};
//
//        grid = tempGrid;

        ArrayList<String> words = new ArrayList<String>();

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 0) {
                    continue;
                }

                // while south is occupied, add letter until vacant spot reached
                if (i < grid.length - 1 && grid[i + 1][j] != 0 && (i == 0 || grid[i - 1][j] == 0)) {
                    StringBuilder word = new StringBuilder();
                    int x = i;
                    while (x < grid.length && grid[x][j] != 0) {
                        word.append(grid[x][j]);
                        x++;
                    }
                    words.add(word.toString());

                }
                // while west is occupied, add letter until blank spot reached
                if (j + 1 < grid[i].length && grid[i][j + 1] != 0 && (j == 0 || grid[i][j - 1] == 0)) {
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
        return words.toArray(new String[0]);
    }

}
