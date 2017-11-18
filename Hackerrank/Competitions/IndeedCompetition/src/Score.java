import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Score
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        
        line = line.toLowerCase();
        
        long total = 0;
        
        HashSet<Character> letters = new HashSet<Character>();
        
        for(int i = 0; i < line.length(); i++)
        {
            char c = line.charAt(i);
            if(!letters.contains(c))
            {
                letters.add(c);
                total += line.charAt(i) - 'a' +1;
            }
            //out.println(line.charAt(i) + " " + total);
        }
        output = ""+total;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}