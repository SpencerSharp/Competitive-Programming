import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.Scanner;

/*
FROM UIL SET A PROGRAMMING PRACTICE
*/
public class Daniel {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("/Users/spencersharp/Desktop/input.txt"));
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            Scanner liner = new Scanner(line);
            int curLen = 1;
            
                boolean overflowed = false;
            while(liner.hasNext())
            {
                String output = "";
                for(int i = 0; i < curLen; i++)
                {
                    if(liner.hasNext()){
                        String next = liner.next();
                        if(output.length() + next.length()<= 30)
                            output += next + " ";
                        else{
                            String restOf = "";
                    while(liner.hasNext())
                        restOf += liner.next() + " ";
                        overflowed = true;
                            liner = new Scanner(next + " " + restOf);
                        }
                    }
                }
                output = output.substring(0,output.length()-1);
                if(overflowed)
                {
                    curLen = 1;
                    overflowed = false;
                    out.println(output);
                }
                else{
                    out.println(output);
                    curLen++;}
                
            }
            out.println("---------*---------*---------*");
        }
    }
}