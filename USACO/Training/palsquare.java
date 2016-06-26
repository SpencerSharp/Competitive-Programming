/*
ID: spencer16
LANG: JAVA
PROG: palsquare
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class palsquare
{
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
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        int base = Integer.parseInt(f.readLine());
        for(int i = 1; i < 300; i++)
        {
            String n = Integer.toString(i, base);
            int squared = i*i;
            String n2 = Integer.toString(squared,base);
            if(i==26)
            {
                //out.println(n);
                //out.println(n2);
            }
            if(isPali(n2))
            {
                output+=(n.toUpperCase() + " " + n2.toUpperCase())+"\n";
            }
        }
        
        
        
        //Code here

        //out.println(output);
        
        writer.print(output);
        writer.close();
        System.exit(0);
    }
}
