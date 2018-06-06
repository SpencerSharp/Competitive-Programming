import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF378C
{
    public static class Coord
    {
        int r;
        int c;
        
        public Coord(int x, int y)
        {
            this.r = x;
            this.c = y;
        }
        
        public String toString()
        {
            return r + " " + c;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        boolean foundFirstDot = false;
        int firstDotRow = 0;
        int firstDotCol = 0;
        
        int clearSpots = 0;
        
        char[][] maze = new char[rows][cols];
        
        String line;
        
        for(int r = 0; r < rows; r++)
        {
            line = f.readLine();
            for(int c = 0; c < cols; c++)
            {
                maze[r][c] = line.charAt(c);
                if(maze[r][c] == '.')
                {
                    clearSpots++;
                    if(!foundFirstDot)
                    {
                            foundFirstDot = true;
                            firstDotRow = r;
                            firstDotCol = c;

                    }
                }
            }
        }
        
        LinkedList<Coord> points = new LinkedList<Coord>();
        
        points.add(new Coord(firstDotRow, firstDotCol));
        
        int totalVisited = 0;
        
        while(points.size() > 0)
        {
            Coord cur = points.removeFirst();
            //out.println(cur);
            
            for(int r = -1; r <= 1; r++)
            {
                for(int c = -1; c <= 1; c++)
                {
                    if(r == 0 || c == 0 && (!(r == 0 && c == 0)))
                    {
                        if(canGoto(maze, cur.r + r, cur.c + c))
                        {
                            //out.println("ADDED");
                            maze[cur.r + r][cur.c + c] = '*';
                            points.add(new Coord(cur.r + r,cur.c + c));
                        }
                    }
                }
            }
            
            if(clearSpots - totalVisited < k)
            {
                maze[cur.r][cur.c] = 'X';
            }
            
            totalVisited++;
        }
        
        for(int r = 0; r < rows; r++)
        {
            for(int c = 0; c < cols; c++)
            {
                if(maze[r][c] == '.' || maze[r][c] == '*')
                    writer.print(".");
                else
                    writer.print(maze[r][c]);
            }
            writer.println();
        }
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean canGoto(char[][] maze, int r, int c)
    {
        //out.println("GOTO: " + r + " " + c);
        if(r >= maze.length)
            return false;
        if(c >= maze[0].length)
            return false;
        if(c < 0)
            return false;
        if(r < 0)
            return false;
        if(maze[r][c] == '.')
            return true;
        return false;
    }
}