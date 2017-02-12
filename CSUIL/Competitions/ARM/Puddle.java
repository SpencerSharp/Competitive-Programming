
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bo
 */
public class Puddle {
    public static char[][] map;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("puddle.dat"));
        //int numLoops = sc.nextInt();
        //sc.nextLine();
            int rows = Integer.parseInt(sc.next());
            int cols = Integer.parseInt(sc.next());
            sc.nextLine();
            map = new char[rows][cols];
            for(int r = 0; r < map.length; r++)
            {
                String line = sc.nextLine();
                for(int c = 0; c < map[r].length; c++)
                {
                    map[r][c] = line.charAt(c);
                }
            }
            //disp();
            int numMoves = sc.nextInt();
            for(int i = 0; i < numMoves; i++)
            {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if(map[x][y]=='G')
                    out.println("OK");
                else if(map[x][y]=='R' || map[x][y] == 'S')
                    out.println("OOPS");
                else
                {
                    out.println("PUDDLE");
                    freezePuddle(x,y);
                }
            }
            out.println();
            disp();
    }
    
    public static void freezePuddle(int x, int y)
    {
        if(x >= 0 && x < map.length)
        {
            if(y>=0 && y < map[x].length)
            {
                if(map[x][y]=='W')
                {
                    map[x][y] = 'F';
                    freezePuddle(x-1,y);
                    freezePuddle(x+1,y);
                    freezePuddle(x,y-1);
                    freezePuddle(x,y+1);
                }
            }
        }
    }
    public static void disp()
    {
        String s = "";
        for(int r = 0; r < map.length; r++)
        {
            for(int c = 0; c < map[r].length; c++)
            {
                s += map[r][c];
            }
            s += "\n";
        }
        out.print(s);
    }
}
