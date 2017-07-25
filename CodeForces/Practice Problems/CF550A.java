import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF550A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String s = f.readLine();
        
        boolean result = findBothOfThem(s);
        
        output = result?"YES":"NO";
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean findBothOfThem(String s)
    {
        int len = s.length();
        if(s.contains("AB") && s.contains("BA"))
        {
            for(int i = 0; i < len-1; i++)
            {
                String sub = s.substring(i,i+2);
                if(sub.equals("AB"))
                {
                    String checkThis = s.substring(0,i)+"**"+s.substring(i+2);
                    boolean eval = findBA(checkThis);
                    if(eval)
                        return true;
                }
                else if(sub.equals("BA"))
                {
                    String checkThis = s.substring(0,i)+"**"+s.substring(i+2);
                    boolean eval = findAB(checkThis);
                    if(eval)
                        return true;
                }
            }
        }
        return false;
    }
    
    public static boolean findAB(String s)
    {
        int len = s.length();
        for(int i = 0; i < len-1; i++)
        {
            String sub = s.substring(i,i+2);
            if(sub.equals("AB"))
                return true;
        }
        return false;
    }
    
    public static boolean findBA(String s)
    {
        int len = s.length();
        for(int i = 0; i < len-1; i++)
        {
            String sub = s.substring(i,i+2);
            if(sub.equals("BA"))
                return true;
        }
        return false;
    }
}