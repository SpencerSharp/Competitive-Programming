import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF490A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numKids = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        HashSet<Integer> ones = new HashSet<Integer>();
        HashSet<Integer> twos = new HashSet<Integer>();
        HashSet<Integer> threes = new HashSet<Integer>();
        int index = 1;
        for(int i = 0; i < numKids; i++)
        {
            int cur = Integer.parseInt(st.nextToken());
            if(cur==1)
                ones.add(index++);
            else if(cur==2)
                twos.add(index++);
            else
                threes.add(index++);
        }
        Iterator it1 = ones.iterator();
        Iterator it2 = twos.iterator();
        Iterator it3 = threes.iterator();
        out.println(Math.min(ones.size(),Math.min(twos.size(),threes.size())));
        while(it1.hasNext() && it2.hasNext() && it3.hasNext())
            out.println(it1.next() + " " + it2.next() + " " + it3.next());
        
        //if(!didLoop)
        //    out.println("0");
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
