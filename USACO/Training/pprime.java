/*
ID: spencer16
LANG: JAVA
PROG: pprime
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class pprime
{
    public static PrintWriter writer;
    public static void main(String[] args) throws IOException
    {
        
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        //writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
        writer = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        
        generateAllPossiblePalisOfLengthAndLessThan(1,min,max);

        //out.println(disp);
        //for(int n : disp)
        //    if(isPrime(n))
        //        out.println(n);
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static void generateAllPossiblePalisOfLengthAndLessThan(int n, int min, int max)
    {
        //out.println("YOLO"+n);
        String minString = ""+min;
        String maxString = ""+max;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        String minOfLength = "1";
        for(int i = 1; i < n; i++)
            minOfLength += "0";
        String maxOfLength = "9";
        for(int i = 1; i < n; i++)
            maxOfLength += "9";
        if(max < Integer.parseInt(minOfLength))
        {
            
        }
        else if(min > Integer.parseInt(maxOfLength))
            generateAllPossiblePalisOfLengthAndLessThan(n+1, min, max);
        //out.println(n);
        else
        {
            if(n==1)
            {
                for(int i = Math.max(min,1); i < Math.min(10,max); i++)
                    if(isPrime(i))
                        writer.println(i);
                generateAllPossiblePalisOfLengthAndLessThan(n+1, min, max);
            }
            else if(n==2)
            {
                for(int i = 1; i < 10; i+=2)
                {
                    int num = Integer.parseInt(i+""+i);
                    if(num >= min && num <= max)
                        if(isPrime(num))
                            writer.println(num);
                }
                generateAllPossiblePalisOfLengthAndLessThan(n+1, min, max);
            }
            else if(n==3)
            {
                for(int i = 1; i < 10; i+=2)
                    for(int j = 0; j < 10; j++)
                    {
                        int num = Integer.parseInt(i+""+j+i);
                        if(num >= min && num <= max)
                            if(isPrime(num))
                                writer.println(num);
                    }
                generateAllPossiblePalisOfLengthAndLessThan(n+1, min, max);
            }
            else if(n==4)
            {
                for(int i = 1; i < 10; i+=2)
                    for(int j = 0; j < 10; j++)
                    {
                        int num = Integer.parseInt(i+""+j+j+i);
                        if(num >= min && num <= max)
                            if(isPrime(num))
                                writer.println(num);
                    }
                generateAllPossiblePalisOfLengthAndLessThan(n+1, min, max);
            }
            else if(n==5)
            {
                for(int i = 1; i < 10; i+=2)
                    for(int j = 0; j < 10; j++)
                        for(int a = 0; a < 10; a++)
                        {
                            int num = Integer.parseInt(i+""+j+a+j+i);
                            if(num >= min && num <= max)
                                if(isPrime(num))
                                    writer.println(num);
                        }
                generateAllPossiblePalisOfLengthAndLessThan(n+1, min, max);
            }
            else if(n==6)
            {
                for(int i = 1; i < 10; i+=2)
                    for(int j = 0; j < 10; j++)
                        for(int a = 0; a < 10; a++)
                        {
                            int num = Integer.parseInt(i+""+j+a+a+j+i);
                            if(num >= min && num <= max)
                                if(isPrime(num))
                                    writer.println(num);
                        }
                generateAllPossiblePalisOfLengthAndLessThan(n+1, min, max);
            }
            else if(n==7)
            {
                for(int i = 1; i < 10; i+=2)
                    for(int j = 0; j < 10; j++)
                        for(int a = 0; a < 10; a++)
                            for(int b = 0; b < 10; b++)
                            {
                                int num = Integer.parseInt(i+""+j+a+b+a+j+i);
                                if(num >= min && num <= max)
                                    if(isPrime(num))
                                        writer.println(num);
                            }
                generateAllPossiblePalisOfLengthAndLessThan(n+1, min, max);
            }
            else if(n==8)
            {
                for(int i = 1; i < 10; i+=2)
                    for(int j = 0; j < 10; j++)
                        for(int a = 0; a < 10; a++)
                            for(int b = 0; b < 10; b++)
                            {
                                int num = Integer.parseInt(i+""+j+a+b+b+a+j+i);
                                if(num >= min && num <= max)
                                    if(isPrime(num))
                                        writer.println(num);
                            }
                generateAllPossiblePalisOfLengthAndLessThan(n+1, min, max);
            }
        }
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