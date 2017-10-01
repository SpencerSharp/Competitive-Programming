import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class C
{
    public static class Contestant implements Comparable<Contestant>
    {
        long s;
        long a;
        long b;
        int uniqueID;
        
        public Contestant(long s1, long a1, long b1, int u)
        {
            s = s1;
            a = a1;
            b = b1;
            uniqueID = u;
        }
        
        public double getHowMuchPrefersPizza1()
        {
            long aH = a * s;
            long bH = b * s;
            
            return ((double)(aH - bH)) / s;
        }
        
        public int compareTo(Contestant o)
        {
            double result = o.getHowMuchPrefersPizza1()-getHowMuchPrefersPizza1();
            if(result > 0)
                return 1;
            else if(result < 0)
                return -1;
            return o.uniqueID-uniqueID;
        }
        
        public String toString()
        {
            return "" + getHowMuchPrefersPizza1();
        }
    }
    
    public static long maxHappinessFromNumPizza1s(TreeSet<Contestant> cs, long numPizza1sSlices, long numPizza2sSlices, long numSlices)
    {
        long h = 0;
        for(Contestant c : cs)
        {
            //Prefers pizza 1
            if(c.getHowMuchPrefersPizza1() >= 0)
            {
                
                if(c.s <= numPizza1sSlices)
                {
                    h += c.s * c.a;
                    numPizza1sSlices -= c.s;
                }
                else
                {
                    h += numPizza1sSlices * c.a;
                    h += (c.s - numPizza1sSlices) * c.b;
                    numPizza2sSlices -= (c.s - numPizza1sSlices);
                    numPizza1sSlices = 0;
                }
            }
            //Prefers pizza 2
            else
            {
                
                //He can take all pizza 2
                if(numPizza2sSlices >= numSlices)
                {
                    numPizza2sSlices -= c.s;
                    h += c.s * c.b;
                }
                //Take numPizza2sSlices - numSlices pizza 2 slices
                else if(numPizza2sSlices > numSlices - c.s)
                {
                    //out.println("YOLO"+c);
                    long num2Take = numPizza2sSlices - (numSlices - c.s);
                    h += num2Take * c.b;
                    h += (c.s - num2Take) * c.a;
                    numPizza1sSlices -= (c.s - num2Take);
                    numPizza2sSlices -= num2Take;
                }
                //Gotta eat pizza 1
                else
                {
                    numPizza1sSlices -= c.s;
                    h += c.s * c.a;
                }
            }
            //out.println(c);
            numSlices -= c.s;
        }
        return h;
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        long numContestants = Long.parseLong(st.nextToken());
        
        long numSlicesPerPizza = Long.parseLong(st.nextToken());
        
        TreeSet<Contestant> cs = new TreeSet<Contestant>();
        
        long numPizza1SlicesPreferred = 0;
        
        long numSlices = 0;
        
        //String line = f.readLine();
            
        for(int i = 0; i < numContestants; i++)
        {
            st = new StringTokenizer(f.readLine());
            long s = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            Contestant c = new Contestant(s, a, b, i);
            
            //out.println(b);
            
            if(c.getHowMuchPrefersPizza1() > 0)
            {
                numPizza1SlicesPreferred += c.s;
            }
            
            numSlices += c.s;
            
            cs.add(c);
            
            //out.println("YOLO " + i + c + " SIZE: " + cs.size());
        }
        
        long numPizza1s = numPizza1SlicesPreferred/numSlicesPerPizza;
        
        long numPizza2s = 0;
        if(numSlices % numSlicesPerPizza == 0)
        {
            numPizza2s = numSlices-numPizza1s*numSlicesPerPizza;
            numPizza2s /= numSlicesPerPizza;
        }
        else
        {
            numPizza2s = numSlices-numPizza1s*numSlicesPerPizza;
            numPizza2s /= numSlicesPerPizza;
            numPizza2s++;
        }
        
        //out.println(numPizza1SlicesPreferred);
        
        long max = maxHappinessFromNumPizza1s(cs, numPizza1s*numSlicesPerPizza, numPizza2s*numSlicesPerPizza, numSlices);
        
        //^out.println(numSlices);
        
        max = Math.max(maxHappinessFromNumPizza1s(cs, numSlicesPerPizza*(numPizza1s+1), numSlicesPerPizza*(numPizza2s-1), numSlices), max);
        
        output = ""+max;
        //Code here
        //100000000
        //100000000
        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}