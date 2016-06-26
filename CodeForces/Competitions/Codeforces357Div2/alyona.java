import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class alyona
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
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        
        long min = Math.min(n,m);
        long max = Math.max(n,m);
        
        n = min;
        m = max;

        long count = 0;
        //How many numbers end in 0 for n
        long num0EndsN = n/10;
        long num0EndsM = m/10;
        
        //How many numbers in 1 for both
        long num1EndsN = (n+9)/10;
        long num1EndsM = (m+9)/10;
        
        //How many numbers in 1 for both
        long num2EndsN = (n+8)/10;
        long num2EndsM = (m+8)/10;
        
        //How many numbers in 1 for both
        long num3EndsN = (n+7)/10;
        long num3EndsM = (m+7)/10;
        
        //How many numbers in 1 for both
        long num4EndsN = (n+6)/10;
        long num4EndsM = (m+6)/10;
        
        //How many numbers in 1 for both
        long num5EndsN = (n+5)/10;
        long num5EndsM = (m+5)/10;
        
        //How many numbers in 1 for both
        long num6EndsN = (n+4)/10;
        long num6EndsM = (m+4)/10;
        
        //How many numbers in 1 for both
        long num7EndsN = (n+3)/10;
        long num7EndsM = (m+3)/10;
        
        //How many numbers in 1 for both
        long num8EndsN = (n+2)/10;
        long num8EndsM = (m+2)/10;
        
        //How many numbers end in 9 for both
        long num9EndsN = (n+1)/10;
        long num9EndsM = (m+1)/10;
        
        
        count += (num0EndsN*num0EndsM) + (num0EndsN*num5EndsM);
        
        count += (num1EndsN*num4EndsM) + (num1EndsN*num9EndsM);
        
        count += (num2EndsN*num3EndsM) + (num2EndsN*num8EndsM);
        
        count += (num3EndsN*num2EndsM) + (num3EndsN*num7EndsM);
        
        count += (num4EndsN*num1EndsM) + (num4EndsN*num6EndsM);
        
        count += (num5EndsN*num0EndsM) + (num5EndsN*num5EndsM);
        
        count += (num6EndsN*num4EndsM) + (num6EndsN*num9EndsM);
        
        count += (num7EndsN*num3EndsM) + (num7EndsN*num8EndsM);
        
        count += (num8EndsN*num2EndsM) + (num8EndsN*num7EndsM);
        
        count += (num9EndsN*num1EndsM) + (num9EndsN*num6EndsM);
        
        output += count;
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
