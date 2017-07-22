import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF519B
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numInitBugs = Integer.parseInt(f.readLine());
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        HashMap<String,Integer> bugs = new HashMap<String,Integer>();
        HashMap<String,Integer> bugs2 = new HashMap<String,Integer>();
        for(int i = 0; i < numInitBugs; i++)
        {
            String bugName = st.nextToken();
            if(bugs.get(bugName)==null)
            {
                bugs.put(bugName,0);
            }
            else
            {
                bugs.put(bugName, bugs.get(bugName)+1);
            }
        }
        //out.println(bugs);
        line = f.readLine();
        st = new StringTokenizer(line);
        for(int i = 1; i < numInitBugs; i++)
        {
            String bug = st.nextToken();
            if(bugs2.get(bug)==null)
            {
                bugs2.put(bug,0);
            }
            else
            {
                bugs2.put(bug, bugs2.get(bug)+1);
            }
            if(bugs.get(bug)>0)
            {
                bugs.put(bug, bugs.get(bug)-1);
            }
            else
                bugs.remove(bug);
        }
        Iterator it = bugs.entrySet().iterator();
        while(it.hasNext())
        {
            out.println(((Map.Entry)it.next()).getKey());
        }
        //out.println(bugs2);
        line = f.readLine();
        st = new StringTokenizer(line);
        for(int i = 2; i < numInitBugs; i++)
        {
            String bug = st.nextToken();
            if(bugs2.get(bug)>0)
            {
                bugs2.put(bug, bugs2.get(bug)-1);
            }
            else
                bugs2.remove(bug);
        }
        //out.println(bugs2);
        it = bugs2.entrySet().iterator();
        while(it.hasNext())
        {
            output = ""+((Map.Entry)it.next()).getKey();
        }
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
