import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class B
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
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        
        int[][] vals = new int[n][n];
        
        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < n; j++)
            {
                vals[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int r = 0; r <= n - k; r++) //
        {
            for(int c = 0; c <= n - k; c++)
            {
                double total = 0.0;
                for(int r1 = r; r1 < r + k; r1++)
                {
                    for(int c1 = c; c1 < c + k; c1++)
                    {
                        total += vals[r1][c1];
                    }
                }
                total /= (k * k);
                //out.println(total);
                min = Math.min(total,min);
                max = Math.max(total,max);
            }
            
        }
        
        double diff = max - min;
        
        output = ""+diff;
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}