/*
ID: spencer16
LANG: JAVA
PROG: frac1
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class frac1
{
    public static class Fraction implements Comparable
    {
        public int numerator;
        public int denominator;
        public double val;
        
        public Fraction(int n, int d)
        {
            int gcf = gcf(n,d);
            numerator = n / gcf;
            denominator = d / gcf;
            val = (double) numerator / (double) denominator;
        }
        
        public static int gcf(int n, int d)
        {
            for(int i = n/2 + 1; i >= 1; i--)
            {
                if(n%i==0 && d%i==0)
                    return i;
            }
            return -1;
        }
        
        public int compareTo(Object f)
        {
            return (int)((val - ((Fraction)f).val)*100000);
        }
        
        public String toString()
        {
            return numerator + "/" + denominator;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        ArrayList<Fraction> fractions = new ArrayList<Fraction>();
        int num = Integer.parseInt(f.readLine());
        for(int d = 1; d <= num; d++)
        {
            for(int n = 0; n <= d; n++)
            {
                Fraction frac = new Fraction(n,d);
                if(!containsVal(fractions,frac))
                    fractions.add(frac);
            }
        }
        Collections.sort(fractions);
        for(Fraction frac : fractions)
            writer.println(frac);
        
        //Code here

        //out.println(output);
        /*
        writer.println(output);*/
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean containsVal(ArrayList<Fraction> fractions, Fraction frac)
    {
        for(Fraction f : fractions)
            if(f.compareTo(frac)==0)
                return true;
        return false;
    }
}