
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
class Cookie extends Treat{
    public Cookie(int sw)
    {
        super();
        out.println("STEVEN HAS SMALL MEMES");
        sweet = sw;
    }
    
    public String toString()
    {
        return sweet + " Cookie";
    }
}
