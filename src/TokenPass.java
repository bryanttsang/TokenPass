public class TokenPass
{
    private int[] board;
    private int currentPlayer;

    public TokenPass(int playerCount)
    {
        this.board = new int[playerCount];
        for (int i = 0; i < playerCount; i++)
        {
            this.board[i] = (int)(Math.random() * 10 + 1);
        }
        this.currentPlayer = (int)(Math.random() * playerCount);
    }

    public void distributeCurrentPlayerTokens()
    {
        int playerToken = board[currentPlayer];
        int playerCount = board.length;
        int all = (int)(playerToken / playerCount);
        int mod = playerToken % playerCount;
        for (int i = 0; i < playerCount; i++)
        {
            board[i] += all;
        }
        for (int i = currentPlayer; i < currentPlayer + mod; i++)
        {
            board[currentPlayer] += 1;
            if (currentPlayer == playerCount - 1)
            {
                currentPlayer = 0;
            }
        }
    }

    public void printBoard()
    {
        System.out.print("Player  ");
        for (int i = 0; i < board.length; i++)
        {
            System.out.print(i + "  ");
        }
        System.out.println("");
        System.out.print("Tokens  ");
        for (int i = 0; i < board.length; i++)
        {
            System.out.print(board[i] + "  ");
        }
    }

    public void nextPlayer()
    {
        currentPlayer =+ 1;
    }

    public int gameOver()
    {
        for (int i = 0; i < board.length; i++)
        {
            if (board[i] == 0)
            {
                return i;
            }
        }
        return ;
    }
}
