import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

//Link to Problem Statement: https://www.hackerrank.com/contests/22417-acm-competition/challenges/leaves

//public class Solution
public class Leaves
{
    static class Leaf implements Comparable
    {
        int p;
        int col;
        int h;
        Leaf left;
        Leaf right;
        
        public Leaf(int n, int c, int h)
        {
            p = n;
            col = c;
            this.h = h;
        }
        
        public Leaf addToTree(int number)
        {
            if(number < p)
            {
                if(left==null)
                {
                    Leaf l = new Leaf(number,col-1,h+1);
                    left = l;
                    return l;
                }
                else
                {
                    return left.addToTree(number);
                }
            }
            else
            {
                if(right==null)
                {
                    Leaf r = new Leaf(number,col+1,h+1);
                    right = r;
                    return r;
                }
                else
                {
                    return right.addToTree(number);
                }
            }
        }
        
        public Leaf findLeaf(int num)
        {
            if(num==p)
                return this;
            else if(num < p)
            {
                return left.findLeaf(num);
            }
            else
            {
                return right.findLeaf(num);
            }
        }
        
        public int compareTo(Object o)
        {
            int colDiff = col - ((Leaf)o).col;
            if(colDiff!=0)
                return colDiff;
            else
            {
                int hDiff = h - ((Leaf)o).h;
                if(hDiff != 0)
                    return hDiff;
                else
                    return p - ((Leaf)o).p;
            }
        }
        
        public String toString()
        {
            return ""+p;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        
        //Use open comment before this line
        int numFiles = 12; //PUT THE NUMBER OF FILES HERE (If last file is input19.txt, put 20 here)
        for(int curFileIndex = 0; curFileIndex < numFiles; curFileIndex++)
        {
            String inputOutputNumber = ""+curFileIndex;
            if(inputOutputNumber.length()==1)
                inputOutputNumber = "0" + inputOutputNumber;
            long startTime = System.nanoTime();
            String fileName = "Leaves".toLowerCase() + "-testcases";
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
            int numCases = Integer.parseInt(f.readLine());
        
            StringTokenizer st;

            for(int i = 0; i < numCases; i++)
            {
                st = new StringTokenizer(f.readLine());
                ArrayList<Leaf> leaves = new ArrayList<Leaf>();
                HashSet<Integer> nums = new HashSet<Integer>();

                int numNodes = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(f.readLine());

                Leaf parent = new Leaf(Integer.parseInt(st.nextToken()), 0, 0);
                nums.add(parent.col);
                leaves.add(parent);

                for(int j = 0; j < numNodes-1; j++)
                {
                    Leaf child;

                    int num = Integer.parseInt(st.nextToken());

                    leaves.add(parent.addToTree(num));
                }

                /*
                for(int n : nums)
                {
                    leaves.add(parent.findLeaf(n));
                }
                */

                Collections.sort(leaves);

                for(int j = 0; j < numNodes-1; j++)
                {
                    writer.print(leaves.get(j) + " ");
                }

                writer.println(leaves.get(numNodes-1));
                writer.close();
            }
            //Thread.sleep(100);
            
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
                    if(!correctOutputLine.equals(testOutputLine))
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