import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Stair
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        int w = Integer.parseInt(st.nextToken());
        
        int h = Integer.parseInt(st.nextToken());
        
        //Top side
        
        int total = 0;
        
        //Top view
        total += w*h;
        
        //Left view
        total += w*h;
        
        //Front view
        for(int i = 0; i < h; i++)
        {
            for(int j = 0; j < h; j++)
            {
                if(i <= j)
                {
                    total += 2;
                }
            }
        }
        
        output = ""+total;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}