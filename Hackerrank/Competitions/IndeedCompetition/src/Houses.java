import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Houses
{
    public static class House
    {
        int num;
        int next;
        
        public House(int n)
        {
            num = n;
        }

        @Override
        public int hashCode()
        {
            int hash = 5;
            hash = 79 * hash + this.num;
            return hash;
        }
        
        public boolean equals(Object o)
        {
            return num == ((House)o).num;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numHouses = Integer.parseInt(f.readLine());
        
        HashMap<Integer,Integer> houses = new HashMap<Integer,Integer>();
        
        StringTokenizer st;
        
        HashSet<Integer> wasEverNext = new HashSet<Integer>();
        HashSet<Integer> wasEverUsed = new HashSet<Integer>();
        
        for(int i = 0; i < numHouses-1; i++)
        {
            st = new StringTokenizer(f.readLine());
            
            int num1 = Integer.parseInt(st.nextToken());
            
            int num2 = Integer.parseInt(st.nextToken());
            
            houses.put(num1, num2);
            
            wasEverNext.add(num2);
            
            wasEverUsed.add(num1);
            wasEverUsed.add(num2);
        
        }
        
        //out.println(wasEverNext);
        
        while(wasEverNext.size() > 0)
        {
            int found = 0;
            for(int n : wasEverNext)
            {
                if(wasEverUsed.contains(n))
                {
                    found = n;
                    break;
                }
            }
            wasEverUsed.remove(found);
            wasEverNext.remove(found);
        }
        
        //out.println(wasEverNext);
        
        int first = 0;
        for(int n : wasEverUsed)
            first = n;
        
        while(houses.containsKey(first))
        {
            writer.println(first);
            first = houses.get(first);
        }
        
        writer.println(first);
        
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}