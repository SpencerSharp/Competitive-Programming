import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF4A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int input = Integer.parseInt(f.readLine());
        boolean canBeSplit = false;
        for(int i = 1; i < input ; i++)
        {
            int i2 = input-i;
            if(i%2==0 && i2%2==0)
            {
                canBeSplit = true;
                break;
            }
        }
        
        //Code here
        output = canBeSplit?"YES":"NO";
        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
