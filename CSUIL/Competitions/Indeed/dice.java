import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class dice {
    public static void main(String[] args) throws IOException {
        String fileName = "dice.dat";
        Scanner sc = new Scanner(new File(fileName));
        int numLoops = sc.nextInt();
        for (int loops = 0; loops < numLoops; loops++) {
            int[] Alex1 = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
            int[] Alex2 = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
            int[] Ben1 = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
            int[] Ben2 = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
            ArrayList<Integer> sumA = new ArrayList<Integer>();
            ArrayList<Integer> sumB = new ArrayList<Integer>();
            ArrayList<Double> probA = new ArrayList<Double>();
            ArrayList<Double> probB = new ArrayList<Double>();
            
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    int sum = Alex1[i] + Alex2[j];
                    if (sumA.indexOf(sum) >= 0)
                        probA.set(sumA.indexOf(sum), probA.get(sumA.indexOf(sum)) + 1.0/36.0);
                    else {
                        sumA.add(sum);
                        probA.add(1.0/36.0);
                    }
                }
            }
            
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    int sum = Ben1[i] + Ben2[j];
                    if (sumB.indexOf(sum) >= 0)
                        probB.set(sumB.indexOf(sum), probB.get(sumB.indexOf(sum)) + 1.0/36.0);
                    else {
                        sumB.add(sum);
                        probB.add(1.0/36.0);
                    }
                }
            }
            
            double winA = 0.0;
            double winB = 0.0;
            for (int i = 0; i < sumA.size(); i++) {
                for (int j = 0; j < sumB.size(); j++) {
                    if (sumA.get(i) > sumB.get(j))
                        winA += probA.get(i) * probB.get(j) * 100;
                    else if (sumB.get(j) > sumA.get(i))
                        winB += probA.get(i) * probB.get(j) * 100;
                }
            }
            
            out.printf("%.3f", winA);
            out.print("% ");
            out.printf("%.3f", winB);
            out.println("%");
        }
    }
    
}
