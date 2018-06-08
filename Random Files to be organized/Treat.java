
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
abstract class Treat {
    
    protected int sweet;
    static int numTreats = 0;
    
    /*public Treat()
    {
        out.println("BO HAS BIG MEMES");
        sweet = 1;
        numTreats++;
    }*/
    
    public static int howMany()
    {
        return numTreats;
    }
    
    public String toString()
    {
        return sweet + " Treat";
    }
}
