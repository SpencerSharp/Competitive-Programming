import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF514A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String input = f.readLine();
        String result = "";
        
        for(int i = 0; i < input.length(); i++)
        {
            if(i==0&&input.charAt(i)=='9')
                result += ""+9;
            else if(input.charAt(i)>='5')
            {
                int n = '9'-input.charAt(i);
                result += ""+n;
            }
            else
            {
                result += input.charAt(i);
            }
        }
        
        if(result.equals("0"))
            result = "9";
        
        output = ""+result;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}