
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
public class PrimeGenerator {
    public static void main(String[] args)
    {
        int max = 100000;
        for(int i = 2; i < max; i++)
        {
            if(isPrime(i))
                out.println(i);
        }
    }
    
    public static boolean isPrime(int n)
    {
        for(int i = 2; i <= Math.sqrt(n); i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
}