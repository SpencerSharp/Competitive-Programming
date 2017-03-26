import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF122A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int num = Integer.parseInt(f.readLine());
        boolean al = false;
        int[] luckys = {4,7,47,74,444,447,474,477,744,747,774,777};
        for(int n : luckys)
            if(num%n==0)
                al = true;
        output = al?"YES":"NO";
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
