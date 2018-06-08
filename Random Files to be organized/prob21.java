
import static java.lang.System.out;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spencersharp
 */
public class prob21 {
    public static void main(String[] args)
    {
        String main = "hayneedle";
        String mainCopy = main;
        String buildUp = "";
        String source = "a needle lost in a haystack";
        //source = removeSpacesFrom(source);
        while(buildUp.length()< main.length())
        {
            boolean hasStoppedBeingAbleToFind = false;
            String sub = mainCopy.substring(0,2);
            int curLen = 2;
            if(source.indexOf(sub)!=-1)
                hasStoppedBeingAbleToFind = false;
            else{
                hasStoppedBeingAbleToFind = true;
                out.println("FAIL");
            }
            while(!hasStoppedBeingAbleToFind)
            {
                    sub = mainCopy.substring(0,++curLen);
                if(source.indexOf(sub)!=-1  && curLen<mainCopy.length()-1)
                hasStoppedBeingAbleToFind = false;
                else{
                    hasStoppedBeingAbleToFind = true;
                }
            }
           
            curLen--;
            sub = mainCopy.substring(0,curLen);
            buildUp += sub;
            
            mainCopy = mainCopy.substring(curLen);
            out.println(buildUp);
        }
        
    }
    
    public static boolean findSubConstruction(String main, String source, int len)
    {
        //String sub =
        return true;
    }
    
    public static String removeSpacesFrom(String s)
    {
        String ret = "";
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i)!=' ')
                ret += s.charAt(i);
        return ret;
    }
}
