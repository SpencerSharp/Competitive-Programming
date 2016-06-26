
import static java.lang.System.out;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spencersharp
 */
public class genFactors {
    public static void main(String[] args)
    {
        for(int i = 2; i <= 100; i++)
        {
            ArrayList<Integer> factors = new ArrayList<Integer>();
            for(int j = 1; j <= i; j++)
            {
                if(i%j==0)
                    factors.add(j);
            }
            out.println(i + " " + factors);
        }
    }
}
