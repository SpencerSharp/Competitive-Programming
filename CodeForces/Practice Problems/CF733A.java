import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF733A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        
        int max = 0;
        int streak = 1;
        
        for(int i = 0; i < line.length(); i++) //BAAB
        {
            char cur = line.charAt(i);
            if(isVowel(cur))
            {
                max = Math.max(max,streak);
                streak = 1;
            }
            else
            {
                streak++;
            }
        }
        
        max = Math.max(max,streak);
        
        output = ""+max;
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean isVowel(char c)
    {
        char[] vowels = {'A','E','I','O','U','Y'};
        for(char vow : vowels)
            if(vow==c)
                return true;
        return false;
    }
}