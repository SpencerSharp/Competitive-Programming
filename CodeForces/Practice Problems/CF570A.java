import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF570A
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
        
        int numCandidates = Integer.parseInt(st.nextToken());
        int numCities = Integer.parseInt(st.nextToken());
        
        long[][] candidates = new long[numCities][numCandidates];
        int[] cityWins = new int[numCandidates];
        
        for(int r = 0; r < numCities; r++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            for(int c = 0; c < numCandidates; c++)
            {
                candidates[r][c] = Long.parseLong(st.nextToken());
            }
        }
        
        for(int r = 0; r < numCities; r++)
        {
            long max = -1l;
            int winnerIndex = -1;
            for(int c = 0; c < numCandidates; c++)
            {
                long votes = candidates[r][c];
                if(votes>max)
                {
                    winnerIndex = c;
                    max = votes;
                }
            }
            cityWins[winnerIndex]++;
        }
        
        int maxCityWins = -1;
        int winnerIndex = -1;
        for(int i = 0; i < numCandidates; i++)
        {
            if(cityWins[i] > maxCityWins)
            {
                maxCityWins = cityWins[i];
                winnerIndex = i;
            }
        }
        
        output = ""+(winnerIndex+1);
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}