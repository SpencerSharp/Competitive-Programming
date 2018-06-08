
import static java.lang.System.*;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spencersharp
 */
public class wordwalker {
    public static void main(String[] args)
    {
        String s = "It is my humble opinion that standard text is boring. Therefore I introduce a new writing, standard, walking words!";
        char[][] disp = new char[300][300];
        for(int i = 0; i < disp.length; i++)
            for(int j = 0; j < disp[i].length; j++)
                disp[i][j] = ' ';
        int curChar = 0;
        int dir = 2;
        int curX = 150;
        int curY = 150;
        //u = 0
        //d = 1
        //r = 2
        
        while(curChar < s.length())
        {
            disp[curX][curY] = s.charAt(curChar);
            String temp = ""+s.charAt(curChar);
            temp = temp.toUpperCase();
            if(temp.equals("U"))
                dir = 0;
            else if(temp.equals("D"))
                dir = 1;
            else if(temp.equals("R"))
                dir = 2;
            else if(temp.equals("L"))
                dir = 3;
            if(dir==0)
                curX--;
            else if(dir==1)
                curX++;
            else if(dir==2)
                curY++;
            else if(dir==3)
                curY--;
            curChar++;
        }
        out.print(disp(disp));
        
        //out.println("FUN");
    }
    
    public static String disp(char[][] ray)
    {
        int firstCol = 0;
        boolean done = false;
        for(int i = 0; i < ray.length; i++){
            for(int j = 0; j < ray[i].length;j++){
                char temp = ray[j][i];
                if(temp!=' '){
                    firstCol = i;
                    done = true;
                    break;}
            }
            if(done)
                break;
        }
        int lastCol = 0;
        //done = false;
        for(int i = 0; i < ray.length; i++){
            for(int j = 0; j < ray[i].length;j++){
                char temp = ray[j][i];
                if(temp!=' '){
                    lastCol = i;
                    break;}
            }
        }
        String ret = "";
        for(int i = 0; i < ray.length; i++)
        {
            char[] row = ray[i];
            String line = "";
            boolean doesContainNonSpace = false;
            for(int j = 0; j < row.length; j++)
            {
                char b = row[j];
                if(j>=firstCol&&j <= lastCol)
                    line += b;
                if(b!=' ')
                    doesContainNonSpace = true;
            }
            if(doesContainNonSpace)
                ret += line + "\n";
            //ret += "\n";
        }
        return ret;
    }
}
