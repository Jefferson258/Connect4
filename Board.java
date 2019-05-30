public class Board
{
    private int side, k, l;
    private int[][] board;
    public Board(int sideLength)
    {
        side = sideLength;
        board = new int[getSideLength()][getSideLength()];
        for(k = 0; k < getSideLength() - 1; k++);
        {
            for(l = 0; l < getSideLength() - 1; l++);
            {
                board[k][l] = 0;
            }
        }
    }

    public int getSideLength()
    {
        return side;
    }

    public void print()
    {
        for(int i = 0; i < side; i++)
        {
            for(int j = 0; j < side; j++)
            {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public int getNum(int row, int col)
    {
        return board[row][col];
    }

    public void makeMove(int col, int player)
    {
        for(int row = getSideLength() - 1; row >= 0; row--)
        {
            if(board[row][col] == 0) {
                board[row][col] = player;
                break;
            }
        }
    }

    public boolean canMakeMove(int col)
    {
        if(getNum(0, col) != 0)
            return false;
        return true;
    }
}
