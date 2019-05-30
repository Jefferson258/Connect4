import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    private int n, numPlayers, connections;
    private boolean move = false;
    private Board b;

    public Game(int side, int players, int connect) {
        Board board = new Board(side);
        b = board;
        numPlayers = players;
        connections = connect;
    }

    public void play() {
        System.out.println("Welcome to Connect 4!");
        System.out.println("In order to play, choose the column that you would like to drop your token into (1 to " + b.getSideLength() + ").");
        System.out.println("There are " + numPlayers + " players, in order to win, you must get " + connections + " of your mark in a row horizontally, vertically, or diagonally.");
        //enters main game loop
        while (!isFull()) {
            for (int i = 1; i <= numPlayers; i++) {
                b.print();
                System.out.println();
                System.out.println("Player " + i + ", choose a column.");
                n = scan.nextInt();
                while (!move) {
                    if (n > 0 && n <= b.getSideLength() && b.canMakeMove(n - 1)) {
                        b.makeMove(n - 1, i);
                        move = true;
                    } else {
                        System.out.println("Player " + i + ", choose an unfilled column between 1 and " + b.getSideLength() + ".");
                        n = scan.nextInt();
                    }
                }
                move = false;
                if (connectInARow(i)) {
                    System.out.println("Player " + i + " Wins!");
                    System.out.println();
                    b.print();
                    System.exit(0);
                }
            }
        }
    }

    public boolean connectInARow(int player) {
        //checks horizontal
        int hor = 0;
        for (int row = 0; row < b.getSideLength(); row++) {
            for (int col = 0; col <= b.getSideLength() - connections; col++) {
                for (int i = 0; i < connections; i++) {
                    if (b.getNum(row, col + i) == player)
                        hor++;
                }
                if (hor == connections)
                    return true;
                hor = 0;
            }
        }
        //checks vertical
        int vert = 0;
        for (int col = 0; col < b.getSideLength(); col++) {
            for (int row = 0; row <= b.getSideLength() - connections; row++) {
                for (int i = 0; i < connections; i++) {
                    if (b.getNum(row + i, col) == player)
                        vert++;
                }
                if (vert == connections)
                    return true;
                vert = 0;
            }
        }
        //checks diagonal up-right
        int diagonal1 = 0;
        for (int col = 0; col <= b.getSideLength() - connections; col++) {
            for (int row = connections - 1; row < b.getSideLength(); row++) {
                for(int i = 0; i < connections; i++){
                    if(b.getNum(row - i, col + i) == player)
                        diagonal1++;
                }
                if(diagonal1 == connections)
                    return true;
                diagonal1 = 0;
            }
        }
        //checks diagonal up-left
        int diagonal2 = 0;
        for (int col = connections - 1; col < b.getSideLength(); col++) {
            for (int row = connections - 1; row < b.getSideLength(); row++) {
                for(int i = 0; i < connections; i++){
                    if(b.getNum(row - i, col - i) == player)
                        diagonal2++;
                }
                if(diagonal2 == connections)
                    return true;
                diagonal2 = 0;
            }
        }

        return false;
    }

    public boolean isFull() {
        for (int row = 0; row < b.getSideLength(); row++) {
            for (int col = 0; col < b.getSideLength(); col++) {
                if (b.getNum(row, col) == 0)
                    return false;
            }
        }
        return true;
    }
}