import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF707A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        
        boolean isColored = false;
        
        for(int r = 0; r < rows; r++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            for(int c = 0; c < cols; c++)
            {
                char cur = st.nextToken().charAt(0);
                if(cur=='C'||cur=='M'||cur=='Y')
                    isColored = true;
            }
        }
        output = isColored ? "#Color" : "#Black&White";
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
