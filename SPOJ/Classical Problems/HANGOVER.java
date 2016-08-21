import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class HANGOVER
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        while(!line.equals("0.00"))
        {
            out.println(getNumCardsForLength(0,Double.parseDouble(line)) + " card(s)");
            line = f.readLine();
        }
        
        
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int getNumCardsForLength(int cardsUsed, double len)
    {
        //out.println(len);
        len -= (1/((double)(cardsUsed+2)));
        //out.println(len);
        if(len<=0)
            return cardsUsed+1;
        else
            return getNumCardsForLength(cardsUsed+1,len);
    }
}
