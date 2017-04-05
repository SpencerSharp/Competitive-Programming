import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF510A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(i%2==0)
                    output += "#";
                else
                {
                    if((i+1)%4==0)
                    {
                        if(j==0)
                            output += "#";
                        else
                            output += ".";
                    }
                    else
                    {
                        if(j==m-1)
                            output += "#";
                        else
                            output += ".";
                    }
                }
            }
            output += "\n";
        }
        output = output.substring(0,output.length()-1);
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}