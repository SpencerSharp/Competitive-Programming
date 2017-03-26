import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF58A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String s = f.readLine();
        boolean failed = false;
        if(s.indexOf("h")>=0)
        {
            s = s.substring(s.indexOf("h")+1);
            if(s.indexOf("e")>=0)
            {
                s = s.substring(s.indexOf("e")+1);
                if(s.indexOf("l")>=0)
                {
                    s = s.substring(s.indexOf("l")+1);
                    if(s.indexOf("l")>=0)
                    {
                        s = s.substring(s.indexOf("l")+1);
                        if(s.indexOf("o")>=0)
                        {
                            s = s.substring(s.indexOf("o")+1);
                        }
                        else
                        {
                            failed = true;
                        }
                    }
                    else
                    {
                        failed = true;
                    }
                }
                else
                {
                    failed = true;
                }
            }
            else
            {
                failed = true;
            }
        }
        else
        {
            failed = true;
        }
        output = failed?"NO":"YES";
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
