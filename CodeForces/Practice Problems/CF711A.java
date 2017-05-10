import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF711A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numRows = Integer.parseInt(f.readLine());
        String result = "";
        boolean foundSeats = false;
        for(int i = 0; i < numRows; i++)
        {
            String line = f.readLine();
            if(!foundSeats)
            {
                if(line.substring(0,2).equals("OO"))
                {
                    result += "++" + line.substring(2);
                    foundSeats = true;
                }
                else if(line.substring(3).equals("OO"))
                {
                    result += line.substring(0,3) + "++";
                    foundSeats = true;
                }
                else
                    result += line;
                result += "\n";
            }
            else
                result += line + "\n";
        }
        if(foundSeats)
        {
            output = "YES\n" + result.substring(0,result.length()-1);
        }
        else
            output = "NO";
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
