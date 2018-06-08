
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spencersharp
 */
public class Madison {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("/Users/spencersharp/Desktop/input.txt"));
        while(sc.hasNext())
        {
            String operators = sc.next();
            String vals = sc.next();
            operators = replaceLettersWithVals(operators,vals);
            out.println(evalString(operators));
        }

    }
    
    public static String replaceLettersWithVals(String s, String vals)
    {
        s = s.replaceAll("A",vals.charAt(0)=='1'?"1":"0");
        s = s.replaceAll("B",vals.charAt(1)=='1'?"1":"0");
        if(vals.length()==3)
            s = s.replaceAll("C",vals.charAt(2)=='1'?"1":"0");
        return s;
    }
    
    public static boolean evalString(String s)
    {
        //out.println(s);
        if(s.contains("("))
        {
            boolean evalSub = evalString(s.substring(s.indexOf('(')+1,s.indexOf(')')));
            String evalRes = evalSub?"1":"0";
            //out.println(s);
            s = s.substring(0,s.indexOf('(')) + evalRes + s.substring(s.indexOf(')')+1);
        }
        while(s.contains("!"))
        {
            String replace = s.substring(s.indexOf('!')+1,s.indexOf('!')+2);
            replace = replace.equals("1")?"0":"1";
            s = s.substring(0,s.indexOf('!')) + replace + s.substring(s.indexOf('!')+2);
        }
        char symbol = '*';
        while(s.contains("*"))
        {
            symbol = '*';
            boolean first = (s.substring(s.indexOf(symbol)-1,s.indexOf('*'))).equals("1")?true:false;
            boolean second  = s.substring(s.indexOf('*')+1,s.indexOf('*')+2).equals("1")?true:false;
            //out.println(first + " " + second);
            String res = ( first&&second )?"1":"0";
            s = s.substring(0,s.indexOf('*')-1) + res + s.substring(s.indexOf('*')+2);
        }
        while(s.contains("^"))
        {
            boolean first = (s.substring(s.indexOf('^')-1,s.indexOf('^'))).equals("1")?true:false;
            boolean second  = s.substring(s.indexOf('^')+1,s.indexOf('^')+2).equals("1")?true:false;
            String res = ( first^second )?"1":"0";
            s = s.substring(0,s.indexOf('^')-1) + res + s.substring(s.indexOf('^')+2);
        }
        while(s.contains("+"))
        {
            boolean first = (s.substring(s.indexOf('+')-1,s.indexOf('+'))).equals("1")?true:false;
            boolean second  = s.substring(s.indexOf('+')+1,s.indexOf('+')+2).equals("1")?true:false;
            String res = ( first||second )?"1":"0";
            s = s.substring(0,s.indexOf('+')-1) + res + s.substring(s.indexOf('+')+2);
        }
        boolean evalRes = s.equals("1")?true:false;
        return evalRes;
    }
}