import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF313A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String number = f.readLine();
        long initVal = Long.parseLong(number);
        long posVal1 = Long.parseLong(number.substring(0,number.length()-1));
        long posVal2 = Long.parseLong(number.substring(0,number.length()-2)+number.substring(number.length()-1));
        //out.println(initVal + " " + posVal1 + " " + posVal2);
        output = ""+Math.max(initVal,Math.max(posVal1, posVal2));
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
