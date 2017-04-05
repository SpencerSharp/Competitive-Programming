import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF141A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int[] nameTotals = new int[26];
        int[] pileTotals = new int[26];
        String line = f.readLine();
        for(int i = 0; i < line.length(); i++)
        {
            nameTotals[line.charAt(i)-'A']++;
        }
        line = f.readLine();
        for(int i = 0; i < line.length(); i++)
        {
            nameTotals[line.charAt(i)-'A']++;
        }
        line = f.readLine();
        for(int i = 0; i < line.length(); i++)
        {
            pileTotals[line.charAt(i)-'A']++;
        }
        boolean canRebuild = true;
        for(int i = 0; i < nameTotals.length; i++)
        {
            if(nameTotals[i]!=pileTotals[i])
                canRebuild = false;
        }
        output = canRebuild?"YES":"NO";
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
