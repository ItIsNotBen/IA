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
        Player player = new Player(playerName);
        while (player.hasTiles()) {
            game.dealTiles(14);
            game.displayPlayerTiles();
            placeTile();
            step3();
        }
        run();
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
        int x;
        int y;
        char tile = 0;
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
        placeTile();
    }

    private char selectTile() {
        Player player =  game.getPlayer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the tile you'd like to place: ");
        String sTile = scanner.nextLine();
        boolean hasTile = player.hasTile(sTile.charAt(0));
        boolean tooLong = sTile.length() > 1;
        if (tooLong) {
            System.out.println("Uh oh. Looks like you don't have that tile. Try place a tile that you have been given!");
            char tile = selectTile();
            return tile;
        } else if (!hasTile) {
            System.out.println("Uh oh. Looks like you don't have that tile. Try place a tile that you have been given!");
            char tile = selectTile();
            return tile;
        } else {
            char tile = sTile.charAt(0);
            return tile;
        }
    }



    public void step3() {
        Player player = game.getPlayer();
        if (!player.hasTiles()) {
            System.out.println("It looks like you have used up all your tiles! Well done!");
            System.out.println("Here is an extra tile: ");
            game.addTile();
        } else if (!player.hasTiles() && game.isPouchEmpty()) {
            run();
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




}
