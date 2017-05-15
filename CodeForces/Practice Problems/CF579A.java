import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF579A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        long input = Long.parseLong(f.readLine());
        String binary = Long.toBinaryString(input);
        long total = 0;
        for(int i = 0; i < binary.length(); i++)
            if(binary.charAt(i)=='1')
                total++;
        output = ""+total;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
