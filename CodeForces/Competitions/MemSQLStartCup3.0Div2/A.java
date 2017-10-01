import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numFS = 0;
        int numSF = 0;
        
        int numDays = Integer.parseInt(f.readLine());
        
        String places = f.readLine();
        
        char prev = places.charAt(0);
        
        for(int i = 1; i < numDays; i++)
        {
            char cur = places.charAt(i);
            if(cur == 'S')
            {
                if(prev == 'F')
                {
                    numFS++;
                }
            }
            else if(cur == 'F')
            {
                if(prev == 'S')
                {
                    numSF++;
                }
            }
            prev = cur;
            //out.println(numFS + " " + numSF);
        }
        
        
        
        if(numSF > numFS)
            output = "YES";
        else
            output = "NO";
        
        
        //Code here

        //writer.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}