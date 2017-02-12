import static java.lang.System.*;
import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class Catalog implements Comparable {
    private String name;
    private Integer page;
    public static boolean isAlpha = false;
    
    public Catalog(String s, int p)
    {
        name = s;
        page = p;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Integer getPage()
    {
        return page;
    }
    public int compareTo(Object o)
    {
        Catalog other = (Catalog) o;
        if(isAlpha)
            return name.compareTo(other.getName());
        else
            return page.compareTo(other.getPage());
    }
    
    public String toString()
    {
        return name + " " + page;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("catalog.dat"));
        int numLoops = sc.nextInt();
        sc.nextLine();
        ArrayList<Catalog> catalogs = new ArrayList<Catalog>();
        for (int loop = 0; loop < numLoops; loop++) {
            String line = sc.nextLine();
            ArrayList<String> words = new ArrayList<String>();
            Scanner scLine = new Scanner(line);
            while(scLine.hasNext())
                words.add(scLine.next());
            String name = "";
            int page = Integer.parseInt(words.remove(words.size()-1));
            for(String s : words)
                name += s + " ";
            name = name.substring(0,name.length()-1);
            Catalog cat = new Catalog(name,page);
            catalogs.add(cat);
        }
        isAlpha = false;
        Collections.sort(catalogs);
        for(Catalog cat : catalogs)
            out.println(cat);
        out.println();
        isAlpha = true;
        Collections.sort(catalogs);
        for(Catalog cat : catalogs)
            out.println(cat);
    }
}