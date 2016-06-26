/*
ID: spencer16
LANG: JAVA
PROG: namenum
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class namenum
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        //BufferedReader d = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/dict.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        BufferedReader d = new BufferedReader(new FileReader("dict.txt"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        String number = f.readLine();
        //ArrayList<String> posNames = genPosNames("",number);
        //out.println("WE DONE");
        ArrayList<String> validNames = new ArrayList<String>();
        TreeSet<String> posValidNames = new TreeSet<String>();
        
        String line = "";
        while((line=d.readLine())!=null){
            if(line.length()==number.length() && contains(getLetsForNum(number.charAt(0)),line.charAt(0)))
                validNames.add(line);
        }
        //out.println("ALL BETTER");
        
        //Collections.sort(validNames);
        
        for(String s : validNames)
        {
            if(matches(number,s))
                posValidNames.add(s);
        }

        //out.println(posValidNames);
        Iterator treeIt = posValidNames.iterator();
        while(treeIt.hasNext())
        {
            output += treeIt.next() + "\n";
        }
        if(output.length() > 0)
            output = output.substring(0,output.length()-1);
        else
            output = "NONE";
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
    
    public static boolean contains(char[] ray, char s)
    {
        for(char s2 : ray)
            if(s == s2)
                return true;
        return false;
    }
    public static boolean matches(String number, String s)
    {
        if(number.length()!=s.length())
        {
            return false;
        }
        for(int i = 0; i < s.length(); i++)
        {
            if(!contains(getLetsForNum(number.charAt(i)),s.charAt(i)))
                return false;
        }
        return true;
    }
    
    /*public static ArrayList<String> genPosNames(String start, String n)
    {
        //out.println(start);
        ArrayList<String> ret = new ArrayList<String>();
        if((n+"").length()==1)
        {
            //out.println("bot");
            ret.add(start+getLetsForNum(n)[0]);
            ret.add(start+getLetsForNum(n)[1]);
            ret.add(start+getLetsForNum(n)[2]);
            return ret;
        }
        for(int i = 0; i < 3; i++)
        {
            char[] lets = getLetsForNum(n.charAt(0));
            String newN = n.substring(1);
            ret.addAll(genPosNames(start+lets[i],newN));
        }
        return ret;
    }*/
    
    public static char[] getLetsForNum(char s)
    {
        if(s=='2')
            return new char[]{'A','B','C'};
        if(s=='3')
            return new char[]{'D','E','F'};
        if(s=='4')
            return new char[]{'G','H','I'};
        if(s=='5')
            return new char[]{'J','K','L'};
        if(s=='6')
            return new char[]{'M','N','O'};
        if(s=='7')
            return new char[]{'P','R','S'};
        if(s=='8')
            return new char[]{'T','U','V'};
        if(s=='9')
            return new char[]{'W','X','Y'};
        return new char[3];
    }
}