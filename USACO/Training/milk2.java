/*
ID: spencer16
LANG: JAVA
PROG: milk2
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class milk2
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        int numLines = Integer.parseInt(f.readLine());
        
        TreeMap<Integer,Integer> milkTimes = new TreeMap<Integer,Integer>();
        for(int i = 0; i < numLines; i++)
        {
            String line = f.readLine();
            StringTokenizer s = new StringTokenizer(line);
            int start = Integer.parseInt(s.nextToken());
            int end = Integer.parseInt(s.nextToken());
            milkTimes.put(start,end);
        }
        int start = milkTimes.firstKey();
        
        int end = milkTimes.get(milkTimes.firstKey());
        for(Map.Entry<Integer,Integer> e : milkTimes.entrySet())
        {
            //out.println(e.getKey() + " " + e.getValue());
            if(e.getValue()>end);
                end = e.getValue();
        }
        //out.println("END"+start);

        ArrayList<Integer> contTimes = new ArrayList<Integer>();
        ArrayList<Integer> idleTimes = new ArrayList<Integer>();
        int cur = start;

        int contTime = 0;
        int idleTime = 0;
        for(Map.Entry<Integer,Integer> e : milkTimes.entrySet())
        {
            int start1 = e.getKey();
            int end1 = e.getValue();
            if(cur >= start1 && cur < end1)
            {
                contTime+=end1-cur;
                cur = end1;
                //out.print(contTime>10000?start1+"\n":"");
            }
            else if(start1 > cur)
            {
                //out.println("break"+start1+" " +cur);
                contTimes.add(contTime);
                idleTime = start1-cur;
                idleTimes.add(idleTime);
                contTime = end1-start1;
                cur = end1;
            }
        }
        contTimes.add(contTime);
        //out.println(idleTimes);
        int maxIdle = 0;
        if(idleTimes.size() > 0)
            maxIdle = idleTimes.get(0);
        for(int n : idleTimes)
            if(n > maxIdle)
                maxIdle = n;

        int maxActive = 0;
        if(contTimes.size() > 0)
            maxActive = contTimes.get(0);
        for(int n : contTimes)
            if(n > maxActive)
                maxActive = n;
        output += maxActive + " " + maxIdle;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
