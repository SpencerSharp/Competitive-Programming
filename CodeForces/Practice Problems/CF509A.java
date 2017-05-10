import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF509A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int n = Integer.parseInt(f.readLine());
        int[][] ray = new int[n][n];
        for(int r = 0; r < n; r++)
        {
            ray[r][0] = 1;
            ray[0][r] = 1;
        }
        
        for(int r = 1; r < n; r++)
        {
            for(int c = 0; c < n-r; c++)
            {
                ray[r][r+c] = ray[r-1][r+c] + ray[r][r-1+c];
            }
            for(int c = 0; c < n-r; c++)
            {
                ray[r+c][r] = ray[r-1+c][r] + ray[r+c][r-1];
            }
        }
        int max = 1;
        for(int[] row : ray)
        {
            for(int num : row)
                if(num > max)
                    max = num;
        }
        output = ""+max;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
