/*
ID: spencer16
LANG: JAVA
PROG: dualpal
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class dualpal
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int loops = Integer.parseInt(st.nextToken());
        int minVal = Integer.parseInt(st.nextToken());
        int count = 0;
        int i = 1;
        while(count < loops)
        {
            int num = minVal+i;
            if(isMultiPal(num))
            {
                output += num+"\n";
                count++;
            }
            i++;
        }
        //Code here

        //out.println(output+"\n");
        
        writer.print(output);
        writer.close();
        System.exit(0);
        
    }

    public static boolean isMultiPal(int num)
    {
        int total = 0;
        for(int i = 2; i <= 10; i++)
        {
            String inBase = Integer.toString(num,i);
            if(isPali(inBase))
                total++;
        }
        return total>=2;
    }
    
    public static boolean isPali(String s)
    {
        String forwards = s;
        String backwards = "";
        for(int i = forwards.length()-1; i>=0; i--)
        {
            backwards += forwards.charAt(i);
        }
            //out.println(forwards);
            //out.println(backwards);
        return forwards.equals(backwards);
    }
}
