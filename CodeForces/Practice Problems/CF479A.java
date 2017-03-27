import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF479A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int num1 = Integer.parseInt(f.readLine());
        int num2 = Integer.parseInt(f.readLine());
        int num3 = Integer.parseInt(f.readLine());
        
        int pos1 = num1*num2*num3;
        int pos2 = (num1+num2)*num3;
        int pos3 = num1*(num2+num3);
        int pos4 = num1*num2+num3;
        int pos5 = num1+num2*num3;
        int pos6 = num1+num2+num3;
        int max = pos1;
        if(pos2>max)
            max = pos2;
        if(pos3>max)
            max = pos3;
        if(pos4 > max)
            max = pos4;
        if(pos5 > max)
            max = pos5;
        if(pos6 > max)
            max = pos6;
        output = ""+max;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}