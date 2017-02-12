
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
public class Resize {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("resize.dat"));
        int numLoops = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numLoops; i++) {
            int num1 = Integer.parseInt(sc.next());
            sc.next();
            int num2 = Integer.parseInt(sc.next());
            sc.next();
            int num3 = Integer.parseInt(sc.next());
            sc.next();
            int num4 = Integer.parseInt(sc.next());
            
            double ratio1 = (double)num1 / (double)num2;
            double ratio2 = (double)num3 / (double)num4;
            
            //out.println(num2*ratio1);
            double multi1 = (double)num3/(double)num1;
            double multi2 = (double)num4/(double)num2;
            
            out.printf("%.2f",num1*multi1);
            out.print(" by ");
            out.printf("%.2f",num2*multi1);
            out.print(" or ");
            out.printf("%.2f",num1*multi2);
            out.print(" by ");
            out.printf("%.2f\n",num2*multi2);
        }
    }
}
