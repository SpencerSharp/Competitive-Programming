/*
ID: spencer16
LANG: JAVA
PROG: holstein
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class holstein
{
    public static int numFeeds;
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
        
        Feed complexFeed = new Feed(); //Write all output to this string

        //Code here
        int numVitamins = Integer.parseInt(f.readLine());
        ArrayList<Integer> minRequired = new ArrayList<Integer>();
        String line = f.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for(int i = 0; i < numVitamins; i++)
        {
            minRequired.add(Integer.parseInt(st.nextToken()));
        }
        numFeeds = Integer.parseInt(f.readLine());
        ArrayList<Feed> feeds = new ArrayList<Feed>();
        for(int i = 1; i <= numFeeds; i++)
        {
            feeds.add(new Feed(i,f.readLine()));
        }
        complexFeed = getMaxScoops(minRequired,feeds,feeds,1);
        String ret = "";
        ArrayList<Integer> components = complexFeed.components;
        Collections.sort(components);
        ret = ""+components.size();
        for(int n : components)
            ret += " " + n;
        //Code here

        //out.println(ret);
        
        writer.println(ret);
        writer.close();
        System.exit(0);
        
    }
    
    public static Feed getMaxScoops(ArrayList<Integer> minRequired, ArrayList<Feed> feeds, ArrayList<Feed> curFeeds, int curLevel)
    {
        //out.println(curFeeds);
        for(int i = 0; i < curFeeds.size(); i++)
        {
            if(curFeeds.get(i).doesSatisfy(minRequired))
                return curFeeds.get(i);
        }
        ArrayList<Feed> newFeeds = new ArrayList<Feed>();
        for(int i = 0; i < curFeeds.size(); i++)
        {
            ArrayList<Integer> nonComponents = curFeeds.get(i).getNonComponents();
            //out.println(curFeeds.get(i).components);
            //out.println(nonComponents);
            for(int j = 0; j < nonComponents.size(); j++)
            {
                newFeeds.add(curFeeds.get(i).plus(feeds.get((nonComponents.get(j))-1)));
            }
        }
        //out.println(newFeeds);
        return getMaxScoops(minRequired, feeds, newFeeds, curLevel+1);
    }
    
    public static class Feed
    {
        ArrayList<Integer> components;
        ArrayList<Integer> provided;
        ArrayList<Integer> nonComponents;
        //int minComponent;
        public Feed()
        {
            provided = new ArrayList<Integer>();
            components = new ArrayList<Integer>();
            nonComponents = new ArrayList<Integer>();
            //genNonComponents();
            //minComponent = 0;
        }
        
        public Feed(int n, String s)
        {
            provided = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(s);
            while(st.hasMoreTokens())
            {
                provided.add(Integer.parseInt(st.nextToken()));
            }
            components = new ArrayList<Integer>();
            components.add(n);
            genNonComponents();
            //minComponent = minComponent();
        }
        
        public Feed(int n, ArrayList<Integer> p)
        {
            components = new ArrayList<Integer>();
            components.add(n);
            provided = p;
            genNonComponents();
            //minComponent = minComponent();
        }
        
        public Feed(ArrayList<Integer> c, ArrayList<Integer> p)
        {
            components = c;
            provided = p;
            genNonComponents();
            //minComponent = minComponent();
        }
        
        public Feed plus(Feed f)
        {
            ArrayList<Integer> newFeed = new ArrayList<Integer>();
            for(int i = 0; i < provided.size();i++)
            {
                newFeed.add(provided.get(i)+f.provided.get(i));
            }
            ArrayList<Integer> newComponents = new ArrayList<Integer>();
            for(int i = 0; i < components.size(); i++)
                newComponents.add(components.get(i));
            for(int i = 0; i < f.components.size(); i++)
                newComponents.add(f.components.get(i));
            return new Feed(newComponents, newFeed);
        }
        
        public int minComponent()
        {
            int min = components.get(0);
            for(int i = 0; i < components.size(); i++)
            {
                if(components.get(i)>min)
                    min = components.get(i);
            }
            return min;
        }
        
        /*public int getMinComponent()
        {
            return minComponent;
        }*/

        private void genNonComponents()
        {
            nonComponents = new ArrayList<Integer>();
            for(int i = minComponent()+1; i <= numFeeds; i++)
            {
                if(!components.contains(i))
                    nonComponents.add(i);
            }
        }
        
        public ArrayList<Integer> getNonComponents()
        {
            return nonComponents;
        }
        
        public boolean sharesComponents(Feed f)
        {
            for(int i = 0; i < components.size(); i++)
            {
                for(int j = 0; j < f.components.size(); j++)
                {
                    if(components.get(i)==f.components.get(j))
                        return true;
                }
            }
            return false;
        }
        
        public boolean doesSatisfy(ArrayList<Integer> reqs)
        {
            for(int i = 0; i < reqs.size(); i++)
            {
                if(provided.get(i)<reqs.get(i))
                    return false;
            }
            return true;
        }
        
        public String toString()
        {
            return ""+components;// + " " + provided;
        }
    }
}
