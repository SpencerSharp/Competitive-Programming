import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class Luke {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("luke.dat"));
        int numLoops = sc.nextInt();
        sc.nextLine();
        char[][] space = new char[numLoops][numLoops];
        for (int loop = 0; loop < numLoops; loop++) {
            String line = sc.nextLine();
            for(int i = 0; i < numLoops; i++)
            {
                space[loop][i] = line.charAt(i);
            }
        }
        int numStarts = sc.nextInt();
        for(int i = 0; i < numStarts; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            boolean solvable = canSolveMaze(copy(space),x,y);
            if(solvable)
                out.println("yes");
            else
                out.println("no");
        }
    }
    
    public static char[][] copy(char[][] maze)
    {
        char[][] copy = new char[maze.length][maze.length];
        for(int r = 0; r < maze.length; r++)
            for(int c = 0; c < maze.length; c++)
                copy[r][c] = maze[r][c];
        return copy;
    }
    
    public static boolean canSolveMaze(char[][] space, int x, int y)
    {
        if(space[x][y]=='X')
            return false;
        if(space[x][y]=='L')
            return true;
        boolean canFind = false;
        if(x > 0)
        {
            space[x][y] = 'X';
                canFind = canFind || canSolveMaze(space,x-1,y);
                space[x][y] = '.';
        }
        if(y > 0)
        {
            space[x][y] = 'X';
                canFind = canFind || canSolveMaze(space,x,y-1);
                space[x][y] = '.';
        }
        if(x < space.length-1)
        {
            space[x][y] = 'X';
                canFind = canFind || canSolveMaze(space,x+1,y);
                space[x][y] = '.';
        }
        if(y < space.length-1)
        {
            space[x][y] = 'X';
                canFind = canFind || canSolveMaze(space,x,y+1);
                space[x][y] = '.';
        }
        return canFind;
    }
}