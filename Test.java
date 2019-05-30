import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
        boolean player = true, connect = true;
        Scanner scan = new Scanner(System.in);
        int side, players, connections;
        System.out.println("How long should the sides of the board be?");
        side = scan.nextInt();
        System.out.println("How many players are there?");
        players = scan.nextInt();

        if(players * 2 < side)
            player = false;

        while(player)
        {
            System.out.println("Too many players for a board of that size. Enter less players.");
            players = scan.nextInt();
            if(players * 2 < side)
                player = false;
        }

        System.out.println("How many connections to win?");
        connections = scan.nextInt();
        if(connections * 2 <= side)
            connect = false;
        while(connect)
        {
            System.out.println("Too many connections for a board of that size. Enter less connections.");
            connections = scan.nextInt();
            if(connections * 2 <= side)
                connect = false;
        }
        Game game = new Game(side, players, connections);
        game.play();
    }
}