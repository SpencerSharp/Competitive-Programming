import static java.lang.System.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class prob17 {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("prob17-1-in.txt"));
        while(file.hasNextLine()) {
            String line = file.nextLine();
            line = line.toUpperCase();
            line = fixString(line);
            ArrayList<String> pos = allPosSubstrings(line, 1);
            double max = 0.0;
            for (String s : pos) {
                double val = max;
            }
        }
    }
    
    public static ArrayList<String> allPosSubstrings(String s, int l)
    {
        ArrayList<String> ret = new ArrayList<String>();
        if(l>s.length())
            return new ArrayList<String>();
        for(int i = 0; i < s.length()-1; i++)
        {
            ret.add(s.substring(i,i+l));
        }
        ArrayList<String> ret2 = allPosSubstrings(s,l+1);
        for(String st: ret2)
            ret.add(st);
        return ret;
    }
    
    public static String fixString(String str) {
        ArrayList<String> numerals = new ArrayList<>();
        numerals.add("M");
        numerals.add("D");
        numerals.add("C");
        numerals.add("L");
        numerals.add("X");
        numerals.add("V");
        numerals.add("I");
        numerals.add("S");
        
        String[] array = str.split(" ");
        String removePart1  = "";
        for(String s : array) {
            removePart1 += s;
        }
        array = removePart1.split("");
        String removePart2 = "";
        for(int i =0; i < array.length; i++) {
            if (numerals.contains(array[i])) {
                removePart2 += array[i];
            }
        }
        return removePart2;
    }
    
    public static int getVal(String r) {
        String roman = r;
        ArrayList<String> numerals = new ArrayList<>();
        numerals.add("M");
        numerals.add("CM");
        numerals.add("D");
        numerals.add("CD");
        numerals.add("C");
        numerals.add("XC");
        numerals.add("L");
        numerals.add("XL");
        numerals.add("X");
        numerals.add("IX");
        numerals.add("V");
        numerals.add("IV");
        numerals.add("I");
        numerals.add("S");
        
        ArrayList<Double> values = new ArrayList<>();
        values.add(1000);
        values.add(900);
        values.add(500);
        values.add(400);
        values.add(100);
        values.add(90);
        values.add(50);
        values.add(40);
        values.add(10);
        values.add(9);
        values.add(5);
        values.add(4);
        values.add(1);
        values.add(.5);
        
        
        
        int totalVal = 0;
        for (int i = 0; i < numerals.size(); i++) {
            while (roman.indexOf(numerals.get(i)) == 0) {
                totalVal += values.get(i);
                roman = roman.substring(numerals.get(i).length());
            }
        }
        return totalVal;
    }
}