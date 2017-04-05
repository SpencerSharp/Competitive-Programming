import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF200B
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        double total = 0;
        int numDrinks = Integer.parseInt(f.readLine());
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for(int i = 0; i < numDrinks; i++)
            total += Integer.parseInt(st.nextToken());
        output = String.format("%.12f",total/numDrinks);
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
