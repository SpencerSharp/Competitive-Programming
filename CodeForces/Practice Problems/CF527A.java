import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF527A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        long numSquares = 0;
        while(a > 0 && b > 0)
        {
            //out.println(a + " " + b);
            long squares = (a/b);
            numSquares += squares;
            a -= squares*b;
            if(a < b)
            {
                long temp = a;
                a = b;
                b = temp;
            }
        }
        
        output = ""+numSquares;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}