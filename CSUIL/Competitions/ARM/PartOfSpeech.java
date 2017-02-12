import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.System.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bo
 */
public class PartOfSpeech {
    static ArrayList<String> articles;
    static ArrayList<String> helpers;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("partofspeech.dat"));
        //String line2 = sc.next();
        articles = new ArrayList<String>();
        helpers = new ArrayList<String>();
        
        String line = sc.nextLine();
        Scanner l = new Scanner(line);
        while(l.hasNext())
            articles.add(l.next().toUpperCase());
        sc.nextLine();
        sc.nextLine();
        int numWords = sc.nextInt();
        for(int j = 0; j < numWords; j++)
        {
            String word = sc.next();
            int numSentences = sc.nextInt();
            sc.nextLine();
            for(int i = 0; i < numSentences; i++)
            {
                String sentence = sc.nextLine();
                String[] sentenceRay = sentence.split(" ");
                for(int k = 0; k < sentenceRay.length; k++)
                    sentenceRay[k] = removePunctuation(sentenceRay[k].toUpperCase());
                for(int k = 0; k < sentenceRay.length; k++)
                    if(sentenceRay[k].equals(word))
                    {
                        if(isAnArticle(sentenceRay[k-1]))
                            out.println("NOUN");
                        else
                            out.println("VERB");
                        break;
                    }
            }
            if(j!=numWords-1)
                out.println();
        }
    }
    
    public static boolean isAnArticle(String s)
    {
        for(String l : articles)
            if(l.equals(s))
                return true;
        return false;
    }
    
    public static String removePunctuation(String s)
    {
        String result = "";
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i)==',' || s.charAt(i)=='!' || s.charAt(i)=='.')
            {
                
            }
            else
            {
                result += s.charAt(i);
            }
        }
        return result;
        
    }
}