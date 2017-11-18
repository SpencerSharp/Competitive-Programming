import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Neon
{
    static String overlapped = "ERROR";
    
    public class Overlap
    {
        String s1;
        String s2;
        int len;
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numWords = Integer.parseInt(f.readLine());
        
        //out.println(longestOverlapBetweenWords("ENTRANCE","OPEN"));
        
        
        
        TreeSet<String> words = new TreeSet<String>();
        
        for(int i = 0; i < numWords; i++)
        {
            words.add(f.readLine());
        }
        
        while(words.size() > 1)
        {
            int maxOverlap = -1;
            String first = "";
            String second = "";
            String resultWord = "";
            for(String s1 : words)
            {
                for(String s2 : words)
                {
                    if(s1.compareTo(s2) < 0)
                    {
                        if(s1.length() < s2.length())
                        {
                            String temp = s1;
                            s1 = s2;
                            s2 = temp;
                        }
                        int overlap = longestOverlapBetweenWords(s1, s2);
                        //out.println(overlap);
                        if(maxOverlap == -1 || overlap > maxOverlap)
                        {
                            first = s1;
                            second = s2;
                            maxOverlap = overlap;
                            resultWord = overlapped;
                        }
                    }
                }
            }
            words.remove(first);
            words.remove(second);
            words.add(resultWord);
            //out.println(words);
        }
        
        for(String s : words)
        {
            output = ""+s.length();
        }
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int longestOverlapBetweenWords(String s1, String s2)
    {
        //Pre: s1 is longer or same length as s2
        if(s1.contains(s2))
            return s1.length();
        else
        {
            int bestSoFar = 0;
            //Put s2 in front of s1
            String s1Sub = "";
            String s2Sub = "";
            for(int i = 0; i < s2.length()-1; i++)
            {
                s1Sub += s1.charAt(i);
                s2Sub = s2.charAt(s2.length()-i-1) + s2Sub;
                //out.println(s1Sub + " " + s2Sub);
                if(s1Sub.equals(s2Sub))
                {
                    if(i >= bestSoFar)
                    {
                        overlapped = s2.substring(0,s2.length()-i-1) + s2Sub + s1.substring(i+1,s1.length());
                        bestSoFar = i+1;
                    }
                }
            }
            //out.println(bestSoFar);
            //Put s2 after s1
            s1Sub = "";
            s2Sub = "";
            for(int i = 0; i < s2.length()-1; i++)
            {
                s1Sub = s1.charAt(s1.length()-i-1) + s1Sub;
                s2Sub += s2.charAt(i);
                if(s1Sub.equals(s2Sub))
                {
                    if(i >= bestSoFar)
                    {
                        overlapped = s1.substring(0,s1.length()-i-1) + s2Sub + s2.substring(i+1,s2.length());
                        bestSoFar = i+1;
                    }
                }
            }
            return bestSoFar;
        }
    }
}