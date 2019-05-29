import java.util.Scanner;

public class Game
{
    Scanner scan = new Scanner(System.in);
    private int n;
    private boolean move = false;
    private Board b;
    public Game(int side)
    {
        Board board = new Board(side);
        b = board;
    }

    public void play()
    {
        System.out.println("Welcome to Connect 4!");
        System.out.println("In order to play, choose the column that you would like to drop your token into (1 to " + b.getSideLength() + ").");
        System.out.println("There are 2 players, in order to win, you must get four of your mark in a row horizontally, vertically, or diagonally.");
        //enters main game loop
        while(!isFull())
        {
            b.print();
            System.out.println();
            System.out.println("Player 1, choose a column.");
            n = scan.nextInt();
            while(!move)
            {
                if(b.canMakeMove(n - 1)) {
                    b.makeMove1(n - 1);
                    move = true;
                }
                else
                {
                    System.out.println("Player 1, choose an unfilled column.");
                    n = scan.nextInt();
                }
            }
            move = false;
            if(fourInARow1())
            {
                System.out.println("Player 1 Wins!");
                b.print();
                break;
            }
            b.print();
            System.out.println();
            System.out.println("Player 2, choose a column.");
            n = scan.nextInt();
            while(!move)
            {
                if(b.canMakeMove(n - 1)) {
                    b.makeMove2(n - 1);
                    move = true;
                }
                else
                {
                    System.out.println("Player 2, choose an unfilled column.");
                    n = scan.nextInt();
                }
            }
            move = false;
            if(fourInARow2())
            {
                System.out.println("Player 2 Wins!");
                b.print();
                break;
            }
            System.out.println();
        }
        if(!fourInARow1() || !fourInARow2())
        {
            System.out.println("It is a tie!");
            System.out.println();
            b.print();
        }
    }

    public boolean fourInARow1()
    {
        //checks horizontal player 1
        for(int row = 0; row < b.getSideLength(); row++)
        {
            for(int col = 0; col < b.getSideLength(); col++)
            {
                if(b.getNum(row, col) == 1 && col <= b.getSideLength() - 4)
                {
                    if(b.getNum(row, col + 1) == 1)
                    {
                        if(b.getNum(row, col + 2) == 1)
                        {
                            if(b.getNum(row, col + 3) == 1)
                                return true;
                        }
                    }
                }
            }
        }
        //checks vertical player 1
        for(int col = 0; col < b.getSideLength(); col++)
        {
            for(int row = 0; row < b.getSideLength(); row++)
            {
                if(b.getNum(row, col) == 1 && row <= b.getSideLength() - 4)
                {
                    if(b.getNum(row + 1, col) == 1)
                    {
                        if(b.getNum(row + 2, col) == 1)
                        {
                            if(b.getNum(row + 3, col) == 1)
                                return true;
                        }
                    }
                }
            }
        }
        //checks diagonal up-right
        for(int col = 0; col < b.getSideLength(); col++)
        {
            for(int row = 0; row < b.getSideLength(); row++)
            {
                if(b.getNum(row, col) == 1 && row >= 3 && col <= b.getSideLength() - 4)
                {
                    if(b.getNum(row - 1, col + 1) == 1)
                    {
                        if(b.getNum(row - 2, col + 2) == 1)
                        {
                            if(b.getNum(row - 3, col + 3) == 1)
                                return true;
                        }
                    }
                }
            }
        }
        //checks diagonal up-left
        for(int col = 0; col < b.getSideLength(); col++)
        {
            for(int row = 0; row < b.getSideLength(); row++)
            {
                if(b.getNum(row, col) == 1 && row >= 3 && col >= 3)
                {
                    if(b.getNum(row - 1, col - 1) == 1)
                    {
                        if(b.getNum(row - 2, col - 2) == 1)
                        {
                            if(b.getNum(row - 3, col - 3) == 1)
                                return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean fourInARow2()
    {
        //checks horizontal
        for(int row = 0; row < b.getSideLength(); row++)
        {
            for(int col = 0; col < b.getSideLength(); col++)
            {
                if(b.getNum(row, col) == 2 && col <= b.getSideLength() - 4)
                {
                    if(b.getNum(row, col + 1) == 2)
                    {
                        if(b.getNum(row, col + 2) == 2)
                        {
                            if(b.getNum(row, col + 3) == 2)
                                return true;
                        }
                    }
                }
            }
        }
        //checks vertical
        for(int col = 0; col < b.getSideLength(); col++)
        {
            for(int row = 0; row < b.getSideLength(); row++)
            {
                if(b.getNum(row, col) == 2 && row <= b.getSideLength() - 4)
                {
                    if(b.getNum(row + 1, col) == 2)
                    {
                        if(b.getNum(row + 2, col) == 2)
                        {
                            if(b.getNum(row + 3, col) == 2)
                                return true;
                        }
                    }
                }
            }
        }
        //checks diagonal up-right
        for(int col = 0; col < b.getSideLength(); col++)
        {
            for(int row = 0; row < b.getSideLength(); row++)
            {
                if(b.getNum(row, col) == 2 && row >= 3 && col <= b.getSideLength() - 4)
                {
                    if(b.getNum(row - 1, col + 1) == 2)
                    {
                        if(b.getNum(row - 2, col + 2) == 2)
                        {
                            if(b.getNum(row - 3, col + 3) == 2)
                                return true;
                        }
                    }
                }
            }
        }
        //checks diagonal up-left
        for(int col = 0; col < b.getSideLength(); col++)
        {
            for(int row = 0; row < b.getSideLength(); row++)
            {
                if(b.getNum(row, col) == 2 && row >= 3 && col >= 3)
                {
                    if(b.getNum(row - 1, col - 1) == 2)
                    {
                        if(b.getNum(row - 2, col - 2) == 2)
                        {
                            if(b.getNum(row - 3, col - 3) == 2)
                                return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isFull()
    {
        for(int row = 0; row < b.getSideLength(); row++)
        {
            for(int col = 0; col < b.getSideLength(); col++)
            {
                if(b.getNum(row, col) == 0)
                    return false;
            }
        }
        return true;
    }
}