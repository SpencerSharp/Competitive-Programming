import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class E
{
    static HashMap<State,Long> totalProfits;
    static long[] prices;
    
    static class State
    {
        long numOwned = 0;
        long money = 0;
        long index = 0;
        
        public State(long n, long m, long i)
        {
            numOwned = n;
            money = m;
            index = i;
        }
        
        public String toString()
        {
            return ""+index;
        }
        
        public boolean equals(Object o)
        {
            State other = (State) o;
            if(numOwned == other.numOwned)
            {
                if(money == other.money)
                {
                    if(index == other.index)
                    {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        /*
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        */
        String output = ""; //Write all output to this string

        //Code here
        totalProfits = new HashMap<State,Long>();
        
        int numDays = Integer.parseInt(f.readLine());
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        prices = new long[numDays];
        
        for(int i = 0; i < numDays; i++)
        {
            prices[i] = Long.parseLong(st.nextToken());
        }
        
        State start = new State(0,0,0);
        
        output = "" + getMaxMoneyFromState(start);
        //Code here

        out.println(output);
        /*s
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
    
    public static long getMaxMoneyFromState(State s)
    {
        if(totalProfits.containsKey(s))
        {
            out.println("FOUND");
            return totalProfits.get(s);
        }
        if(s.index == prices.length)
        {
            totalProfits.put(s, s.money);
            return s.money;
        }
        State buy = new State(s.numOwned+1, s.money - prices[(int)s.index], s.index+1);
        State sell = new State(s.numOwned-1, s.money + prices[(int)s.index], s.index+1);
        State nothing = new State(s.numOwned, s.money, s.index+1);
        
        long max = 0;
        if(prices.length-s.index >= s.numOwned)
            max = getMaxMoneyFromState(buy);
        if(s.numOwned > 0)
            max = Math.max(getMaxMoneyFromState(sell),max);
        max = Math.max(getMaxMoneyFromState(nothing),max);
        
        totalProfits.put(s,max);
        
        return max;
    }
}