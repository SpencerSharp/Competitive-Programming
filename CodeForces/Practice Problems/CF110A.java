import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF110A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        char[] luck = {'4','7'};
        String line = f.readLine();
        int numLuck = 0;
        for(int i = 0; i < line.length(); i++)
        {
            if(line.charAt(i)=='4'||line.charAt(i)=='7')
                numLuck++;
        }
        output = numLuck==4||numLuck==7?"YES":"NO";
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
