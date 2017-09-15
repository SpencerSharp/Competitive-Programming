import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

//Link to problem statement: 

//public class Solution
public class Rangers
{
    static long numRangers;
    static boolean doneWithCode;
    
    public static class Gear implements Comparable
    {
        String name;
        long neededPer;
        long stock;
        long price;
        long enoughForXRangers;
        
        long numAdded;
        
        public Gear()
        {
            
        }
        
        public Gear(String s, long np, long st, long p)
        {
            name = s;
            neededPer = np;
            stock = st;
            price = p;
            
            enoughForXRangers = stock/neededPer;
        }
        
        public long addEnoughForXRangers(long param)
        {
            stock += param * neededPer;
            numAdded += param * neededPer;
            
            update();
            
            return param * (neededPer-stock%neededPer) * price;
        }
        
        public long getCostToAdd(long param)
        {
            return param * (neededPer-stock%neededPer) * price;
        }
        
        public long costPerRanger()
        {
            return neededPer * price;
        }
        
        public boolean hasEnough()
        {
            return stock/neededPer >= numRangers;
        }
        
        public void update()
        {
            enoughForXRangers = stock/neededPer;
        }
        
        public int compareTo(Object o)
        {
            Gear g = (Gear) o;
            
            //out.println("CALLED");
            
            if(!doneWithCode)
            {
                if(enoughForXRangers != g.enoughForXRangers)
                    return (int)(this.enoughForXRangers - g.enoughForXRangers);
                else
                {
                    return (int)(costPerRanger()-g.costPerRanger());
                }
            }
            return name.compareTo(g.name);
        }
        
        public String toString()
        {
            return name + " " + numAdded;
        }
    }

    public static void main(String[] args) throws IOException
    {
        /*
        //Use open comment before this line
        int numFiles = 16;
        for(int curFileIndex = 0; curFileIndex < numFiles; curFileIndex++)
        {
            String inputOutputNumber = ""+curFileIndex;
            if(inputOutputNumber.length()==1)
                inputOutputNumber = "0" + inputOutputNumber;
            long startTime = System.nanoTime();
            String fileName = formatTitle("Rangers") + "-testcases";
            String pathToHackerrankTestingFolder = "/Users/spencersharp/Desktop/HackerrankTesting/";
            BufferedReader f = new BufferedReader(new FileReader(pathToHackerrankTestingFolder + fileName + "/input/input"+inputOutputNumber+".txt"));
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pathToHackerrankTestingFolder + fileName + "/testOutput/testOutput"+inputOutputNumber+".txt")));
            //Comment the end comment after this line
            */
            
            BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
            
            String output = ""; //Write all output to this string

            //Code here
            StringTokenizer st = new StringTokenizer(f.readLine());
        
            long numRangers = Long.parseLong(st.nextToken());
            long numGear = Long.parseLong(st.nextToken());
            long budget = Long.parseLong(st.nextToken());

            TreeSet<Gear> gears = new TreeSet<Gear>();

            long minForRanger = Long.MAX_VALUE;

            for(long g = 0; g < numGear; g++)
            {
                st = new StringTokenizer(f.readLine());

                String name = st.nextToken();
                long requiredPer = Long.parseLong(st.nextToken());
                long curStock = Long.parseLong(st.nextToken());
                long pricePer = Long.parseLong(st.nextToken());

                minForRanger = Math.min(curStock/requiredPer,minForRanger);

                gears.add(new Gear(name,requiredPer,curStock,pricePer));
            }

            while(minForRanger != numRangers && budget > 0)
            {
                //out.println(budget);
                //out.println(gears);
                Gear g = gears.pollFirst();
                Gear g2 = gears.first();

                long toBuy = g2.enoughForXRangers - g.enoughForXRangers;

                //out.println(toBuy);

                long price = 0;

                if(toBuy == 0)
                {
                    gears.add(g);
                    for(Gear c : gears)
                    {
                        price += c.getCostToAdd(1);
                    }
                    if(price > budget)
                    {
                        budget = 0;
                    }
                    else
                    {
                        budget -= price;
                        for(Gear c : gears)
                            c.addEnoughForXRangers(1);
                    }
                }
                else
                {
                    //out.println("BAD");
                    price = g.getCostToAdd(toBuy);
                    if(price > budget)
                    {
                        //out.println("IF");
                        price = budget / g.costPerRanger();
                        g.addEnoughForXRangers((price/g.price)/g.neededPer);
                        budget = 0;
                    }
                    else
                    {
                        //out.println("ELSE");
                        budget -= price;
                        g.addEnoughForXRangers((price/g.price)/g.neededPer);
                    }
                    gears.add(g);
                }

                //out.println(price);
                minForRanger = g.enoughForXRangers;

                //TreeSet<Gear> result = new TreeSet<Gear>();

                //while(gears.size() > 0)
                //    result.add(gears.pollFirst());

                //gears = result;
                //out.println("END");
            }
            //out.println(budget);
            doneWithCode = true;

            TreeSet<Gear> result = new TreeSet<Gear>();

            while(gears.size() > 0)
                result.add(gears.pollFirst());

            writer.println(minForRanger);
            for(Gear g : result)
            {
                writer.println(g);
            }
            
            //Code here
            writer.close();
            /*
            //Use open comment before this line
            long endTime = System.nanoTime();

            long totalTime = endTime - startTime;

            double totalTimeInSeconds = ((double)totalTime)/1000000000;

            if(totalTimeInSeconds >= 4.0)
                out.println("TIME LIMIT EXCEEDED");
            else
            {
                boolean isTestOutputCorrect = true;
                BufferedReader correctOutputReader = new BufferedReader(new FileReader(pathToHackerrankTestingFolder + fileName + "/output/output"+inputOutputNumber+".txt"));
                BufferedReader testOutputReader = new BufferedReader(new FileReader(pathToHackerrankTestingFolder + fileName + "/testOutput/testOutput"+inputOutputNumber+".txt"));
                String correctOutputLine;
                String testOutputLine = "";

                while((correctOutputLine=correctOutputReader.readLine())!=null && (testOutputLine=testOutputReader.readLine())!=null)
                {
                    if(!correctOutputLine.equals(testOutputLine))
                    {
                        isTestOutputCorrect = false;
                        break;
                    }
                }

                if(testOutputLine==null && correctOutputLine != null)
                    isTestOutputCorrect = false;

                if(isTestOutputCorrect)
                    out.println("TEST " + inputOutputNumber + " CORRECT - TIME: " + totalTimeInSeconds);
                else
                    out.println("TEST " + inputOutputNumber + " INCORRECT - TIME: " + totalTimeInSeconds);
            }
        }
        //Use close comment after this line
        */
    }

    public static String formatTitle(String title)
    {
        String ret = ""+title.charAt(0);
        for(int i = 1; i < title.length(); i++)
        {
            if(title.charAt(i) >= 'A' && title.charAt(i) <= 'Z')
            {
                ret += "-";
            }
            ret += title.charAt(i);
        }
        return ret.toLowerCase();
    }
}