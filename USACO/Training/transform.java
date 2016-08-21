/*
ID: spencer16
LANG: JAVA
PROG: transform
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class transform
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        int squareSize = Integer.parseInt(f.readLine());
        
        String[] initRayS = new String[squareSize];
        for(int i = 0; i < squareSize; i++)
            initRayS[i] = f.readLine();
        
        String[] initRayE = new String[squareSize];
        for(int i = 0; i < squareSize; i++)
            initRayE[i] = f.readLine();
        
        char[][] start = new char[squareSize][squareSize];
        char[][] end = new char[squareSize][squareSize];
        for(int r = 0; r < squareSize; r++)
            for(int c = 0; c < squareSize; c++)
                start[r][c] = initRayS[r].charAt(c);
        for(int r = 0; r < squareSize; r++)
            for(int c = 0; c < squareSize; c++)
                end[r][c] = initRayE[r].charAt(c);
        //out.println(disp(start));
        
        
        //out.println(disp(rot90(start)));
        //out.println(disp(end));
        //out.println(equals(rot90(start),end)?"GOOD":"BAD");
        output += getTransform(start,end);
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int getTransform(char[][] start, char[][] end)
    {
        char[][] aft = rot90(start);
        if(equals(end,aft))
            return 1;

        char[][] aft2 = rot180(start);
        if(equals(end,aft2))
            return 2;
        
        char[][] aft3 = rot270(start);
        if(equals(end,aft3))
            return 3;
        
        char[][] aft4 = reflect(start);
        if(equals(end,aft4))
            return 4;
        
        char[][] aft5 = rot90(aft4);
        if(equals(end,aft5))
            return 5;
        
        char[][] aft6 = rot180(aft4);
        if(equals(end,aft6))
            return 5;
        
        char[][] aft7 = rot270(aft4);
        if(equals(end,aft7))
            return 5;
        
        if(equals(start,end))
            return 6;
        
        return 7;
    }
    
    public static String disp(char[][] ray)
    {
        String ret = "";
        for(int r = 0; r < ray.length; r++)
        {
            for(int c = 0; c < ray.length; c++)
                ret += ray[r][c];
            ret += "\n";
        }
        return ret;
    }
    
    public static boolean equals(char[][] ray1, char[][] ray2)
    {
        if(ray1.length!=ray2.length)
            return false;
        for(int i = 0; i < ray1.length; i++)
            if(ray1[i].length != ray2[i].length)
                return false;
        for(int r = 0; r < ray1.length; r++)
            for(int c = 0; c < ray1[r].length; c++)
                if(ray1[r][c]!=ray2[r][c])
                    return false;
        return true;
    }
    
    public static char[][] copy(char[][] start)
    {
        char[][] copy = new char[start.length][start.length];
        for(int r = 0; r < start.length; r++)
                for(int c = 0; c < start[r].length; c++)
                    copy[r][c] = start[r][c];
        return copy;
    }

    public static char[][] rot90(char[][] start)
    {
        char[][] operate = copy(start);
        //Perform operations on operate
        for(int r = 0; r < start.length; r++)
            for(int c = 0; c < start.length; c++)
                operate[r][c] = start[start.length-c-1][r];
        return operate;
    }
    
    public static char[][] rot180(char[][] start)
    {
        char[][] operate = copy(start);
        //Perform operations on operate
        operate = rot90(operate);
        operate = rot90(operate);
        return operate;
    }
    
    public static char[][] rot270(char[][] start)
    {
        char[][] operate = copy(start);
        //Perform operations on operate
        operate = rot90(operate);
        operate = rot90(operate);
        operate = rot90(operate);
        return operate;
    }
    
    public static char[][] reflect(char[][] start)
    {
        char[][] operate = copy(start);
        //Perform operations on operate
        for(int r = 0; r < start.length; r++)
            for(int c = 0; c < start.length; c++)
                operate[r][c] = start[r][start.length-c-1];
        return operate;
    }
}