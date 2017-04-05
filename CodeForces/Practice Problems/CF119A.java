import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF119A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int cur = 0;
        
        boolean simonWins = false;
        boolean antisimonWins = false;
        
        while(a>0 && b > 0)
        {
            //out.println(n);
            if(cur%2==0)
            {
                n-=gcd(a,n);
                if(n<0)
                {
                    antisimonWins = true;
                    break;
                }
            }
            else
            {
                n-=gcd(b,n);
                if(n<0)
                {
                    simonWins = true;
                    break;
                }
            }
            cur++;
            //out.println("rip");
        }
        output = simonWins ? "0":"1";
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }

    public static int gcd(int n1, int n2)
    {
        if(n1==0||n2==0)
        {
            return Math.max(n1,n2);
        }
        for(int i = Math.min(n1,n2); i >= 1; i--)
        {
            if(n1%i==0 && n2%i==0)
            {
                //out.println(n1 + " " + n2 + " " + i);
                return i;
            }
        }
        return -1;
    }
}