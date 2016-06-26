import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Spoj1
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        while(!line.equals("42"))
        {
            output += line + "\n";
            //out.println(output);
            line = f.readLine();
        }
        output = output.substring(0,output.length()-1);
        
        
        
        //Code here

        out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
}
