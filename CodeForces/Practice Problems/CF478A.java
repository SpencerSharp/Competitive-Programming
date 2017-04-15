import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF478A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String[] nums = f.readLine().split(" ");
        int total = 0;
        for(String s : nums)
        {
            int n = Integer.parseInt(s);
            total += n;
        }
        output = total!=0&&total%5==0?""+total/5:"-1";
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
