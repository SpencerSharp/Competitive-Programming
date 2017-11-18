import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class D
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        boolean isBroken = false;
        
        int length = Integer.parseInt(f.readLine());
        
        String line = f.readLine();
        
        String[] ray = line.split("\\.\\.\\.\\.");
        
        long racks = 0;
        
        for(int i = 0; i < ray.length; i++)
        {
            if(ray[i].contains("EEEEE"))
            {
                isBroken = true;
                break;
            }
            int temp = numRacksForString(ray[i], i==0, i==ray.length-1);
            if(temp == -1)
            {
                isBroken = true;
                break;
            }
            racks += temp;
            //out.println(ray[i] + " " + temp);
        }
        output = ""+racks;
        //out.println(Arrays.toString(ray));
        
        
        if(isBroken)
            output = "-1";
        //Code here
        //E.E..E
        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static int numRacksForString(String s, boolean firstString, boolean lastString)
    {
        if(s.length() < 5)
        {
            if(s.length() == 1)
                return 1;
            else if(s.length() == 2)
                return 1;
            else if(s.length() == 3)
            {
                if(s.charAt(0) == 'E' && s.charAt(1) == 'E' && s.charAt(2) == 'E')
                    return 2;
                else
                    return 1;
            }
            else if(s.length() == 4)
            {
                if(s.charAt(0) == 'E' && s.charAt(1) == 'E' && s.charAt(2) == 'E' && s.charAt(3) == 'E')
                {
                    return 2;
                }
                else{
                    return 1;
                }
            }
        }
        
        int numRacks = 0;
        HashSet<Integer> racks = new HashSet<Integer>();
        for(int i = 0; i < s.length()-2; i++)
        {
            if(s.charAt(i) == 'E')
            {
                if(s.charAt(i+2) == 'E')
                {
                    if(s.charAt(i+1) == 'E')
                    {
                        if(i == 0)
                        {
                            if(firstString)
                            {
                                return -1;
                            }
                            else
                            {
                                if(i > s.length()-10)
                                    racks.add(i-1);
                                i++;
                            }
                        }
                        else
                        {
                            if(s.charAt(i-1) == 'E')
                            {
                                if(i > s.length()-10)
                                    racks.add(i-2);
                            }
                            else
                            {
                                if(i > s.length()-10)
                                    racks.add(i-1);
                                i++;
                            }
                        }
                    }
                    else
                    {
                        if(i > s.length()-10)
                            racks.add(i+1);
                        i+=2;
                    }
                }
                else
                {
                    if(i > s.length()-10)
                        racks.add(i+2);
                    i+=4;
                }
                numRacks++;
            }
        }
        //out.println("THERACKS"+racks);
        //out.println("NUM"+numRacks);
        char thirdlast = s.charAt(s.length()-3);
        char secondlast = s.charAt(s.length()-2);
        char last = s.charAt(s.length()-1);
        if(last == 'E')
        {
            if(secondlast == 'E')
            {
                if(thirdlast == 'E')
                {
                    if(lastString)
                        return -1;
                    else
                    {
                        if(racks.contains(s.length()-4) || racks.contains(s.length()-5))
                        {
                            numRacks++;
                        }
                        else
                        {
                            numRacks += 2;
                        }
                    }
                }
                else
                {
                    if(racks.contains(s.length()-3))
                    {
                    }
                    else
                    {
                        numRacks++;
                    }
                }
            }
            else
            {
                if(thirdlast == 'E')
                {
                    numRacks++;
                }
                else
                {
                    if(racks.contains(s.length()-2) || racks.contains(s.length()-3))
                    {
                        
                    }
                    else
                    {
                        //out.println("HELPME");
                        numRacks++;
                    }
                }
            }
        }
        else
        {
            if(secondlast == 'E')
            {
                if(thirdlast == 'E')
                {
                    if(racks.contains(s.length()-4))
                    {
                        
                    }
                    else
                    {
                        numRacks++;
                    }
                }
                else
                {
                    if(racks.contains(s.length()-3) || racks.contains(s.length()-4))
                    {
                        
                    }
                    else
                    {
                        numRacks++;
                    }
                }
            }
            else
            {
                if(thirdlast == 'E')
                {
                    if(racks.contains(s.length()-4) || racks.contains(s.length()-5))
                    {
                        
                    }
                    else
                    {
                        numRacks++;
                    }
                }
            }
        }
        return numRacks;
    }
}