import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

//Link here: http://codeforces.com/contest/676/problem/D
//Finish later

public class Theseus
{
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int numRows = Integer.parseInt(st.nextToken());
        int numCols = Integer.parseInt(st.nextToken());
        char[][] maze = new char[numRows][numCols];
        for(int r = 0; r < numRows; r++)
        {
            line = f.readLine();
            for(int c = 0; c < numCols; c++)
            {
                maze[r][c] = line.charAt(c);
            }
        }
        line = f.readLine();
        st = new StringTokenizer(line);
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;
        int[] curLoc = {x,y};
        line = f.readLine();
        st = new StringTokenizer(line);
        x = Integer.parseInt(st.nextToken())-1;
        y = Integer.parseInt(st.nextToken())-1;
        int[] minLoc = {x,y};
        
        output += solve(maze,curLoc,minLoc,0);
        
        //out.println(disp(maze));
        //out.println(disp(rot90(maze)));
        //out.println(disp(rot90(rot90(maze))));
        //out.println(disp(rot90(rot90(rot90(maze)))));
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static String disp(char[][] ray)
    {
        String ret = "";
        for(int r = 0; r < ray.length; r++)
        {
            for(int c = 0; c < ray[r].length; c++)
                ret += ray[r][c];
            ret += "\n";
        }
        return ret;
    }
    
    public static char[][] set(char[][] maze, int[] curLoc, char c)
    {
        char[][] maze2 = copy(maze);
        int x = curLoc[0];
        int y = curLoc[1];
        maze2[x][y] = c;
        return maze2;
    }
    
    public static int solve(char[][] maze, int[] curLoc, int[] minLoc, int curRots)
    {
        //out.println("call");
        if(isDone(curLoc,minLoc))
        {
            //out.println("done");
            return 0;
        }
        else
        {
            ArrayList<Integer> minDists = new ArrayList<Integer>();
            
            int[] dest1 = {curLoc[0],curLoc[1]+1};
            int[] dest2 = {curLoc[0],curLoc[1]-1};
            int[] dest3 = {curLoc[0]+1,curLoc[1]};
            int[] dest4 = {curLoc[0]-1,curLoc[1]};
            if(canMove(maze,curLoc,dest1))
            {
                //out.println("moveR");
                char[][] maze2 = set(maze,curLoc,'*');
                int n = solve(maze2,dest1,minLoc,0);
                if(n>=0)
                    minDists.add(n+1);
            }
            if(canMove(maze,curLoc,dest2))
            {
                //out.println("moveL");
                char[][] maze2 = set(maze,curLoc,'*');
                int n = solve(maze2,dest2,minLoc,0);
                if(n>=0)
                    minDists.add(n+1);
            }
            if(canMove(maze,curLoc,dest3))
            {
                //out.println("moveD");
                char[][] maze2 = set(maze,curLoc,'*');
                int n = solve(maze2,dest3,minLoc,0);
                if(n>=0)
                    minDists.add(n+1);
            }
            if(canMove(maze,curLoc,dest3))
            {
                //out.println("moveU");
                char[][] maze2 = set(maze,curLoc,'*');
                int n = solve(maze,dest3,minLoc,0);
                if(n>=0)
                    minDists.add(n+1);
            }
            if(curRots<4)
            {
                //out.println("c"+curRots);
                int n = solve(rot90(maze),curLoc,minLoc,curRots+1);
                if(n>=0)
                    minDists.add(n+1);
            }

            int min = 0;
            if(minDists.size()>0)
                min = minDists.get(0);
            else
                min = -1;
            for(int n : minDists)
                if(n < min && n >=0)
                    min = n;
            //out.println(minDists);
            return min;
        }
    }
    
    public static boolean isLeftMover(char c)
    {
        char[] ray = {'+','-','<','R','U','D'};
        for(char s : ray)
            if(s==c)
                return true;
        return false;
    }
    
    public static boolean isRightMover(char c)
    {
        char[] ray = {'+','-','>','L','U','D'};
        for(char s : ray)
            if(s==c)
                return true;
        return false;
    }
    
