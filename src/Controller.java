import java.sql.SQLOutput;
import java.util.Scanner;

public class Controller {

    private Game game;
    private String playerName;


    Controller() {
        // identify();
        playerName = "Ben";
        game = new Game(playerName, 144);

    }

    public void run() {
        game.dealTiles(14);
        // entering playing stage: choosing & placing tiles, creating their words, checking their words, gaining points, 'peel' to get tiles
        playingStage();

        // askToStart();
        // placeTile();
    }

    private void identify() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");

        playerName = scanner.nextLine();
    }

    private void askToStart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to start.");
        scanner.nextLine();

    }


    private void placeTile() {
        System.out.println("Here is your grid: ");
        Player player = game.getPlayer();
        player.displayGrid();
        game.displayPlayerTiles();
        int x;
        int y;
        char tile;
        Scanner scanner = new Scanner(System.in);

        tile = selectTile();

        System.out.println("Where would you like to place your tile?");
        System.out.println("Enter your x coordinate: ");
        x = scanner.nextInt();

        System.out.println("Enter your y coordinate: ");
        y = scanner.nextInt();

        player.placeTile(x, y, tile);
        player.findWords();
        player.displayTiles();
    }

    private char selectTile() {
        Player player = game.getPlayer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the tile you'd like to place: ");
        String sTile = scanner.next();
        boolean hasTile = player.hasTile(sTile.charAt(0));
        boolean tooLong = sTile.length() > 1;
        char tile;
        if (tooLong) {
            System.out.println("Uh oh. Looks like you don't have that tile. Try place a tile that you have been given!");
            tile = selectTile();
        } else if (!hasTile) {
            System.out.println("Uh oh. Looks like you don't have that tile. Try place a tile that you have been given!");
            tile = selectTile();
        } else {
            tile = sTile.charAt(0);

        }
        return tile;
    }


    public void playingStage() {
        Player player = game.getPlayer();

        if (player.hasTiles()) {
            placeTile();
            playingStage();
        } else if (!player.hasTiles() && !game.isPouchEmpty()) {
            System.out.println("It looks like you have used up all your tiles! Well done!");
            System.out.println("Here is an extra tile: ");
            game.addTile();
            playingStage();
        } else if (!player.hasTiles() && game.isPouchEmpty()) {
            System.out.println("You have finished all your tiles, there are no more in the pouch! Well done!");
        }
    }
}


//    }



    //    public void step1() {
//        char[] tiles = new char[14];
//        boolean wantsTiles;
//        Scanner scanner = new Scanner(System.in);
//
//
//        System.out.println("Would you like your tiles?");
//        if (scanner.nextLine() == "Yes") {
//            wantsTiles = true;
//        } else {
//            wantsTiles = false;
//            System.out.println("Ok!");
//        }
//
//        if (!player.hasTiles() && wantsTiles) {
//            System.out.println("Here are 14 tiles, " + player.getName() + ".");
//            player.assignTiles(tiles);
//            player.hasTiles();
//
//            //            System.out.println("Where would you like your tile?");
//
//        } else if (player.hasTiles() && wantsTiles && tiles.length < 14) {
//            while (tiles.length < 14) {
//                player.assignTiles(tiles); // i want to keep adding tiles until they have 14 again
//            }
//        }
//
//        System.out.println("Here are your tiles, " + player.getName() + ":");
//        player.displayTiles();
//
//
//    }





