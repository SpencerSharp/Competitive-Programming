import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF742A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        long input = Long.parseLong(f.readLine());
        
        /*
        for(int i = 0; i < 20; i++)
        {
            BigInteger theBase = new BigInteger("1378");
            String s = ""+theBase.pow(i);
            //out.println(s);
            out.println(i + " " + s.substring(s.length()-1));
        }
        */
        
        if(input == 0)
        {
            output = "1";
        }
        else if(input%4==1)
        {
            output = "8";
        }
        else if(input%4==2)
        {
            output = "4";
        }
        else if(input%4==3)
        {
            output = "2";
        }
        else if(input%4==0)
        {
            output = "6";
        }
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}