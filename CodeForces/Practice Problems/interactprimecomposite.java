import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class interactprimecomposite
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int[] factors = genPrimesGreaterThan50();
        for(int n : factors)
            out.println(n);
        ArrayList<Integer> elimNumbers = new ArrayList<Integer>();
        int count = 0;
        int numYes = 0;
        boolean broken = false;
        for(int i = 0; i < factors.length; i++)
        {
            int guess = factors[i];
            out.println(guess);
            out.flush();
            count++;
            try{
            Thread.sleep(10);
            }
            catch(Exception e){}
            String read = f.readLine();
            if(read.equals("yes"))
            {
                out.println("prime");
                out.flush();
                broken = true;
                break;
            }
            else
            {
                elimNumbers.add(guess);
            }
            count++;
        }
        while(count < 20 && !broken)
        {
            int guess = 0;
            out.println(guess);
            out.flush();
            count++;
            try{
            Thread.sleep(10);
            }
            catch(Exception e){}
            String read = f.readLine();
        }
        
        
        
        
        
        //Code here

        //out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
    
    public static boolean isPrime(int n)
    {
        for(int i = 2; i < (n/2)+1; i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
    public static int[] genPrimesGreaterThan50()
    {
        int count = 0;
        int[] ray = new int[10];
        for(int i = 50; i < 100; i++)
        {
            if(isPrime(i))
            {
                if(count<25)
                {
                    ray[count] = i;
                    count++;
                }
            }
        }
        return ray;
    }
}
