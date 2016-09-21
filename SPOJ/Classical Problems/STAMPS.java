import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class STAMPS
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        //String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int numLoops = Integer.parseInt(line);
        for(int l = 0; l < numLoops; l++)
        {
            int minFriends = 0;
            line = f.readLine();
            st = new StringTokenizer(line);
            int numStampsNeeded = Integer.parseInt(st.nextToken());
            int numFriends = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> friendsStamps = new PriorityQueue<>(numFriends, Collections.reverseOrder());
            int totalStampsSoFar = 0;
            //Reading in friends stamps vals
            line = f.readLine();
            st = new StringTokenizer(line);
            while(st.hasMoreTokens())
                friendsStamps.add(Integer.parseInt(st.nextToken()));
            while(totalStampsSoFar<numStampsNeeded && friendsStamps.size()>0)
            {
                totalStampsSoFar += friendsStamps.poll();
                //out.println(totalStampsSoFar);
                minFriends++;
            }
            if(totalStampsSoFar<numStampsNeeded)
                minFriends = -1;
            //At the end
            out.println("Scenario #" + (l+1) + ":");
            if(minFriends!=-1)
                out.println(minFriends);
            else
                out.println("impossible");
            out.println();
        }
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
    }
}
