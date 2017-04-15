import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF540A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int len = Integer.parseInt(f.readLine());
        String start = f.readLine();
        String end = f.readLine();
        long total = 0;
        for(int i = 0; i < len; i++)
        {
            total += getMinDistTo(start.charAt(i),end.charAt(i));
        }
        output = ""+total;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int getMinDistTo(char a, char b)
    {
        int pos1 = Math.abs(a-b);
        int pos2 = Math.min(a, b)+10 - Math.max(a,b);
        return Math.min(pos1, pos2);
    }
}