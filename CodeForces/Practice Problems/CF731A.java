import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF731A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        
        long total = 0;
        
        char cur = 'a';
        
        for(int i = 0; i < line.length(); i++)
        {
            char next = line.charAt(i);
            total += getDistToLetter(cur,next);
            cur = next;
            //out.println(total);
        }
        
        output = ""+total;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int getDistToLetter(char start, char end)
    {
        int pos1 = 0;
        char temp = start;
        while(temp!=end)
        {
            temp++;
            if(temp=='z'+1)
            {
                temp = 'a';
            }
            pos1++;
        }
        int pos2 = 0;
        temp = start;
        while(temp!=end)
        {
            temp--;
            if(temp=='a'-1)
            {
                temp = 'z';
            }
            pos2++;
        }
        return Math.min(pos1,pos2);
    }
}