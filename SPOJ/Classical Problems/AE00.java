import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class AE00
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int n = Integer.parseInt(f.readLine());
        int total = n;
        for(int s = 2; s <=n; s++)
        {
            for(int i = 2; i <= Math.sqrt(s); i++)
            {
                if(s%i==0)
                {
                    total++;
                }
            }
        }
        
        //Code here
        writer.println(total);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
    }
}
