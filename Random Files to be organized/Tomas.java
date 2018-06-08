
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
public class Tomas {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("/Users/spencersharp/Desktop/input.txt"));
        while(sc.hasNext())
            out.println(result(Long.parseLong(sc.next())));
    }
    
    public static long result(long inp)
    {
        if(inp<=3)
            return 1;
        else
            return result(inp-3)+result(inp-1)+result(inp-2);
    }
}
