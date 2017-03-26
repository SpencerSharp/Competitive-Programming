import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF339A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int[] numTotals = new int[3];
        String line = f.readLine();
        for(int i = 0; i < line.length(); i+=2)
            numTotals[Integer.parseInt(""+line.charAt(i))-1]++;
        for(int i = 0; i < numTotals[0]; i++)
            output += "1+";
        for(int i = 0; i < numTotals[1]; i++)
            output += "2+";
        for(int i = 0; i < numTotals[2]; i++)
            output += "3+";
        output = output.substring(0,output.length()-1);
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
