import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF703A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int mishka = 0;
        int chris = 0;
        
        int numGames = Integer.parseInt(f.readLine());
        String line;
        StringTokenizer st;
        for(int i = 0; i < numGames; i++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            int mNum = Integer.parseInt(st.nextToken());
            int cNum = Integer.parseInt(st.nextToken());
            if(mNum > cNum)
                mishka++;
            else if(cNum > mNum)
                chris++;
        }
        
        if(mishka > chris)
            output = "Mishka";
        else if(chris > mishka)
            output = "Chris";
        else
            output = "Friendship is magic!^^";
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
