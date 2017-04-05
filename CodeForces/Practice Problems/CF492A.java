import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF492A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int n = Integer.parseInt(f.readLine());
        int levelSize = 1;
        int numLevels = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < levelSize; j++)
                n--;
            levelSize+=i+2;
            numLevels++;
            //out.println(n);
        }
        if(n<0)
            numLevels--;
        output = ""+numLevels;
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}