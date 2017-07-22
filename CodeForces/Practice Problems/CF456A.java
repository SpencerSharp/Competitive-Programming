import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF456A
{
    static class Laptop implements Comparable
    {
        private int cost;
        private int quality;
        
        public Laptop(int c, int q)
        {
            cost = c;
            quality = q;
        }
        
        public int getCost()
        {
            return cost;
        }
        
        public int getQuality()
        {
            return quality;
        }
        
        public int compareTo(Object o)
        {
            int oCost = ((Laptop)o).getCost();
            return cost - oCost;
        }
        
        public String toString()
        {
            return cost + " " + quality;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        ArrayList<Laptop> laptops = new ArrayList<Laptop>();
        
        int numLaptops = Integer.parseInt(f.readLine());
        
        StringTokenizer st;
        
        for(int i = 0; i < numLaptops; i++)
        {
            st = new StringTokenizer(f.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int quality = Integer.parseInt(st.nextToken());
            
            laptops.add(new Laptop(cost,quality));
        }
        
        Collections.sort(laptops);
        
        //out.println(laptops);
        
        int prevQuality = 0;
        
        boolean isAlexRight = false;
        
        for(Laptop l : laptops)
        {
            int curQuality = l.getQuality();
            if(curQuality < prevQuality)
            {
                isAlexRight = true;
            }
            prevQuality = curQuality;
        }
        
        output = isAlexRight?"Happy Alex":"Poor Alex";
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}