import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

// Third level class - Creates personal grid for each player and manages grid boundaries. has methods that assign tiles to each players' hand, enables them to place tiles on the grid.
//                     Includes method that checks validity of the words each player has found.

public class Player {
    private String name;
    private int points;
    private char[][] grid;
    private ArrayList hand;
    private char selectedTile;
    private char selectedHandTile;

    public Player(String name) {
        this.name = name;
        points = 0;
        grid = new char[10][10];
        initGrid();
        hand = new ArrayList();
        selectedTile = ' ';
    }

    public String getName() {
        return name;
    }

    public void moveTile(int row, int column) {
        grid[row][column] = selectedTile;
        selectedTile = ' ';
    }

    // do select tile method
    public char getSelectedTile() {
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
        extendGrid(i, j);
        hand.remove(Character.valueOf(tile));
    }


    private void initGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                grid[i][j] = ' ';
            }
        }
    }

    public void extendGrid(int i, int j) {

        char[][] newGrid;
        int margin = 2;

        boolean atTopEdge = i < margin;
        boolean atLeftEdge = j < margin;
        boolean atBottomEdge = grid.length - (i + 1) < margin;
        boolean atRightEdge = grid[i].length - (j + 1) < margin;


        if (atTopEdge) {
            if (atRightEdge) {
                char[][] newGridTopRight = new char[grid.length + (margin - i)][(j + 1) + margin];
                newGrid = newGridTopRight;
            } else if (atLeftEdge) {
                char[][] newGridTopLeft = new char[grid.length + (margin - i)][grid[i].length + (margin - j)];
                newGrid = newGridTopLeft;
            } else {
                char[][] newGridTop = new char[grid.length + (margin - i)][grid[i].length];
                newGrid = newGridTop;
            }
        } else if (atBottomEdge) {
            if (atRightEdge) {
                char[][] newGridBottomRight = new char[(i + 1) + margin][(j + 1) + margin];
                newGrid = newGridBottomRight;
            } else if (atLeftEdge) {
                char[][] newGridBottomLeft = new char[(i + 1) + margin][grid[i].length + (margin - j)];
                newGrid = newGridBottomLeft;
            } else {
                char[][] newGridBottom = new char[(i + 1) + margin][grid[i].length];
                newGrid = newGridBottom;
            }
        } else if (atLeftEdge) {
            char[][] newGridLeft = new char[grid.length][grid[i].length + (margin - j)];
            newGrid = newGridLeft;
        } else if (atRightEdge) {
            char[][] newGridRight = new char[grid.length][(j + 1) + margin];
            newGrid = newGridRight;
        } else {
            return;
        }


        for (int n = 0; n < newGrid.length; n++) {
            for (int m = 0; m < newGrid[n].length; m++) {
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

    public void displayConsoleGrid() {
        for (int i = 0; i < grid.length; i++) {
            String line = Integer.toString(i) + "  " + Arrays.toString(grid[i]);
            if (Integer.toString(i).length() == 1) {
                line = Integer.toString(i) + "   " + Arrays.toString(grid[i]);
            }
            System.out.println(line);
        }
    }


    public void assignTiles(char[] tiles) {
        for (int i = 0; i < tiles.length; i++) {
            hand.add(tiles[i]);
        }
    }

    public void assignTile(char tile) {
        hand.add(tile);
    }

    public boolean hasTiles() {
        if (hand.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasTile(char tile) {
        return hand.contains(tile);

    }

    public void displayConsoleTiles() {
        System.out.println(hand.toString());
    }


    public String[] findWords() {

//        char[][] tempGrid = {{0, 0, 0, 't', 'r', 'e', 'e', 0, 0}, {0, 0, 0, 'r', 0, 0, 0, 0, 0}, {0, 0, 0, 'u', 0, 0, 0, 0, 0}, {0, 0, 0, 'c', 0, 0, 0, 0, 0}, {0, 0, 0, 'k', 0, 0, 0, 0, 0}};
//
//        grid = tempGrid;

        ArrayList<String> words = new ArrayList<String>();

        for (int i = 0; i < grid.length; i++) {
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

    public boolean hasValidWords(WordLibrary wl) {
//        String[] words = findWords();
        String[] words = {"cbat", "bat", "log"};

        for (int i = 0; i < words.length; i++) {
            boolean isValid = wl.checkWordHash(words[i]);
            if (!isValid) {
                return false;
            }
        }
        return true;
    }
}

