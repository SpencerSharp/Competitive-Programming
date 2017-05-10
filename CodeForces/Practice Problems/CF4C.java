import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF4C
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        HashMap<String,Integer> names = new HashMap<String,Integer>();
        String line = f.readLine();
        int numNames = Integer.parseInt(line);
        for(int i = 0; i < numNames; i++)
        {
            String name = f.readLine();
            if(names.get(name)==null)
            {
                names.put(name, 0);
                out.println("OK");
            }
            else
            {
                int num = names.get(name);
                names.put(name,num+1);
                out.println(name + (num+1));
            }
        }
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
