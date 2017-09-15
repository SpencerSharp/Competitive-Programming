import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

//Link to problem statement: https://www.hackerrank.com/contests/acm-9817/challenges/shirts

//public class Solution
public class Shirts
{
    public static void main(String[] args) throws IOException
    {
        /*
        //Use open comment before this line
        int numFiles = 20;
        for(int curFileIndex = 0; curFileIndex < numFiles; curFileIndex++)
        {
            String inputOutputNumber = ""+curFileIndex;
            if(inputOutputNumber.length()==1)
                inputOutputNumber = "0" + inputOutputNumber;
            long startTime = System.nanoTime();
            String fileName = formatTitle("Shirts") + "-testcases";
            String pathToHackerrankTestingFolder = "/Users/spencersharp/Desktop/HackerrankTesting/";
            BufferedReader f = new BufferedReader(new FileReader(pathToHackerrankTestingFolder + fileName + "/input/input"+inputOutputNumber+".txt"));
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pathToHackerrankTestingFolder + fileName + "/testOutput/testOutput"+inputOutputNumber+".txt")));
            //Comment the end comment after this line
            */
            
            BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
            
            String output = ""; //Write all output to this string

            //Code here
            f.readLine();
            String line;
            while((line = f.readLine()) != null)
            {
                line = line.substring(10);

                line = line.substring(0,line.length()-30);

                writer.println(line);
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