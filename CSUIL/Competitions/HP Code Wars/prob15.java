import static java.lang.System.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class prob15 {
    static int[] linear = {1,2,3,4,5,6};
    static int[] fibonacci = {0,1,1,2,3,5};
    static int[] tribonacci = {0,0,1,1,2,4};
    static int[] normal = {1,2,2,3,3,4};
    static int[] zipf = {1,1,1,2,2,3};
    static int[] prime = {0,1,2,3,5,7};
    static int[] gaussian = {1,2,3,3,4,5};
    
    public static int[] getRayFromLetter(String let)
    {
        if(let.equals("L"))
            return linear;
        else if(let.equals("F"))
            return fibonacci;
        else if(let.equals("T"))
            return tribonacci;
        else if(let.equals("N"))
            return normal;
        else if(let.equals("Z"))
            return zipf;
        else if(let.equals("P"))
            return prime;
        else if(let.equals("G"))
            return gaussian;
        return null;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc2 = new Scanner(new File("prob15.txt"));
        while(sc2.hasNextLine())
        {
            String line = sc2.nextLine();
            Scanner sc = new Scanner(line);
            String type1 = sc.next();
            String type2 = sc.next();
            String type3 = sc.next();
            String lineDisp1 = type1 + " " + type2 + " " + type3;
            int goal1 = Integer.parseInt(sc.next());
            int goal2 = Integer.parseInt(sc.next());
            int goal3 = Integer.parseInt(sc.next());
            int total = 0;
            int total1 = 0;
            int total2 = 0;
            int total3 = 0;
            double percent1;
            double percent2;
            double percent3;
            
            int[] ray1;
            int[] ray2;
            int[] ray3;
            if(type1.equals("X")&&type2.equals("X")&&type3.equals("X"))
                break;
            if(type1.equals("X")||type2.equals("X")||type3.equals("X"))
            {
                if(type1.equals("X"))
                    type1 = type3;
                else if(type2.equals("X"))
                    type2 = type3;
                ray1 = getRayFromLetter(type1);
                ray2 = getRayFromLetter(type2);
                for(int i = 0; i < 6; i++)
                {
                    for(int j = 0; j < 6; j++)
                    {
                        if(ray1[i]+ray2[j]==goal1)
                            total++;
                    }
                }
                percent1 = ((double)total)/36;
                total1 = total;
                total = 0;
                for(int i = 0; i < 6; i++)
                {
                    for(int j = 0; j < 6; j++)
                    {
                        if(ray1[i]+ray2[j]==goal2)
                            total++;
                    }
                }
                total2 = total;
                percent2 = ((double)total)/36;
                total = 0;
                for(int i = 0; i < 6; i++)
                {
                    for(int j = 0; j < 6; j++)
                    {
                        if(ray1[i]+ray2[j]==goal3)
                            total++;
                    }
                }
                percent3 = ((double)total)/36;
                total3 = total;
                out.println(lineDisp1);
                out.println(goal1 + "   " + total1 + "   " + (100*percent1) + "%");
                out.println(goal2 + "   " + total2 + "   " + (100*percent2) + "%");
                out.println(goal3 + "   " + total3 + "   " + (100*percent3) + "%");
            }
            else
            {
                ray1 = getRayFromLetter(type1);
                ray2 = getRayFromLetter(type2);
                ray3 = getRayFromLetter(type3);
                for(int i = 0; i < 6; i++)
                {
                    for(int j = 0; j < 6; j++)
                    {
                        for(int l = 0; l < 6; l++){
                        if(ray1[i]+ray2[j]+ray3[l]==goal1)
                            total++;
                        }
                    }
                }
                percent1 = ((double)total)/216;
                total1 = total;
                total = 0;
                for(int i = 0; i < 6; i++)
                {
                    for(int j = 0; j < 6; j++)
                    {
                        for(int k = 0; k < 6; k++){
                        if(ray1[i]+ray2[j]+ray3[k]==goal2)
                            total++;
                        }
                    }
                }
                total2 = total;
                percent2 = ((double)total)/216;
                total = 0;
                for(int i = 0; i < 6; i++)
                {
                    for(int j = 0; j < 6; j++)
                    {
                        for(int k = 0; k < 6; k++){
                        if(ray1[i]+ray2[j]+ray3[k]==goal3)
                            total++;
                        }
                    }
                }
                percent3 = ((double)total)/216;
                total3 = total;
                out.println(lineDisp1);
                out.println(goal1 + "   " + total1 + "   " + (percent1*100) + "%");
                out.println(goal2 + "   " + total2 + "   " + (100*percent2) + "%");
                out.println(goal3 + "   " + total3 + "   " + (100*percent3) + "%");
            }
        }
    }
}

