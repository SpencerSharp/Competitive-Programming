import static java.lang.System.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class prob09 {
    static char[][] ray;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("prob09-1-in.txt"));
        Stack<String> st = new Stack();
        ray = new char[60][20];
        while(sc.hasNextLine())
        {
            st.add(sc.nextLine());
        }
        st.pop();
        out.println(st);
        while(!st.isEmpty())
        {
            Scanner line = new Scanner(st.pop());
            int x = line.nextInt();
            int h = line.nextInt();
            out.println(h + " " + x);
            drawPyramid(h,x);
        }
        out.println(disp());
    }
    
    public static String disp()
    {
        String ret = "";
        for(int r = 0; r < ray.length; r++)
        {
            for(int c = 0; c < ray[r].length; c++)
            {
                ret += ray[r][c];
            }
            ret += "\n";
        }
        ret += "123456789012345678901234567890123456789012345678901234567890";
        return ret;
    }
    
    public static void drawPyramid(int h, int x)
    {
        for(int i = 0; i < h; i++)
        {
            for(int j = 0; j < (h-i)*2; j++)
            {
                if((x-h+j+1)<20&&(x-h+j+1)>=0){
                if(j==0)
                    ray[19-i][x-h+j+1] = '/';
                else if(j==((h-i)*2)-1)
                    ray[19-i][x-h+j+1] = '\\';
                else
                    ray[19-i][x-h+j+1] = ' ';
                }
            }
        }
    }
}

