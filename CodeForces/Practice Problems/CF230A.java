import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF230A
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
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        TreeMap<Integer,ArrayList<Integer>> info = new TreeMap<Integer,ArrayList<Integer>>();
        for(int i = 0; i < n; i++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            int strength = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            if(info.containsKey(strength))
            {
                ArrayList<Integer> temp = info.get(strength);
                temp.add(reward);
                info.put(strength,temp);
            }
            else
            {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(reward);
                info.put(strength,temp);
            }
        }
        output = "YES";
        for(Map.Entry<Integer,ArrayList<Integer>> entry : info.entrySet())
        {
            int dragonStrength = entry.getKey();
            ArrayList<Integer> rewards = entry.getValue();
            for(int dragonReward : rewards)
            {
                if(dragonStrength >= s)
                {
                    output = "NO";
                    break;
                }
                else
                {
                    s += dragonReward;
                }
            }
        }
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}