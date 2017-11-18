import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class C
{
    public static class Item implements Comparable<Item>
    {
        long cost;
        
        public Item(long c)
        {
            cost = c;
        }
        
        @Override
        public boolean equals(Object o)
        {
            return false;
        }
        
        public int compareTo(Item o)
        {
            if(cost < o.cost)
            {
                return -1;
            }
            return 1;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        HashSet<String> liked = new HashSet<String>();
        
        int numLikedWords = Integer.parseInt(f.readLine());
        
        for(int i = 0; i < numLikedWords; i++)
        {
            liked.add(f.readLine());
        }
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        long items = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        TreeSet<Item> likedItems = new TreeSet<Item>();
        
        for(long i = 0; i < items; i++)
        {
            st = new StringTokenizer(f.readLine());
            
            String current = "";
            while(st.hasMoreTokens())
            {
                current = st.nextToken();
            }
            
            long price = Long.parseLong(f.readLine());
            
            if(liked.contains(current))
                likedItems.add(new Item(price));
        }
        
        double totalSpent = 0.0;
        long numBought = 0;
        
        for(Item i : likedItems)
        {
            //out.println(i.cost);
            if(totalSpent + i.cost > b)
                break;
            numBought++;
            totalSpent += i.cost;
            //b -= i.cost;
        }
        output = ""+numBought;
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}