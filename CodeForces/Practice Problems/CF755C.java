import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF755C
{
    static HashMap<Long,Ball> balls = new HashMap<Long,Ball>();
    static HashMap<Long,Ball> visited = new HashMap<Long,Ball>();
    static HashMap<Long,Ball> notVisited = new HashMap<Long,Ball>();
    public static class Ball
    {
        long id;
        HashSet<Long> connections = new HashSet<Long>();
        
        public String toString()
        {
            return ""+id;
        }
    }
    
    public static long findAllGroups()
    {
        long numGroups = 0;
        while(visited.size() < balls.size())
        {
            Ball start = null;
            for(long l : notVisited.keySet())
            {
                start = notVisited.get(l);
                break;
            }
            Stack<Ball> stack = new Stack<Ball>();
            stack.add(balls.get(start.id));

            while(stack.size() > 0)
            {
                Ball cur = stack.pop();
                for(Long id : cur.connections)
                {
                    if(visited.get(id) == null)
                    {
                        stack.add(balls.get(id));
                    }
                }
                visited.put(cur.id, cur);
                notVisited.remove(cur.id);
            }
            numGroups++;
        }
        return numGroups;
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        f.readLine();
        StringTokenizer st = new StringTokenizer(f.readLine());
        long id = 1;
        while(st.hasMoreTokens())
        {
            long connection = Long.parseLong(st.nextToken());
            
            if(balls.get(connection) != null)
            {
                balls.get(connection).connections.add(id);
            }
            else
            {
                Ball b = new Ball();
                b.id = connection;
                b.connections.add(id);
                balls.put(b.id,b);
                notVisited.put(b.id, b);
            }
            
            if(balls.get(id) != null)
            {
                balls.get(id).connections.add(connection);
            }
            else
            {
                Ball b = new Ball();
                b.id = id;
                b.connections.add(connection);
                balls.put(b.id,b);
                notVisited.put(b.id, b);
            }
            id++;
        }
        //out.println(balls);
        
        output = "" + findAllGroups();
        
        
        
        //Code here

        out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
}