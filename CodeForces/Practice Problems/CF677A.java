import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF677A
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
        int numFriends = Integer.parseInt(st.nextToken());
        int fenceHeight = Integer.parseInt(st.nextToken());
        line = f.readLine();
        st = new StringTokenizer(line);
        int numTallFriends = 0;
        for(int i = 0; i < numFriends; i++)
        {
            int friendHeight = Integer.parseInt(st.nextToken());
            if(friendHeight>fenceHeight)
                numTallFriends++;
        }
        output = ""+(numTallFriends+numFriends);
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}