    public static boolean isUpMover(char c)
    {
        char[] ray = {'+','|','^','L','R','D'};
        for(char s : ray)
            if(s==c)
                return true;
        return false;
    }
    
    public static boolean isDownMover(char c)
    {
        char[] ray = {'+','|','v','L','R','U'};
        for(char s : ray)
            if(s==c)
                return true;
        return false;
    }
    
    public static char get(char[][] maze, int[] loc)
    {
        int x = loc[0];
        int y = loc[1];
        char c = maze[x][y];
        return c;
    }
    
    public static boolean canMove(char[][] maze, int[] curLoc, int[] dest)
    {
        if(dest[0]>=0 && dest[0]<maze.length && dest[1]>=0 && dest[1]<maze[0].length)
        {
            //out.println(dest[0] + " " + dest[1]);
            char block = get(maze,curLoc);
            if(dest[0]==curLoc[0]) //Moving side to side
            {
                if(curLoc[0]>dest[0]) //Moving left
                {
                    if(isLeftMover(block))
                    {
                        char otherBlock = get(maze,dest);
                        if(isRightMover(otherBlock))
                            return true;
                    }
                }
                else //Moving Right
                {
                    if(isRightMover(block))
                    {
                        char otherBlock = get(maze,dest);
                        if(isLeftMover(otherBlock))
                            return true;
                    }
                }
            }
            else //Moving up down
            {
                if(curLoc[0]>dest[0]) //Moving up
                {
                    if(isUpMover(block))
                    {
                        char otherBlock = get(maze,dest);
                        if(isDownMover(otherBlock))
                            return true;
                    }
                }
                else //Moving down
                {
                    if(isDownMover(block))
                    {
                        char otherBlock = get(maze,dest);
                        if(isUpMover(otherBlock))
                            return true;
                    }
                }
            }
        }
        //out.println("bad");
        return false;
        
    }

    public static boolean isDone(int[] curLoc, int[] minLoc)
    {
        if(curLoc[0]==minLoc[0]&&curLoc[1]==minLoc[1])
            return true;
        return false;
    }
    public static char[][] copy(char[][] start)
    {
        char[][] copy = new char[start.length][start[0].length];
        for(int r = 0; r < start.length; r++)
                for(int c = 0; c < start[r].length; c++)
                    copy[r][c] = start[r][c];
        return copy;
    }

    public static char[][] rot90(char[][] start)
    {
        char[][] operate = new char[start.length][start[0].length];
        //Perform operations on operate
        for(int r = 0; r < operate.length; r++)
            for(int c = 0; c < operate[r].length; c++)
            {
                char block = start[r][c];
                char newBlock = 0;
                if(block=='-')
                    newBlock = '|';
                else if(block=='|')
                    newBlock = '-';
                else if(block=='^')
                    newBlock = '>';
                else if(block=='>')
                    newBlock ='v';
                else if(block=='v')
                    newBlock='<';
                else if(block=='<')
                    newBlock='^';
                else if(block=='L')
                    newBlock='U';
                else if(block=='U')
                    newBlock='R';
                else if(block=='R')
                    newBlock='D';
                else if(block=='D')
                    newBlock='L';
                operate[r][c] = newBlock;
            }
        return operate;
    }
    
    public static boolean isValidRot(char[][] maze, int[] curLoc, int[] minLoc)
    {
        if(curLoc[0]>=0&&curLoc[0]<maze[0].length&&curLoc[1]>=0&&curLoc[1]<maze.length)
        {
            if(minLoc[0]>=0&&minLoc[0]<maze[0].length&&minLoc[1]>=0&&minLoc[1]<maze.length)
                return true;
        }
        return false;
    }
    
    public static int[] rot90Loc(int[] loc, char[][] maze)
    {
        int[] newLoc = new int[2];
        for(int r = 0; r < maze.length; r++)
            for(int c = 0; c < maze[r].length; c++)
                if(loc[0]==maze.length-c-1 && loc[1]==r)
                {
                    newLoc[0] = r;
                    newLoc[1] = c;
                }
        return newLoc;
    }
}
