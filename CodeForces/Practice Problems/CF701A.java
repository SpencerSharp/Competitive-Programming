import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF701A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numCards = Integer.parseInt(f.readLine());
        
        int[][] cards = new int[2][numCards];
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        int max = -1;
        int maxIndex = -1;
        
        int min = 101;
        int minIndex = -1;
        
        for(int i = 0; i < numCards; i++)
        {
            int card = Integer.parseInt(st.nextToken());
            
            if(i==0)
            {
                max = card;
                maxIndex = 0;
                min = card;
                minIndex = 0;
            }
            else
            {
                if(card <= min)
                {
                    min = card;
                    minIndex = i;
                }
                if(card >= max && minIndex != i)
                {
                    max = card;
                    maxIndex = i;
                }
            }
            
            
            cards[0][i] = card;
            //out.println(card);
        }
        //out.println(max);
        
        writer.println((minIndex+1) + " " + (maxIndex+1));
        
        cards[1][minIndex] = 1;
        cards[1][maxIndex] = 1;
        
        int numCardsUsed = 2;
        
        while(numCardsUsed < numCards)
        {
            minIndex = -1;
            maxIndex = -1;
            for(int i = 0; i < numCards; i++)
            {
                if(cards[0][i]==min)
                {
                    if(cards[1][i]==0)
                    {
                        minIndex = i;
                        break;
                    }
                }
            }
            for(int i = 0; i < numCards; i++)
            {
                if(cards[0][i]==max)
                {
                    if(cards[1][i]==0 && i!=minIndex)
                    {
                        maxIndex = i;
                        break;
                    }
                }
            }
            if(minIndex==-1||maxIndex==-1)
            {
                min++;
                max--;
            }
            else
            {
                cards[1][minIndex] = 1;
                cards[1][maxIndex] = 1;
                numCardsUsed += 2;
                writer.println((minIndex+1) + " " + (maxIndex+1));
            }
        }
        
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}