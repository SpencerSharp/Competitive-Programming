import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF467A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numRooms = Integer.parseInt(f.readLine());
        int totalCanStay = 0;
        String line;
        StringTokenizer st;
        for(int i = 0; i < numRooms; i++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            if(q-p>=2)
                totalCanStay++;
        }
        output = ""+totalCanStay;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
