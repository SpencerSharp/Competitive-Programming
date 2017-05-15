import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF270A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numLoops = Integer.parseInt(f.readLine());
        for(int i = 0; i < numLoops; i++)
        {
            int inpNum = Integer.parseInt(f.readLine());
            double result = (-360.0)/(inpNum-180.0);
            out.println(result%1==0?"YES":"NO");
        }
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
