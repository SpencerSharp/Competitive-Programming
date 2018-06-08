/*
ID: spencer16
LANG: JAVA
PROG: citystate
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class citystate
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("citystate.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        HashMap<String,HashMap<String,Integer>> cities = new HashMap<String,HashMap<String,Integer>>();
        String line;
        StringTokenizer st;
        line = f.readLine();
        st = new StringTokenizer(line);
        int numCities = Integer.parseInt(st.nextToken());
        for(int i = 0; i < numCities; i++)
        {
            line = f.readLine();
            st = new StringTokenizer(line);
            String city = ""+st.nextToken();
            city = city.substring(0,2);
            String state = ""+st.nextToken();
            try
            {
                HashMap<String,Integer> cityInfo = cities.get(city);
                try{
                    cityInfo.put(state,cityInfo.get(state)+1);
                }
                catch(Exception e)
                {
                    cityInfo.put(state,1);
                }
            }
            catch(Exception e)
            {
                HashMap<String,Integer> cityInfo = new HashMap<String,Integer>();
                cityInfo.put(state, 1);
                cities.put(city,cityInfo);
            }
            out.println(cities);
        }
        //out.println(cities.get("FL"));
        Iterator it = cities.entrySet().iterator();
        int total = 0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            //out.println(pair.getKey() + " " + pair.getValue());
            Iterator it2 = ((HashMap<String,Integer>)pair.getValue()).entrySet().iterator();
            while(it2.hasNext())
            {
                Map.Entry pair2 = (Map.Entry)it2.next();
                //out.println(pair2.getKey());// + " " + pair2.getValue());
                int multi = (int)pair2.getValue();
                try
                {
                    HashMap<String,Integer> subHash = cities.get(pair2.getKey());
                    int otherMulti = subHash.get(pair.getKey());
                    if(pair.getKey().equals(pair2.getKey()))
                        otherMulti--;
                    total += multi * otherMulti;
                }
                catch(Exception e)
                {
                    
                }
                //it2.remove();
            }
            //it.remove(); // avoids a ConcurrentModificationException
        }
        
        //Code here

        writer.println(total/2);
        
        //writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
