import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF228A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        String[] colors = line.split(" ");
        ArrayList<Integer> uniques = new ArrayList<Integer>();
        for(String s : colors)
        {
            int n = Integer.parseInt(s);
            boolean isUnique = true;
            for(int u : uniques)
            {
                if(n==u)
                    isUnique = false;
            }
            if(isUnique)
            {
                uniques.add(n);
            }
        }
        output = ""+(4 - uniques.size());
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
