import static java.lang.System.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class prob14 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("prob14-1-in.txt"));
        while(sc.hasNextLine())
        {
            int x = Integer.parseInt(sc.next());
            int y = sc.nextInt();
            sc.nextLine();
            char[][] ray = new char[x][y];
            for(int r = 0; r < x; r++)
            {
                String line = sc.nextLine();
                for(int c = 0; c < y; c++)
                {
                    ray[r][c] = line.charAt(c);
                }
            }
            out.println(solveFromSpot(0,0,ray));
        }
    }
    
    public static long solveFromSpot(int r, int c, char[][] ray)
    {
        //out.println(r + " " + c);
        if(ray[r][c]=='#')
            return 0;
        if(r==ray.length-1 && c==ray[r].length-1)
            return 1;
        else
        {
            long total = 0;
            ray[r][c] = '#';
            if(r+1<ray.length)
                total += solveFromSpot(r+1,c,ray);
            if(r-1>=0)
                total += solveFromSpot(r-1,c,ray);
            if(c+1<ray[0].length)
                total += solveFromSpot(r,c+1,ray);
            if(c-1>=0)
                total += solveFromSpot(r,c-1,ray);
            //ray[r][c] = '.';
            return total;
        }
    }
}

