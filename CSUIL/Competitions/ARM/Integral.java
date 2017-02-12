
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
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
public class Integral {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("integral.dat"));
        int numLoops = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numLoops; i++) {
            double startX = Double.parseDouble(sc.next());
            double endX = Double.parseDouble(sc.next());
            double interval = Double.parseDouble(sc.next());
            //out.println(startX + " " + endX + " " + interval);
            double total = 0;
            for(double curX = startX; curX < endX; curX+=interval)
            {
                total += getFuncValForX(curX)*interval;
            }
            out.printf("%.6f\n",total);
        }
    }
    
    public static double getFuncValForX(double x)
    {
        return (3*x*x) + (2*x) + 1;
    }
}