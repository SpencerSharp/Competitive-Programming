import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        
        int numCars = Integer.parseInt(f.readLine());
        while(numCars!=0)
        {
            ArrayList<Integer> q1 = new ArrayList<Integer>();
            Stack<Integer> sideStreet = new Stack<Integer>();
            ArrayList<Integer> endQ = new ArrayList<Integer>();

            StringTokenizer st = new StringTokenizer(f.readLine());
            while(st.hasMoreTokens())
            {
                q1.add(Integer.parseInt(st.nextToken()));
            }
            boolean didWork = true;
            int nextNum = 1;
            while(nextNum < numCars+1)
            {
                //out.println(q1);
                if(q1.size() > 0 && getFirst(q1)==nextNum)
                    endQ.add(popFirst(q1));
                else if(sideStreet.size() > 0 && getFirst(sideStreet)==nextNum)
                    endQ.add(popFirst(sideStreet));
                else if(q1.size() > 0)
                {
                    sideStreet.add(popFirst(q1));
                    nextNum--;
                }
                else
                {
                    didWork = false;
                    break;
                }
                nextNum++;
            }
            String output;
            if(didWork)
                output = "yes";
            else
                output = "no";
            //Code here

            //out.println(output);

            writer.println(output);
            numCars = Integer.parseInt(f.readLine());
        }
        
        writer.close();
        System.exit(0);
        
    }
    
    public static int popFirst(List n)
    {
        if(n instanceof ArrayList)
            return (int)n.remove(0);
        else
            return (int)((Stack)n).pop();
    }
    
    public static int getFirst(List n)
    {
        if(n instanceof ArrayList)
            return (int)n.get(0);
        else
            return (int)((Stack)n).peek();
    }
}