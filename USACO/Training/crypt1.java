/*
ID: spencer16
LANG: JAVA
PROG: crypt1
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class crypt1
{
    public static ArrayList<Integer> genPrimes()
    {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i = 1111; i <= 9999; i++)
        {
            boolean isPrime = true;
            for(int d = 2; d <= i/2+1;d++)
            {
                if(i%d==0)
                {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                ret.add(i);
        }
        return ret;
    }
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        //ArrayList<Integer> primeLib = genPrimes(); //All primes >= 1111 <=9999
        int numDigs = Integer.parseInt(f.readLine());
        ArrayList<Integer> digs = new ArrayList<Integer>();
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for(int i = 0; i < numDigs; i++)
        {
            digs.add(Integer.parseInt(st.nextToken()));
        }
        int s = digs.size();
        int total = 0;
        for(int a = 0; a < s; a++)
        {
            for(int b = 0; b < s; b++)
            {
                for(int c = 0; c < s; c++)
                {
                    for(int d = 0; d < s; d++)
                    {
                        for(int e = 0; e < s; e++)
                        {
                            int n1 = digs.get(a);
                            int n2 = digs.get(b);
                            int n3 = digs.get(c);
                            int n4 = digs.get(d);
                            int n5 = digs.get(e);
                            
                            int partProd1 = getPartProd1(Integer.parseInt(""+n1+n2+n3),Integer.parseInt(""+n4+n5));
                            //if(n1==2&&n2==2&&n3==2&&n4==2&&n5==2)
                                //out.println(partProd1);
                            if(fits(partProd1,digs,3))
                            {
                                //out.println(partProd1);
                                int partProd2 = getPartProd2(Integer.parseInt(""+n1+n2+n3),Integer.parseInt(""+n4+n5));
                                if(fits(partProd2,digs,3))
                                {
                                    
                                    int finalProd = Integer.parseInt(""+n1+n2+n3) * Integer.parseInt(""+n4+n5);
                                    //if(finalProd==4884){out.println(isPrime(finalProd,primeLib));}
                                    if(fits(finalProd,digs,4)) //&& isPrime(finalProd,primeLib))
                                    {
                                        //out.println(finalProd);
                                        total++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        
        //Code here
        output += total;
        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int getPartProd1(int three, int two)
    {
        //out.println(two);
        int multiply1 = Integer.parseInt(""+(two+"").charAt(1));
        int ret = multiply1*three;
        return ret;
    }
    
    public static int getPartProd2(int three, int two)
    {
        int multiply1 = Integer.parseInt(""+(two+"").charAt(0));
        int ret = multiply1*three;
        return ret;
    }
    
    public static boolean fits(int num, ArrayList<Integer> digs, int len)
    {
        String s = ""+num;
        if(s.length()!=len)
            return false;
        for(int i = 0; i < s.length(); i++)
        {
            boolean weGood = false;
            int dig = Integer.parseInt(""+s.charAt(i));
            for(int n = 0; n < digs.size(); n++)
            {
                if(digs.get(n)==dig)
                {
                    weGood = true;
                    break;
                }
            }
            if(!weGood)
                return false;
        }
        return true;
    }
    
    public static boolean isPrime(int num, ArrayList<Integer> primeLib)
    {
        if(num%2==0||num%3==0||num%5==0||num%7==0||num%11==0)
            return false;
        for(int n : primeLib)
            if(num==n)
                return true;
        return false;
    }
}
