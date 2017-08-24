import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF118B
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int hankySize = Integer.parseInt(f.readLine());
        
        output = printHandkerchief(hankySize);
        
        output = output.substring(0,output.length()-1);
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static String printHandkerchief(int size)
    {
        String ret = "";
        for(int i = 0; i < (size*2)+1; i++)
        {
            String line = "";
            if(i <= size)
            {
                boolean hasReachedMax = false;
                boolean isDone = false;
                int cur = 0;
                for(int j = 0; j < ((size*4)+1); j++)
                {
                    if(j < ((size*2)-(i*2)))
                    {
                        line += " ";
                    }
                    else
                    {
                        if(j%2==0)
                        {
                            if(!hasReachedMax)
                            {
                                int numToDisplay = cur++;
                                if(numToDisplay==i)
                                {
                                    hasReachedMax = true;
                                    if(i==0)
                                        isDone = true;
                                    cur = numToDisplay-1;
                                }
                                line += numToDisplay;
                            }
                            else if(!isDone)
                            {
                                int numToDisplay = cur--;
                                if(numToDisplay==0)
                                {
                                    isDone = true;
                                }
                                line += numToDisplay;
                            }
                        }
                        else if(!isDone)
                        {
                            line += " ";
                        }
                    }
                }
            }
            else
            {
                boolean hasReachedMax = false;
                boolean isDone = false;
                int cur = 0;
                for(int j = 0; j < ((size*4)+1); j++)
                {
                    if(j < ((size*2)-((size-(i-size))*2)))
                    {
                        line += " ";
                    }
                    else
                    {
                        if(j%2==0)
                        {
                            if(!hasReachedMax)
                            {
                                int numToDisplay = cur++;
                                if(numToDisplay==size-(i-size)) //If it's equal to the max of the line
                                {
                                    hasReachedMax = true;
                                    if((size*2)-i==0)
                                        isDone = true;
                                    cur = numToDisplay-1;
                                }
                                line += numToDisplay;
                            }
                            else if(!isDone)
                            {
                                int numToDisplay = cur--;
                                if(numToDisplay==0)
                                {
                                    isDone = true;
                                }
                                line += numToDisplay;
                            }
                        }
                        else if(!isDone)
                        {
                            line += " ";
                        }
                    }
                }
            }
            ret += line + "\n";
        }
        return ret;
    }
}