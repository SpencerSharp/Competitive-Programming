import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Depend
{
    static HashMap<String,Library> libsByName;
    static HashSet<Library> doneOnes;
    static TreeSet<Library> lowestOnes;
    
    static class Library implements Comparable<Library>
    {
        String name;
        HashSet<String> subs;
        
        public Library(String name)
        {
            this.name = name;
            subs = new HashSet<String>();
        }
        
        public void addLibByName(String add)
        {
            subs.add(add);
        }

        public boolean isLowestLib()
        {
            if(doneOnes.contains(this))
                return false;
            for(String libName : subs)
            {
                Library lib = libsByName.get(libName);
                if(!doneOnes.contains(lib))
                    return false;
            }
            return true;
        }
        
        public boolean doesDependOn(Library o)
        {
            if(o.equals(this))
                return true;
            for(String libName : subs)
            {
                if(libName.equals(o.name))
                {
                    return true;
                }
                if(libsByName.get(libName).doesDependOn(o))
                    return true;
            }
            return false;
        }
        
        public boolean equals(Object o)
        {
            return name.equals(((Library)o).name);
        }
        
        public int compareTo(Library o)
        {
            return name.compareTo(o.name);
        }
        
        public String toString()
        {
            return name;
            /*
            String ret =  "";
            ret += "NAME: " + name +" \n";
            for(String lib : subs)
                ret += "       " + libsByName.get(lib);
            return ret;
            */
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        /*
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        */
        String output = ""; //Write all output to this string

        //Code here
        String parentName = f.readLine();
        
        libsByName = new HashMap<String,Library>();
        
        int numLines = Integer.parseInt(f.readLine());
        
        StringTokenizer st;
        
        for(int i = 0; i < numLines; i++)
        {
            st = new StringTokenizer(f.readLine());
            
            String libName = st.nextToken();
            
            Library lib = new Library(libName);
            
            int numDeps = Integer.parseInt(st.nextToken());
            
            for(int j = 0; j < numDeps; j++)
            {
                lib.addLibByName(st.nextToken());
            }
            
            libsByName.put(libName, lib);
        }
        
        Library parent = libsByName.get(parentName);
        
        HashMap<String,Library> updated = new HashMap<String,Library>();
        
        for(String libName : libsByName.keySet())
        {
            Library lib = libsByName.get(libName);

            if(parent.doesDependOn(lib))
                updated.put(lib.name,lib);
        }
        
        libsByName = updated;
        
        doneOnes = new HashSet<Library>();
        lowestOnes = new TreeSet<Library>();
        
        while(doneOnes.size() < libsByName.size())
        {
            for(String libName : libsByName.keySet())
            {
                Library lib = libsByName.get(libName);
                
                if(lib.isLowestLib())
                    lowestOnes.add(lib);
            }
            
            for(Library lib : lowestOnes)
            {
                if(output.length() == 0)
                    output += ""+lib;
                else
                    output += " " + lib;
            }
            
            //out.println(lowestOnes);
            
            for(Library lib : lowestOnes)
                doneOnes.add(lib);
            
            
            lowestOnes = new TreeSet<Library>();
        }
        
        //out.println(libsByName.get(parentName));
        
        
        
        
        //Code here

        out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
}