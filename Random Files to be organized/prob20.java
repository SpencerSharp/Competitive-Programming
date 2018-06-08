
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spencersharp
 */
public class prob20 {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("/Users/spencersharp/Desktop/input.txt"));

        int width = sc.nextInt();
        int height = sc.nextInt();
        sc.nextLine();
        char[][] maze = new char[height][width];
        for(int r = 0; r < height; r++)
        {
            String line = sc.nextLine();
            for(int c = 0; c < width; c++)
                maze[r][c] = line.charAt(c);
        }
        out.println(disp(maze));
        out.println(solve(getROfAtSign(maze),getCOfAtSign(maze),maze));
        out.println(disp(maze));
    }
    
    public static int getCOfAtSign(char[][] maze)
    {
        for(int r = 0; r < maze.length; r++)
            for(int c = 0; c < maze[r].length; c++)
                if(maze[r][c]=='@')
                    return c;
        return -1;
    }
    
    public static int getROfAtSign(char[][] maze)
    {
        for(int r = 0; r < maze.length; r++)
            for(int c = 0; c < maze[r].length; c++)
                if(maze[r][c]=='@')
                    return r;
        return -1;
    }
    
    public static String disp(char[][] ray)
    {
        String ret = "";
        for(int r = 0; r < ray.length; r++)
        {
            for(int c= 0 ; c < ray[r].length; c++)
            {
                ret += ray[r][c];
            }
            ret += "\n";
        }
        return ret;
    }
    
    public static int solve(int r, int c, char[][] maze)
    {
        out.println(disp(maze));
        if(maze[r][c]=='X')
            return 0;
        char prev = maze[r][c];
        maze[r][c] = '*';
        int min = Integer.MAX_VALUE;
        if(r>0) //All movements up
        {
            if(maze[r-1][c]==' ')
                min = Math.min(min,1+solve(r-1,c,maze));
            if(c>0) //Up, left
            {
                if(maze[r-1][c-1]== ' ')
                    min = Math.min(min, 1+solve(r-1,c-1,maze));
            }
            if(c<maze[r].length-1)
            {
                if(maze[r-1][c+1]== ' ')
                    min = Math.min(min, 1+solve(r-1,c+1,maze));
            }
        }
        if(r <maze.length-1) //All movements down
        {
            if(maze[r+1][c]==' ')
                min = Math.min(min,1+solve(r+1,c,maze));
            if(c>0) //Up, left
            {
                if(maze[r+1][c-1]==' ')
                    min = Math.min(min, 1+solve(r+1,c-1,maze));
            }
            if(c<maze[r].length-1)
            {
                if(maze[r+1][c+1]== ' ')
                    min = Math.min(min, 1+solve(r+1,c+1,maze));
            }
        }
        if(c>0) //Up, left
        {
            if(maze[r][c-1]==' ')
                min = Math.min(min, 1+solve(r,c-1,maze));
        }
        if(c<maze[r].length-1)
        {
            if(maze[r][c+1]==' ')
                min = Math.min(min, 1+solve(r,c+1,maze));
        }
        maze[r][c] = prev;
        return min;
    }
}
