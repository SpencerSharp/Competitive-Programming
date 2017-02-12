
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
public class Almost {
    static char[][] b;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("almost.dat"));
        int numLoops = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numLoops; i++) {
            b = new char[3][3];
            for(int r = 0; r < 3; r++)
            {
                String line =sc.nextLine();
                
                for(int c = 0; c < 3; c++)
                {
                    b[r][c] = line.charAt(c);
                }
            }
            for(int k = 1; k <=3; k++)
            {
                if(isPosWin(getRowString(k))!=-1)
                {
                    out.println(k + " " + (isPosWin(getRowString(k))+1));
                }
                if(isPosWin(getColString(k))!=-1)
                {
                    out.println((isPosWin(getColString(k))+1) + " " + k);
                }
            }
            String diag1 = ""+b[0][0] + b[1][1] + b[2][2];
            int in = isPosWin(diag1);
            if(in!=-1)
            {
                if(in==0)
                    out.println("1 1");
                else if(in==1)
                    out.println("2 2");
                else
                    out.println("3 3");
            }
            String diag2 = ""+b[0][2] + b[1][1] + b[2][0];
            in = isPosWin(diag2);
            if(in!=-1)
            {
                if(in==0)
                    out.println("1 3");
                else if(in==1)
                    out.println("2 2");
                else
                    out.println("3 1");
            }
        }
    }
    
    public static int isPosWin(String s)
    {
        int xCount = 0;
        int spaceCount = 0;
        int indexOfSpace = -1;
        for(int i = 0; i < 3; i++)
        {
            if(s.charAt(i)=='X')
                xCount++;
            else if(s.charAt(i)==' '){
                spaceCount++;
                indexOfSpace = i;
            }
        }
        if(xCount==2&&spaceCount==1)
            return indexOfSpace;
        return -1;
                
    }
    
    public static String getColString(int n)
    {
        String s = "";
        for(int  i =0; i < 3; i++)
        {
            s += b[i][n-1];
        }
        return s;
    }
    
    public static String getRowString(int n)
    {
        String s = "";
        for(int i = 0; i < 3; i++)
        {
            s += b[n-1][i];
        }
        return s;
    }
}
