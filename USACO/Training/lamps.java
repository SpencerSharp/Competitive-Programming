/*
ID: spencer16
LANG: JAVA
PROG: lamps
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class lamps
{
    long button1xor;
    long button2xor;
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("lamps.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        int numLamps = Integer.parseInt(f.readLine());
        int c = Integer.parseInt(f.readLine());
        ArrayList<Integer> mustBeOn = new ArrayList<Integer>();
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int cur = Integer.parseInt(st.nextToken());
        while(cur!=-1)
        {
            //out.println(cur);
            mustBeOn.add(cur);
            cur = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> mustBeOff = new ArrayList<Integer>();
        line = f.readLine();
        st = new StringTokenizer(line);
        cur = Integer.parseInt(st.nextToken());
        while(cur!=-1)
        {
            mustBeOff.add(cur);
            cur = Integer.parseInt(st.nextToken());
        }
        String theNum = "";
        for(int i = 0; i < numLamps; i++)
            theNum += "1";
        /*
        int c = 1;
        
        ArrayList<String> posConfigs = getPosConfigs(c,theNum);
        //out.println("done");
        posConfigs = eliminateRepeats(posConfigs);
        Collections.sort(posConfigs);
        Collections.reverse(posConfigs);
        for(String s : posConfigs)
            out.println(s);
        out.println(posConfigs.size());
        */

        ArrayList<String> results = new ArrayList<String>();
        if(c==0)
        {
            //out.println("swag");
            String[] posBits = {"0000"};
            for(String s : posBits)
                results.add(applyBits(theNum,s));
        }
        else if(c==1)
        {
            String[] posBits = {"1000","0100","0010","0001"};
            for(String s : posBits)
                results.add(applyBits(theNum,s));
            
        }
        else if(c==2)
        {
            String[] posBits = {"0000","1100","1010","1001","0110","0101","0011"};
            for(String s : posBits)
                results.add(applyBits(theNum,s));
        }
        else
        {
            String[] posBits = {"0000","1000","0100","0010","0001","1100","1010","1001","0110","0101","0011","1110","0111","1111"};
            for(String s : posBits)
                results.add(applyBits(theNum,s));
        }
        //out.println(results);
        results = eliminateRepeats(results);
        //for(String s : results)
        //    out.println(s);
        Collections.sort(results);
        //Collections.reverse(results);
        results = removeIfNotOn(results,mustBeOn);
        results = removeIfNotOff(results,mustBeOff);
        if(results.size()==0)
        {
            writer.println("IMPOSSIBLE");
        }
        else
        {
            for(String s : results)
                writer.println(s);
        }
        //Remove repeats
        //Make sure requirements are satisfied
        
        //Code here

        //out.println(output);
        
        
        //writer.println(output);
        
        writer.close();
        System.exit(0);
        
        
    }
    
    public static ArrayList<String> removeIfNotOn(ArrayList<String> results, ArrayList<Integer> mustBeOn)
    {
        ArrayList<String> ret = new ArrayList<String>();
        for(String s : results)
        {
            boolean isValid = true;
            for(int n : mustBeOn)
            {
                if(s.charAt(n-1)=='0')
                {
                    isValid = false;
                    break;
                }
            }
            if(isValid)
                ret.add(s);
        }
        return ret;
    }
    
    public static ArrayList<String> removeIfNotOff(ArrayList<String> results, ArrayList<Integer> mustBeOn)
    {
        ArrayList<String> ret = new ArrayList<String>();
        for(String s : results)
        {
            boolean isValid = true;
            for(int n : mustBeOn)
            {
                if(s.charAt(n-1)=='1')
                {
                    isValid = false;
                    break;
                }
            }
            if(isValid)
                ret.add(s);
        }
        return ret;
    }
    
    public static String applyBits(String num, String bits)
    {
        if(bits.charAt(0)=='1')
            num = modify(num,0);
        if(bits.charAt(1)=='1')
            num = modify(num,1);
        if(bits.charAt(2)=='1')
            num = modify(num,2);
        if(bits.charAt(3)=='1')
            num = modify(num,3);
        return num;
    }

    public static ArrayList<String> eliminateRepeats(ArrayList<String> init)
    {
        ArrayList<String> ret = new ArrayList<String>();
        while(init.size()>0)
        {
            String cur = init.remove(0);
            boolean doesContain = false;
            for(int i = 0; i < ret.size(); i++)
            {
                if(cur.equals(ret.get(i)))
                {
                    doesContain = true;
                    break;
                }
            }
            if(!doesContain)
                ret.add(cur);
        }
        return ret;
    }
    
    public static ArrayList<String> getPosConfigs(int n, String setup)
    {
        out.println(n);
        if(n==0)
        {
            ArrayList<String> ray = new ArrayList<String>();
            ray.add(setup);
            return ray;
        }
        else
        {
            ArrayList<String> ret = new ArrayList<String>();
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(modify(setup,0));
            temp.add(modify(setup,1));
            temp.add(modify(setup,2));
            temp.add(modify(setup,3));
            for(int i = 0; i < temp.size(); i++)
            {
                //out.println(n-1);
                ret.addAll(getPosConfigs(n-1,temp.get(i)));
            }
            return ret;
        }
    }
    
    public static String modify(String base, int button)
    {
        String newBase = "";
        char zero = '0';
        if(button==0)
        {
            for(int n = 0; n < base.length(); n++)
            {
                if(base.charAt(n)==zero)
                    newBase+='1';
                else
                    newBase+='0';
            }
        }
        else if(button==1)
        {
            for(int n = 0; n < base.length(); n++)
            {
                int lamp = n+1;
                char cur = base.charAt(n);
                if(lamp%2==1)
                {
                    if(cur==zero)
                        newBase+='1';
                    else
                        newBase+='0';
                }
                else
                {
                    newBase += cur;
                }
            }
        }
        else if(button==2)
        {
            for(int n = 0; n < base.length(); n++)
            {
                int lamp = n+1;
                char cur = base.charAt(n);
                if(lamp%2==0)
                {
                    if(cur==zero)
                        newBase+='1';
                    else
                        newBase+='0';
                }
                else
                    newBase += cur;
            }
        }
        else
        {
            for(int n = 0; n < base.length(); n++)
            {
                int lamp = n+1;
                char cur = base.charAt(n);
                if(lamp%3==1)
                {
                    if(cur==zero)
                        newBase+='1';
                    else
                        newBase+='0';
                }
                else
                    newBase += cur;
            }
        }
        return newBase;
    }
}
