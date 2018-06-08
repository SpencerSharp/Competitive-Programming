import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/*
FROM UIL SET A PROGRAMMING PRACTICE
*/
public class Isabella {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("/Users/spencersharp/Desktop/input.txt"));
        int numConversions = Integer.parseInt(sc.nextLine());
        TreeMap<String,BigDecimal> convs = new TreeMap<String,BigDecimal>();
        for(int curConv = 0; curConv < numConversions; curConv++)
        {
            Scanner liner = new Scanner(sc.nextLine());
            String key = liner.next() + " " + liner.next();
            //out.println(liner.next());
            BigDecimal val = new BigDecimal(liner.next());
            convs.put(key,val);
        }
        //out.println(convs);
        int numLedgers = Integer.parseInt(sc.nextLine());
        for(int curLedger = 0; curLedger < numLedgers; curLedger++)
        {
            int amountToSum = Integer.parseInt(sc.nextLine());
            ArrayList<String> lines = new ArrayList<String>();
            for(int curSumInd = 0; curSumInd < amountToSum; curSumInd++)
            {
                lines.add(sc.nextLine());
            }
            BigDecimal expectedTotal = new BigDecimal(sc.next());
            String finalConv = sc.next();
            if(sc.hasNext())
                sc.nextLine();
            BigDecimal total = new BigDecimal("0");
            for(int i = 0; i < lines.size(); i++)
            {
                Scanner liner = new Scanner(lines.get(i));
                BigDecimal num = new BigDecimal(liner.next());
                String initConv = liner.next();
                //out.println(initConv + " " + finalConv);
                if(initConv.equals(finalConv))
                    total = total.add(num);
                else
                    total = total.add(num.multiply(convs.get(initConv + " " + finalConv)));
            }
            out.println(total.equals(expectedTotal)?"GOOD LEDGER":"BAD LEDGER");
        }
    }
}