
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.out;

public class RomanNumerals
{
    public static int[] vals = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    public static String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        String line;
        while(!(null==(line=f.readLine())))
        {
            //out.println(line);
            boolean isNum = true;
            for(int i = 0; i < line.length(); i++)
                for(int n = 0; n < romans.length; n+=2)
                    if(line.charAt(i)==romans[n].charAt(0))
                        isNum = false;
            String result = "";
            if(isNum)
            {
                while(Integer.parseInt(line)>0)
                {
                    //out.println(line);
                    for(int i = 0; i < vals.length; i++)
                    {
                        if(vals[i]<=Integer.parseInt(line))
                        {
                            line = ""+(Integer.parseInt(line)-vals[i]);
                            result += romans[i];
                            break;
                        }
                    }
                }
            }
            else
            {
                boolean isLooping = true;
                int total = 0;
                while(isLooping)
                {
                    //out.println(line);
                    if(line.length()>=2)
                    {
                        String first2 = line.substring(0,2);
                        boolean found = false;
                        for(int i = 1; i < vals.length; i+=2)
                        {
                            if(first2.equals(romans[i]))
                            {
                                total += vals[i];
                                line = line.substring(2);
                                found = true;
                                break;
                            }
                        }
                        if(!found)
                        {
                            for(int i = 0; i < vals.length; i+=2)
                            {
                                if((""+line.substring(0,1)).equals(romans[i]))
                                {
                                    total += vals[i];
                                    line = line.substring(1);
                                    break;
                                }
                            }
                        }
                    }
                    else if(line.length()==1)
                    {
                        for(int i = 0; i < vals.length; i+=2)
                        {
                            if((""+line.substring(0,1)).equals(romans[i]))
                            {
                                total += vals[i];
                                line = line.substring(1);
                                break;
                            }
                        }
                    }
                    else
                    {
                        isLooping = false;
                    }
                }
                result = ""+total;
            }
            out.println(result);
        }
    }
}