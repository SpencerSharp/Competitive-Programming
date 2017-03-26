import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF263A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int[][] ray = new int[5][5];
        String line;
        StringTokenizer st;
        for(int r = 0; r < 5; r++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            for(int c = 0; c < 5; c++)
            {
                ray[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        output = ""+getDistFromBeautiful(ray);
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int getDistFromBeautiful(int[][] ray)
    {
        int r = 0;
        int c = 0;
        for(int tR = 0; tR < 5; tR++)
            for(int tC = 0; tC < 5; tC++)
            {
                if(ray[tR][tC]==1)
                {
                    r = tR;
                    c = tC;
                }
            }
        int ret = 0;
        ret += Math.abs(2-r);
        ret += Math.abs(2-c);
        return ret;
    }
}
