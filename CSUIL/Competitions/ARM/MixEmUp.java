
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class MixEmUp {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("mixemup.dat"));
        int numLoops = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numLoops; i++) {
            String line = sc.nextLine();
            String[] cards = line.split(" ");
            //System.out.println(line);
            ArrayList<String> cardsRay = new ArrayList<String>();
            for(int k = 0; k < cards.length; k++) {
                cardsRay.add(cards[k]);
            }
            //System.out.println(cardsRay);
            String val = "";
            for(int k = 0; k < cardsRay.size() - 1; k++) {
                if(cardsRay.get(k).equals(cardsRay.get(k + 1))) {
                    val = cardsRay.remove(k + 1);
                    cardsRay.add(val);
                }
            }
            
            for(int k = 0; k < cardsRay.size(); k++) {
                if(k<cardsRay.size()-1)
                    out.print(cardsRay.get(k) + " ");
                else
                    out.print(cardsRay.get(k));
            }
            
            System.out.println();
        }
    }
}
