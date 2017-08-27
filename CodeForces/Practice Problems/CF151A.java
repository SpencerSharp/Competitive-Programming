import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF151A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int nl = Integer.parseInt(st.nextToken());
        int np = Integer.parseInt(st.nextToken());
        
        long numSlices = c * d;
        long numMillis = k*l;
        long numFriends = n;
        
        long numToastsBasedOnMillis = (numMillis/nl)/numFriends;
        long numToastsBasedOnLimes = numSlices/numFriends;
        long numToastsBasedOnSalt = (p/np)/numFriends;
        
        long numToasts = Math.min(numToastsBasedOnMillis,Math.min(numToastsBasedOnLimes, numToastsBasedOnSalt));
        
        output = ""+numToasts;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}