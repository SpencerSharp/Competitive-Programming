import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF344A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        int numMags = Integer.parseInt(line);
        int numGroups = 1;
        line = f.readLine();
        char prev = line.charAt(1);
        for(int i = 0; i < numMags-1; i++)
        {
            line = f.readLine();
            char cur = line.charAt(0);
            if(!matches(prev,cur))
            {
                numGroups++;
            }
            prev = line.charAt(1);
        }
        output = ""+numGroups;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean matches(char c1, char c2)
    {
        if(c1=='0'&&c2=='1')
            return true;
        if(c1=='1'&&c2=='0')
            return true;
        return false;
    }
}