import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF734A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        int numGames = Integer.parseInt(line);
        String games = f.readLine();
        int aWins = 0;
        int dWins = 0;
        for(int i = 0; i < numGames; i++)
        {
            if(games.charAt(i)=='A')
                aWins++;
            else
                dWins++;
        }
        output = dWins>aWins?"Danik":aWins>dWins?"Anton":"Friendship";
        
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
