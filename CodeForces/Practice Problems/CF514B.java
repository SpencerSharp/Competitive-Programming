import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF514B
{
    public static class Fraction
    {
        long numerator;
        long denominator;
        
        public Fraction(long n, long d)
        {
            numerator = n;
            denominator = d;
            
            reduce();
        }
        
        private void reduce()
        {
            long gcd = getGCD(numerator, denominator);
            
            if(gcd != 0)
            {
                numerator /= gcd;
                denominator /= gcd;
            }
        }

        private long getGCD(long a, long b)
        {
            //out.println(a + " " + b);
            while(b != 0)
            {
                long temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        @Override
        public int hashCode()
        {
            int hash = 3;
            hash = 53 * hash + (int) (this.numerator ^ (this.numerator >>> 32));
            hash = 53 * hash + (int) (this.denominator ^ (this.denominator >>> 32));
            return hash;
        }
        
        public boolean equals(Object o)
        {
            if(o instanceof Fraction)
            {
                Fraction frac = (Fraction) o;
                
                if(denominator == 0)
                {
                    if(frac.denominator == 0)
                    {
                        return true;
                    }
                    return false;
                }
                
                if(numerator == 0)
                {
                    if(frac.numerator == 0)
                    {
                        return true;
                    }
                    return false;
                }
                
                if(numerator == frac.numerator)
                {
                    if(frac.denominator == denominator)
                    {
                        return true;
                    }
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
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        int numEnemies = Integer.parseInt(st.nextToken());
        long gunX = Long.parseLong(st.nextToken());
        long gunY = Long.parseLong(st.nextToken());
        
        HashSet<Fraction> slopes = new HashSet<Fraction>();
        
        for(int i = 0; i < numEnemies; i++)
        {
            st = new StringTokenizer(f.readLine());
            
            long cX = Long.parseLong(st.nextToken());
            long cY = Long.parseLong(st.nextToken());
            
            long numer = gunX - cX;
            long denom = gunY - cY;
            
            Fraction frac = new Fraction(numer, denom);
            
            slopes.add(frac);
        }
        output = "" + slopes.size();
        
        //Code here

        //out.println(output);
        //Different code
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}