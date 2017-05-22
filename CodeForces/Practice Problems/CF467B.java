import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF467B
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
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        HashMap<Integer,String> posFriends = new HashMap<Integer,String>();
        
        for(int i = 0; i < m; i++)
            posFriends.put(i,f.readLine());
        
        int fedor = Integer.parseInt(f.readLine());
        
        //f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        //f = new BufferedReader(new InputStreamReader(System.in));
        
        //f.readLine();
        
        int totalFriends = 0;
        
        for(int i = 0; i < m; i++)
        {
            int result = fedor^Integer.parseInt(posFriends.get(i));
            String solds = Integer.toBinaryString(result);
            //out.println(solds);
            int numDiffs = 0;
            for(int l = 0; l < solds.length(); l++)
                if(solds.charAt(l)=='1')
                    numDiffs++;
            if(numDiffs <= k)
                totalFriends++;
        }
        output = ""+totalFriends;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
