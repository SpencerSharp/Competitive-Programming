import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class SAMER08F
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        while(!line.equals("0"))
        {
            int gridSide = Integer.parseInt(line);
            long total = 0;
            for(long i = 1; i <= gridSide; i++)
            {
                total += i * i;
            }
            //long numSquares = getNumSquares(gridSide);
            writer.println(total);
            line = f.readLine();
        }
        
        
        
        
        //Code here

        //out.println(output);
        /*
        writer.println(output);*/
        writer.close();
        System.exit(0);
        
    }
    
    public static long getNumSquares(long n)
    {
        if(n==1)
            return 1;
        else
        {
            long overlap = n*n-((n-1)*(n-1));
            return (getNumSquares(n-1)*4 + 1)-((n-2)*4)-(getNumSquares(n-2)*4);
        }
    }
}
