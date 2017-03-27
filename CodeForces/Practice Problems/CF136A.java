import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF136A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        int numP = Integer.parseInt(f.readLine());
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for(int i = 1; i <= numP; i++)
        {
            map.put(Integer.parseInt(st.nextToken()),i);
        }
        
        while(map.size()>0)
        {
            output += map.pollFirstEntry().getValue() + " ";
        }
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
