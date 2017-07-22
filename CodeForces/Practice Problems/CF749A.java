import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF749A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int k = Integer.parseInt(f.readLine());
        
        writer.println(k/2);
        
        for(int i = 0; i < (k/2)-1; i++)
        {
            writer.print(2 + " ");
        }
        
        if(k%2==0)
            writer.println(2);
        else
            writer.println(3);
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}