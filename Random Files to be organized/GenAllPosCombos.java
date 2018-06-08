import static java.lang.System.*;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spencersharp
 */
public class GenAllPosCombos {
    public static void main(String[] args)
    {
        /*
        ArrayList<ArrayList<String>> things = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> things2 = new ArrayList<ArrayList<String>>();
        ArrayList<String> words = new ArrayList<String>();
        words.add("Dog");
        words.add("Cat");
        things.add(words);
        addAllTo(things2,things);
        out.println(things2);*/
        ArrayList<String> words = new ArrayList<String>();
        words.add("paintjob");
        words.add("ethel-cat");
        words.add("spot");
        words.add("reinma");
        words.add("venmo");
        words.add("carno");
        Collections.sort(words);
//        words.add("E");
//        words.add("F");
//        words.add("G");
//        words.add("H");
//        words.add("I");
//        words.add("J");
//        words.add("K");
        ArrayList<ArrayList<String>> disp = genAllPosCombosOfWords(words,2);
        for(ArrayList<String> row : disp)
        {
            String outp = "";
            for(String s : row)
                outp += s + " ";
            if(outp.length()>0)
                outp = outp.substring(0,outp.length()-1);
            out.println(outp);
        }
        //out.println(genAllPosCombosOfWords(words,3));
        //out.println(1+2+3+4+5+6+7+8+9);
    }
    
    
    public static ArrayList<ArrayList<String>> genAllPosCombosOfWords(ArrayList<String> words, int num)
    {
        ArrayList<ArrayList<String>> combos = new ArrayList<ArrayList<String>>();
        out.println(words + " " +num);
        if(num==1){
            for(String s : words)
            {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(s);
                combos.add(temp);
            }
        }

        for(int i = 0; i < words.size(); i++)
        {
            String startWord = words.get(i);
            ArrayList<String> miniWords = getSubRay(words,i+1);
            ArrayList<String> posCombo = new ArrayList<String>();
            ArrayList<ArrayList<String>> subCombos = genAllPosCombosOfWords(miniWords,num-1);
            for(int k = 0; k < subCombos.size(); k++)
            {
                subCombos.get(k).add(0,startWord);
            }
            addAllTo(combos, subCombos);
        }
        return combos;
    }
    
    public static ArrayList<String> getSubRay(ArrayList<String> ray, int start)
    {
        ArrayList<String> ray2 = new ArrayList<String>();
        for(String w : ray)
            ray2.add(w);
        for(int i =0; i < start; i++)
            ray2.remove(0);
        return ray2;
    }
    
    public static ArrayList<ArrayList<String>> addAllTo(ArrayList<ArrayList<String>> main, ArrayList<ArrayList<String>> toAdd)
    {
        for(ArrayList<String> ray : toAdd)
            main.add(ray);
        return main;
    }
}