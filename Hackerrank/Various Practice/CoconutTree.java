import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

//Link to Problem Statement: https://www.hackerrank.com/contests/acm-32417/challenges/coconut-tree

//public class Solution
public class CoconutTree
{
    public static void main(String[] args) throws IOException
    {
        
        //Use open comment before this line
        int numFiles = 13;
        for(int curFileIndex = 0; curFileIndex < numFiles; curFileIndex++)
        {
            String inputOutputNumber = ""+curFileIndex;
            if(inputOutputNumber.length()==1)
                inputOutputNumber = "0" + inputOutputNumber;
            long startTime = System.nanoTime();
            String fileName = "Coconut-tree".toLowerCase() + "-testcases";
            String pathToHackerrankTestingFolder = "/Users/spencersharp/Desktop/HackerrankTesting/";
            BufferedReader f = new BufferedReader(new FileReader(pathToHackerrankTestingFolder + fileName + "/input/input"+inputOutputNumber+".txt"));
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pathToHackerrankTestingFolder + fileName + "/testOutput/testOutput"+inputOutputNumber+".txt")));
            //Comment the end comment after this line
            
            /*
            BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
            */
            String output = ""; //Write all output to this string

            //Code here
            String line = f.readLine();
            StringTokenizer st = new StringTokenizer(line);
            
            int n = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken())-1;
            
            //TreeSet<Double> vals = new TreeSet<Double>();
            
            double minEV = 0.0;
            
            int numPickedSoFar = 0;
            
            double total = 0.0;
            
            for(int i = 0; i < n; i++)
            {
                st = new StringTokenizer(f.readLine());
                
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int fallChance = Integer.parseInt(st.nextToken());
                
                double ev = ((c*v)*(((100-fallChance))/100.0))-(p*(fallChance/100.0));
                
                if(ev > 0.0)
                {
                    if(numPickedSoFar < t)
                    {
                        if(ev < minEV || minEV == 0.0)
                            minEV = ev;
                        total += ev;
                        numPickedSoFar++;
                    }
                    else if(ev > minEV)
                    {
                        //out.println("ELSE"+minEV);
                        total -= minEV;
                        minEV = ev;
                        total += ev;
                    }
                }
                //out.println(total);
            }
            
            writer.println(total);
            
            writer.close();
            //Code here
            
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
                String testOutputLine;

                while((correctOutputLine=correctOutputReader.readLine())!=null && (testOutputLine=testOutputReader.readLine())!=null)
                {
                    Double d1 = Double.parseDouble(correctOutputLine);
                    Double d2 = Double.parseDouble(correctOutputLine);
                    if(Math.abs(d1-d2) > 0.0001)
                    {
                        isTestOutputCorrect = false;
                        break;
                    }
                }

                if(isTestOutputCorrect)
                    out.println("TEST " + inputOutputNumber + " CORRECT - TIME: " + totalTimeInSeconds);
                else
                    out.println("TEST " + inputOutputNumber + " INCORRECT - TIME: " + totalTimeInSeconds);
            }
        }
        //Use close comment after this line
        
    }
}