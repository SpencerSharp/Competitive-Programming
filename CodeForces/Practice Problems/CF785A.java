import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF785A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numShapes = Integer.parseInt(f.readLine());
        
        long numSides = 0;
        
        for(int i = 0; i < numShapes; i++)
        {
            char c = f.readLine().charAt(0);
            switch(c)
            {
                case 'T': numSides += 4;  break;
                case 'C': numSides += 6;  break;
                case 'O': numSides += 8;  break;
                case 'D': numSides += 12; break;
                case 'I': numSides += 20; break;
            }
        }
        
        output = ""+numSides;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}