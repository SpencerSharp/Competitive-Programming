import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

//Link to problem statement: https://www.hackerrank.com/contests/acm-9817/challenges/flight-path

//public class Solution
public class FlightPath
{
    static class City
    {
        String name;
        HashSet<String> namesOfOthers;
        boolean visited;
        
        public City()
        {
            visited = false;
        }
        
        public City(String name)
        {
            this.name = name;
            namesOfOthers = new HashSet<String>();
            visited = false;
        }
        
        public HashSet<String> getConnections()
        {
            return namesOfOthers;
        }
        
        public void addConnection(String s)
        {
            namesOfOthers.add(s);
        }
        
        public String toString()
        {
            return name;
        }
    }
    
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
            String fileName = formatTitle("FlightPath") + "-testcases";
            String pathToHackerrankTestingFolder = "/Users/spencersharp/Desktop/HackerrankTesting/";
            BufferedReader f = new BufferedReader(new FileReader(pathToHackerrankTestingFolder + fileName + "/input/input"+inputOutputNumber+".txt"));
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pathToHackerrankTestingFolder + fileName + "/testOutput/testOutput"+inputOutputNumber+".txt")));
            //Comment the end comment after this line
            */
            
            BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
            
            String output = ""; //Write all output to this string

            //Code here
            int numTestCases = Integer.parseInt(f.readLine());
        
            for(int i = 0; i < numTestCases; i++)
            {

                HashMap<String,City> cities = new HashMap<String,City>();
                String line;
                StringTokenizer st;

                st = new StringTokenizer(f.readLine());

                String initCity = st.nextToken();
                String endCity = st.nextToken();

                long numConnections = Long.parseLong(f.readLine());

                for(long cur = 0; cur < numConnections; cur++)
                {
                    st = new StringTokenizer(f.readLine());

                    String startC = st.nextToken();

                    String endC = st.nextToken();

                    if(!cities.containsKey(startC))
                    {
                        cities.put(startC,new City(startC));
                    }
                    if(!cities.containsKey(endC))
                    {
                        cities.put(endC,new City(endC));
                    }

                    cities.get(startC).addConnection(endC);
                }

                Stack<City> s = new Stack<City>();
                City cur = cities.get(initCity);
                s.add(cur);

                boolean wasFail = false;
                boolean wasWin = false;
                boolean hadConnections = false;

                if(cur.name.equals(endCity))
                {
                    wasWin = true;

                }
                else
                {
                    while(!cur.name.equals(endCity))
                    {
                        cur.visited = true;
                        hadConnections = false;
                        //out.println(s);
                        if(s.size() > 0)
                        {
                            cur = s.pop();

                            if(cur.name.equals(endCity))
                            {
                                wasWin = true;
                                break;
                            }

                            for(String str : cur.getConnections())
                            {
                                City thing = cities.get(str);
                                if(!thing.visited)
                                {
                                    s.push(cities.get(str));
                                    hadConnections = true;
                                    continue;
                                }
                            }
                        }

                        if(hadConnections == true)
                            continue;

                        if(s.size()==0)
                        {
                            wasFail = true;
                            break;
                        }
                    }
                }

                if(wasWin || !wasFail)
                    writer.println("Yes");
                else
                    writer.println("No");
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