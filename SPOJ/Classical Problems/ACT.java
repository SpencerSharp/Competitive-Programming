import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class ACT
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int size = Integer.parseInt(f.readLine());
        
        for(int i = 0; i < size; i++)
        {
            String line = f.readLine();
            writer.println(line.charAt(line.length()-1));
        }
        
        //Code here

        //out.println(output);
        /*
        writer.println(output);*/
        writer.close();
        System.exit(0);
    }
    
    /*
        
    public static int playerWhoWonSets(int[] numSets)
    {
        int numEqualZero = 0;
        int numEqualTwo = 0;
        for(int i = 0; i < numSets.length; i++)
        {
            if(numSets[i]==3)
                return i;
            else if(numSets[i]==0)
                numEqualZero++;
            else if(numSets[i]==2)
                numEqualTwo++;
        }
        if(numEqualTwo==1 && numEqualTwo+numEqualZero==numSets.length)
        {
            for(int i = 0; i < numSets.length; i++)
            {
                if(numSets[i]==2)
                    return i;
            }
        }
        return -1;
    }
    
    public static int playerWhoWonGames(int[] numGames)
    {
        boolean atLeastSix = false;
        for(int i = 0; i < numGames.length; i++)
        {
            if(numGames[i]>=6)
                atLeastSix = true;
        }
        if(!atLeastSix)
            return -1;
        int max = 0;
        int indexOfMax = 0;
        for(int i = 0; i < numGames.length; i++)
        {
            if(numGames[i]>max)
            {
                max = numGames[i];
                indexOfMax=i;
            }
        }
        int secondMax = 0;
        for(int i = 0; i < numGames.length; i++)
        {
            if(i!=indexOfMax&&numGames[i]>secondMax)
            {
                secondMax = numGames[i];
            }
        }
        if(max-secondMax>=2)
            return indexOfMax;
        else
            return -1;
    }
    
    public static int playerWhoWonPoints(int[] numPoints, int indexOfWinner)
    {
        
    }*/
}
