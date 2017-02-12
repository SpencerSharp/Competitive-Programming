import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class tic {
    public static void main(String[] args) throws IOException {
        String fileName = "tic.dat";
        Scanner sc = new Scanner(new File(fileName));
        int numLoops = sc.nextInt();
        for (int loop = 0; loop < numLoops; loop++) {
            char[][] board = new char[3][3];
            for(int r = 0; r < 3; r++)
                for(int c = 0; c < 3; c++)
                    board[r][c] = ' ';
            int numPlays = sc.nextInt();
            for(int i = 0; i < numPlays; i++)
            {
                int row = sc.nextInt();
                int col = sc.nextInt();
                if(i%2==0)
                    board[row][col] = 'X';
                else
                    board[row][col] = 'O';
            }
            char winner = whoWon(board);
            out.println(disp(board));
            if(winner=='X')
                out.println("X wins!");
            else if(winner == 'O')
                out.println("O wins!");
            else if(numPlays == 9)
                out.println("Tie Game!");
            else
                out.println("Incomplete");
            if(loop<numLoops-1)
                out.println();
        }
    }
    
    public static String disp(char[][] board)
    {
        String ret = "";
        for(int r = 0; r < 3; r++)
        {
            for(int c = 0; c < 3; c++)
            {
                ret += board[r][c];
                if(c<2)
                    ret += "|";
            }
            if(r<2)
                ret += "\n-----\n";
        }
        return ret;
    }
    
    public static char whoWon(char[][] board)
    {
        for(int r = 0; r < 3; r++)
        {
            boolean hasWon = true;
            char first = board[r][0];
            for(int c = 1; c < 3; c++)
                if(board[r][c]!=first)
                    hasWon = false;
            if(hasWon)
            {
                if(first=='X')
                    return 'X';
                else if(first=='O')
                    return 'O';
            }
            hasWon = true;
            first = board[0][r];
            for(int c = 1; c < 3; c++)
                if(board[c][r]!=first)
                    hasWon = false;
            if(hasWon)
            {
                if(first=='X')
                    return 'X';
                else if(first=='O')
                    return 'O';
            }
        }
        if(board[0][0] == board[1][1] && board[0][0] == board[2][2])
        {
            if(board[0][0]=='X')
                return 'X';
            else if(board[0][0]=='O')
                return 'O';
        }
        if(board[0][2] == board[1][1] && board[0][2] == board[2][0])
        {
            if(board[1][1]=='X')
                return 'X';
            else if(board[1][1]=='O')
                return 'O';
        }
        return 'N';
    }
    
}
