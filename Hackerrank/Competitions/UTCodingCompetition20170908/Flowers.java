import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

//Link to problem statement: https://www.hackerrank.com/contests/acm-9817/challenges/flowers-3

//public class Solution
public class Flowers
{
    public static class Flower
    {
        int petals;
        int number;
        
        public Flower()
        {
            
        }
        
        public Flower(int p, int n)
        {
            petals = p;
            number = n;
        }
    }
    
    public static HashMap<Integer,Integer> genAllPrimes()
    {
        HashMap<Integer,Integer> ret = new HashMap<Integer,Integer>();
        int index = 0;
        for(int i = 2; i < 100000; i++)
        {
            boolean isPrime = true;
            for(int j = 0; j < ret.size(); j++)
            {
                if(i%ret.get(j) == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                ret.put(index++,i);
        }
        return ret;
    }

    public static void main(String[] args) throws IOException
    {
        /*
        //Use open comment before this line
        int numFiles = 36;
        for(int curFileIndex = 0; curFileIndex < numFiles; curFileIndex++)
        {
            String inputOutputNumber = ""+curFileIndex;
            if(inputOutputNumber.length()==1)
                inputOutputNumber = "0" + inputOutputNumber;
            long startTime = System.nanoTime();
            String fileName = formatTitle("Flowers-3") + "-testcases";
            String pathToHackerrankTestingFolder = "/Users/spencersharp/Desktop/HackerrankTesting/";
            BufferedReader f = new BufferedReader(new FileReader(pathToHackerrankTestingFolder + fileName + "/input/input"+inputOutputNumber+".txt"));
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pathToHackerrankTestingFolder + fileName + "/testOutput/testOutput"+inputOutputNumber+".txt")));
            //Comment the end comment after this line
            */
            
            BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
            
            String output = ""; //Write all output to this string

            //Code here
            HashMap<Integer,Integer> primes = genAllPrimes();
            int size = primes.size();

            int numSets = Integer.parseInt(f.readLine());
            //numSets = 100000;

            StringTokenizer st;

            HashMap<Integer,Flower> flowers = new HashMap<Integer,Flower>();

            int maxPetals = 0;

            for(int i = 0; i < numSets; i++)
            {
                st = new StringTokenizer(f.readLine());

                Flower fl = new Flower(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                maxPetals = Math.max(maxPetals,fl.petals);
                //Flower fl = new Flower(100000,100000);
                flowers.put(i, fl);
            }

            long max = 0;

            if(numSets > 100000/25)
            {
                size = (int)((size*100000)/(25*numSets));
            }

            for(int i = 0; i < size; i++) //prime loop
            {
                long total = 0;
                int prime = primes.get(i);
                if(prime < maxPetals)
                {
                    for(int j = 0; j < numSets; j++) //flower loop
                    {
                        Flower fl = flowers.get(j);
                        if(fl.petals % prime == 0)
                            total += fl.number;
                    }
                }
                //if(i%1000==0)
                //    out.println(i);
                max = Math.max(total, max);
            }

            output = ""+max;

            writer.println(output);

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