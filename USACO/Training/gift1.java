/*
ID: spencer16
LANG: JAVA
PROG: gift1
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class gift1
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));

        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        
        String output = ""; //Write all output to this string
        
        int numPeople = Integer.parseInt(f.readLine());
        TreeMap<String, Integer> peopleMoney = new TreeMap<String,Integer>();
        ArrayList<String> nameOrder = new ArrayList<String>();
        
        for(int size = 0; size < numPeople; size++)
        {
            String name = f.readLine();
            peopleMoney.put(name,0);
            nameOrder.add(name);
        }

        for(int size = 0; size < numPeople; size++)
        {
            String giverName = f.readLine();
            String numsLine = f.readLine();
            StringTokenizer s = new StringTokenizer(numsLine);
            int money = Integer.parseInt(s.nextToken());
            int numRecs = Integer.parseInt(s.nextToken());
            int totalMoneyGiven = 0;
            for(int i = 0; i < numRecs; i++)
            {
                totalMoneyGiven += money/numRecs;
                String nameRec = f.readLine();
                peopleMoney.put(nameRec,peopleMoney.get(nameRec)+(money/numRecs));
            }
            peopleMoney.put(giverName,peopleMoney.get(giverName)-totalMoneyGiven);
        }
        
        for(int i = 0; i < nameOrder.size(); i++)
        {
            for(Map.Entry<String,Integer> e : peopleMoney.entrySet())
            {
                if(e.getKey().equals(nameOrder.get(i)))
                    output += e.getKey() + " " + e.getValue() + "\n";
            }
        }
        
        //Code here


        //out.println(output);
        
        writer.print(output);
        writer.close();
        System.exit(0);
        
    }
}
