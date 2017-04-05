import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF59A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String word = f.readLine();
        int countLower = 0;
        for(int i = 0; i < word.length(); i++)
            if(word.charAt(i)>='a')
                countLower++;
        int countUpper = word.length()-countLower;
        if(countLower >= countUpper)
            output = word.toLowerCase();
        else
            output = word.toUpperCase();
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
