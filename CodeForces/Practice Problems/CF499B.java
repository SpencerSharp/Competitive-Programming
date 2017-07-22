import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF499B
{
    static HashMap<String,String> dict = new HashMap<String,String>();
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        
        int numLectureWords = Integer.parseInt(st.nextToken());
        int numDictWords = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < numDictWords; i++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            
            String word1 = st.nextToken();
            String word2 = st.nextToken();
            
            String result = word2;
            if(word1.length()<=word2.length())
                result = word1;
            
            dict.put(word1, result);
            dict.put(word2, result);
        }
        
        line = f.readLine();
        st = new StringTokenizer(line);
        
        for(int i = 0; i < numLectureWords; i++)
        {
            String word = st.nextToken();
            if(i<numLectureWords-1)
            {
                writer.print(dict.get(word) + " ");
            }
            else
            {
                writer.println(dict.get(word));
            }
        }
        //Code here

        //out.println(output);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}