import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF520A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        f.readLine();
        String inp = f.readLine();
        int[] numLets = new int[26];
        inp = inp.toLowerCase();
        for(int i = 0; i < inp.length(); i++)
        {
            numLets[inp.charAt(i)-'a']++;
        }
        boolean isPan = true;
        for(int c : numLets)
            if(c == 0)
                isPan = false;
        output = isPan?"YES":"NO";
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
