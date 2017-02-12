import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class Cards {
    public static void main(String[] args) throws IOException {
        String fileName = "cards.dat";
        Scanner sc = new Scanner(new File(fileName));
        int numLoops = sc.nextInt();
        for (int i = 0; i < numLoops; i++) {
            int numCards = sc.nextInt();
            int target = sc.nextInt();
            char[] alexHand = new char[numCards];
            for(int j = 0; j < numCards; j++)
                alexHand[j] = sc.next().charAt(0);
            char[] benHand = new char[numCards];
            for(int j = 0; j < numCards; j++)
                benHand[j] = sc.next().charAt(0);
            Arrays.sort(alexHand);
            Arrays.sort(benHand);
            out.println(alexHand);
            int numCardsToUseAlex = tryWithAce11(alexHand,target);
            int otherNumAlex = tryWithAce1(alexHand,target);
            int alexNum = Math.min(numCardsToUseAlex,otherNumAlex);
            out.println(alexNum);
            int numCardsToUseBen = tryWithAce11(benHand,target);
            int otherNumBen = tryWithAce1(benHand,target);
            int benNum = Math.min(numCardsToUseBen,otherNumBen);
            out.println(benNum);
            if(alexNum < benNum)
                out.println("Alex Wins!");
            else if(benNum < alexNum)
                out.println("Ben Wins!");
            else
                out.println("Tie Game!");
        }
    }
    
    public static int tryWithAce1(char[] vals, int target)
    {
        int total = 0;
        int index = vals.length-1;
        int max = index;
        int numCards = 0;
        while(total!=target&&index>-1)
        {
            total += getValueOf(vals[index],false);
            index--;
            numCards++;
            if(total > target)
            {
                if(index==-1)
                {
                    total = 0;
                    numCards = 0;
                    index = max;
                    max--;
                }
                else
                {
                    numCards--;
                    total -= getValueOf(vals[index+1],false);
                }
            }
        }
        return numCards;
    }
    
    public static int tryWithAce11(char[] vals, int target)
    {
        int total = 0;
        int index = vals.length-1;
        int max = index;
        int numCards = 0;
        while(total!=target&&index>-1)
        {
            total += getValueOf(vals[index],true);
            index--;
            numCards++;
            //out.println(total + " " + numCards);
            if(total > target)
            {
                if(index==-1)
                {
                    total = 0;
                    numCards = 0;
                    index = max;
                    max--;
                }
                else
                {
                    numCards--;
                    total -= getValueOf(vals[index+1],true);
                }
            }
        }
        out.println(total + " " + numCards);
        if(total!=target)
            return Integer.MAX_VALUE;
        return numCards;
    }
    
    public static int getValueOf(char c, boolean aceIs11)
    {
        switch(c)
        {
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            case 'T': return 10;
            case 'J': return 10;
            case 'Q': return 10;
            case 'K': return 10;
            case 'A': if(aceIs11) return 11; else return 1;
        }
        return -1;
    }
    
}
