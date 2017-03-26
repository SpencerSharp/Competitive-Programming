import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF282A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int x = 0;
        int size = Integer.parseInt(f.readLine());
        String line;
        for(int i = 0; i < size; i++)
        {
            line = f.readLine();
            if(line.contains("++"))
                x++;
            else if(line.contains("--"))
                x--;
        }
        output = ""+x;
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
