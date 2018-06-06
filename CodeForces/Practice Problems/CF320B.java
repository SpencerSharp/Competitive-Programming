import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF320B
{
    public static HashMap<Integer,Interval> intervals;
    
    public static class Interval
    {
        int id;
        int start;
        int end;
        HashSet<Integer> canDirectlyGoTo;
        
        public Interval(int id, int start, int end)
        {
            this.id = id;
            this.start = start;
            this.end = end;
            canDirectlyGoTo = new HashSet<Integer>();
        }
        
        public boolean canDirectGoTo(Interval other)
        {
            if(other.start < start && start < other.end)
            {
                return true;
            }
            if(other.start < end && end < other.end)
            {
                return true;
            }
            return false;
        }
        
        public boolean canGoTo(Interval other)
        {
            return recCanGoTo(other, new HashSet<Integer>());
        }
        
        public boolean recCanGoTo(Interval other, HashSet<Integer> visited)
        {
            if(this.equals(other))
                return true;
            
            visited.add(id);
            for(int num : canDirectlyGoTo)
            {
                if(!visited.contains(num))
                {
                    if(intervals.get(num).recCanGoTo(other, visited))
                        return true;
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        
        intervals = new HashMap<Integer,Interval>();
        int numQ = Integer.parseInt(f.readLine());
        StringTokenizer st;
        int id = 0;
        
        for(int i = 0; i < numQ; i++)
        {
            st = new StringTokenizer(f.readLine());
            
            int type = Integer.parseInt(st.nextToken());
            
            if(type == 1)
            {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                Interval interval = new Interval(id++, start, end);
                
                intervals.put(id-1, interval);
                
                for(int j = 0; j < id-1; j++)
                {
                    if(interval.canDirectGoTo(intervals.get(j)))
                    {
                        interval.canDirectlyGoTo.add(j);
                    }
                    if(intervals.get(j).canDirectGoTo(interval))
                    {
                        intervals.get(j).canDirectlyGoTo.add(interval.id);
                    }
                }
            }
            else
            {
                int startInterval = Integer.parseInt(st.nextToken());
                int endInterval = Integer.parseInt(st.nextToken());
                
                if(intervals.get(startInterval-1).canGoTo(intervals.get(endInterval-1)))
                {
                    writer.println("YES");
                }
                else
                {
                    writer.println("NO");
                }
            }
        }
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}