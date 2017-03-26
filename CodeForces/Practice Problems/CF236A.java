import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF236A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int[] ray = new int[26];
        String s = f.readLine();
        for(int i = 0; i < s.length(); i++)
        {
            ray[(int)(s.charAt(i)-'a')]++;
        }
        int dis = 0;
        for(int i = 0; i < ray.length; i++)
            if(ray[i]!=0)
                dis++;
        output = dis%2==0?"CHAT WITH HER!":"IGNORE HIM!";
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
