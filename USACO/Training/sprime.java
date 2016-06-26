/*
ID: spencer16
LANG: JAVA
PROG: sprime
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class sprime
{
    
    public static void main(String[] args) throws IOException
    {
        /*
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        */
        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        int size = Integer.parseInt(f.readLine());
        int[] ray = {2,3,5,7};
        for(int n : ray)
        {
            if(size>1)
            {
                for(int a = 1; a < 10; a+=2)
                {
                    int n1 = Integer.parseInt(""+n+a);
                    if(isPrime(n1))
                    {
                        if(size > 2)
                        {
                            for(int b = 1; b < 10; b+=2)
                            {
                                int n2 = Integer.parseInt(""+n1+b);
                                if(isPrime(n2))
                                {
                                    if(size > 3)
                                    {
                                        for(int c = 1; c < 10; c+=2)
                                        {
                                            int n3 = Integer.parseInt(""+n2+c);
                                            if(isPrime(n3))
                                            {
                                                if(size > 4)
                                                {
                                                    for(int d = 1; d < 10; d+=2)
                                                    {
                                                        int n4 = Integer.parseInt(""+n3+d);
                                                        if(isPrime(n4))
                                                        {
                                                            if(size > 5)
                                                            {
                                                                for(int e = 1; e < 10; e+=2)
                                                                {
                                                                    int n5 = Integer.parseInt(""+n4+e);
                                                                    if(isPrime(n5))
                                                                    {
                                                                        if(size > 6)
                                                                        {
                                                                            for(int g = 1; g < 10; g+=2)
                                                                            {
                                                                                int n6 = Integer.parseInt(""+n5+g);
                                                                                if(isPrime(n6))
                                                                                {
                                                                                    if(size > 7)
                                                                                    {
                                                                                        for(int h = 1; h < 10; h+=2)
                                                                                        {
                                                                                            int n7 = Integer.parseInt(""+n6+h);
                                                                                            if(isPrime(n7))
                                                                                                writer.println(n7);
                                                                                        }
                                                                                    }
                                                                                    else
                                                                                        writer.println(n6);
                                                                                }
                                                                            }
                                                                        }
                                                                        else
                                                                            writer.println(n5);
                                                                    }
                                                                }
                                                            }
                                                            else
                                                                writer.println(n4);
                                                        }
                                                    }
                                                }
                                                else
                                                    writer.println(n3);
                                            }
                                        }
                                    }
                                    else
                                        writer.println(n2);
                                }
                            }
                        }
                        else
                            writer.println(n1);
                    }
                }
            }
            else
                writer.println(n);
        }
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean isPrime(int num)
    {
        if(num%2==0||num%3==0)
            return false;
        else
        {
            for(int i = 5; i*i <= num;i+=2)
                if(num%i==0)
                    return false;
        }
        return true;
    }
}
