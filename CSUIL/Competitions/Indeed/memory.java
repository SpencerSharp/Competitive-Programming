import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class memory{
    public static void main(String[] args) throws IOException {
        String fileName = "memory.dat";
        Scanner sc = new Scanner(new File(fileName));
        int numLoops = sc.nextInt();
        for (int i = 0; i < numLoops; i++) {
            //input stuff
            int cS = sc.nextInt();
            int rS = sc.nextInt();
            int hS = sc.nextInt();
            char[][][] board = new char[hS][rS][cS];
            for(int h = 0; h < hS; h++)
                for(int r = 0; r < rS; r++)
                {
                    String line = sc.next();
                    for(int c = 0; c < cS; c++)
                    {
                        board[h][r][c]=line.charAt(c);
                    }
                }
            //out.println(disp(board));
            boolean solvable = canBoardBeSolved(board);
            if(solvable)
                out.println("solvable");
            else
                out.println("impossible");
            //out.println(solvable);
        }
    }
    
    public static char[][][] copy(char[][][] board)
    {
        char[][][] ret = new char[board.length][board[0].length][board[0][0].length];
        for(int h = 0; h < board.length; h++)
            for(int r = 0; r < board[h].length; r++)
                for(int c = 0; c < board[h][r].length; c++)
                    ret[h][r][c] = board[h][r][c];
        return ret;
    }
    
    public static String disp(char[][][] board)
    {
        String ret = "";
        for(int h = 0; h < board.length; h++)
            for(int r = 0; r < board[h].length; r++)
            {
                for(int c = 0; c < board[h][r].length; c++)
                    ret += board[h][r][c];
                ret += "\n";
            }
       return ret;
    }
    
    public static boolean canBoardBeSolved(char[][][] board)
    {
        ArrayList<int[]> allCoordPairs = getAllCoordPairsOnLayer(board[0]);
        //out.println(Arrays.toString(allCoordPairs.get(0)));
        if(allCoordPairs.size() > 0)
        {
            for(int[] coords : allCoordPairs)
            {
                char[][][] newBoard = copy(board);
                newBoard = movedUpBoard(newBoard,coords);
                //out.println("DISP\n"+disp(newBoard));
                if(canBoardBeSolved(newBoard))
                    return true;
            }
        }
        if(isDone(board))
            return true;
        return false;
    }
    
    public static boolean isDone(char[][][] board)
    {
        boolean allZeros = true;
        for(int r = 0; r < board[0].length; r++)
            for(int c = 0; c < board[0][r].length; c++)
                if(board[0][r][c]!='0')
                    return false;
        return true;
    }
    
    public static char[][][] movedUpBoard(char[][][] board, int[] coords)
    {
        //out.println(Arrays.toString(coords));
        int curR = coords[0];
        int curC = coords[1];
        for(int h = 0; h < board.length-1; h++)
        {
            if(board[h+1][curR][curC]=='0')
            {
                board[h][curR][curC] = '0';
                break;
            }
            else
            {
                board[h][curR][curC] = board[h+1][curR][curC];
                board[h+1][curR][curC] = '0';
            }
        }
        curR = coords[2];
        curC = coords[3];
        for(int h = 0; h < board.length-1; h++)
        {
            if(board[h+1][curR][curC]=='0')
            {
                board[h][curR][curC] = '0';
                break;
            }
            else
            {
                board[h][curR][curC] = board[h+1][curR][curC];
                board[h+1][curR][curC] = '0';
            }
        }
        return board;
    }
    
    public static ArrayList<int[]> getAllCoordPairsOnLayer(char[][] board)
    {
        ArrayList<int[]> ret = new ArrayList<int[]>();
        for(int r = 0; r < board.length; r++)
        {
            for(int c = 0; c < board[r].length; c++)
            {
                char cur = board[r][c];
                if(cur!='0')
                {
                for(int r1 = r; r1 < board.length; r1++)
                {
                    int c1;
                    if(r1==r)
                        c1 = c;
                    else
                        c1 = 0;
                    for(; c1 < board[r1].length; c1++)
                    {
                        if(r1!=r||c1!=c)
                            if(cur==board[r1][c1])
                            {
                                int[] ray = new int[5];
                                ray[0] = r;
                                ray[1] = c;
                                ray[2] = r1;
                                ray[3] = c1;
                                ray[4] = cur;
                                ret.add(ray);
                            }
                    }
                }
                }
            }
        }
        return ret;
    }
    
}
