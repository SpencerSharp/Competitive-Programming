import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF71A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numLoops = Integer.parseInt(f.readLine());
        for(int i = 0; i < numLoops; i++)
        {
            String word = f.readLine();
            if(word.length()>10)
            {
                output += "" + word.charAt(0) + (word.length()-2) + word.charAt(word.length()-1);
            }
            else
            {
                output += word;
            }
            //if(i!=numLoops-1)
                output += "\n";
        }
        
        
        
        
        //Code here

        //out.print(output);
        
        writer.print(output);
        writer.close();
        System.exit(0);
        
    }
}
