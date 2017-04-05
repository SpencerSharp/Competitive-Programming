import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF443A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        line = line.substring(1);
        line = line.substring(0,line.length()-1);
        String[] ray = line.split(", ");
        int[] totals = new int[26];
        for(String s : ray)
        {
            if(s.length()>0)
                totals[s.charAt(0)-'a']++;
            //out.println(s.charAt(0));
        }
        int num = 0;
        for(int i = 0; i < totals.length; i++)
        {
            if(totals[i]!=0)
                num++;
        }
        output = ""+num;

        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
