import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class Backup
{
    public static class Node
    {
        HashMap<Integer,Node> children = new HashMap<Integer,Node>();
        HashMap<String,Node> childrenNames = new  HashMap<String,Node>();
        String name;
        int depth;
        
        public void addStringToNode(String s)
        {
            if(s.contains("/"))
            {
                String start = s.substring(0,s.indexOf("/"));
                if(childrenNames.containsKey(start))
                {
                    Node found = childrenNames.get(start);
                    s = s.substring(s.indexOf("/")+1);
                    found.addStringToNode(s);
                }
                else
                {
                    Node n = new Node();
                    n.depth = depth+1;
                    n.name = start;
                    childrenNames.put(start,n);
                    children.put(children.size(),n);
                    s = s.substring(s.indexOf("/")+1);
                    n.addStringToNode(s);
                }
                
            }
            else
            {
                Node n = new Node();
                n.depth = depth+1;
                n.name = s;
                childrenNames.put(s,n);
                children.put(children.size(),n);
            }
        }
        
        public String toString()
        {
            String ret = "";
            for(int i = 0; i < depth; i++)
                ret += "  ";
            ret += name +"\n";
            for(int sub : children.keySet())
            {
                ret += "" + children.get(sub) + "\n";
            }
            ret = ret.substring(0,ret.length());
            return ret;
        }
        
        
        @Override
        public boolean equals(Object o)
        {
            //out.println(children);
            Node other = (Node) o;
            if(children.size() == 0 && other.children.size() == 0)
                return true;
            if(children.size() != other.children.size())
                return false;
            HashMap<Integer,Node> childrenThisCopy = (HashMap<Integer,Node>) children.clone();
            HashMap<Integer,Node> childrenOtherCopy = (HashMap<Integer,Node>) other.children.clone();
            for(int i = 0; i < children.size(); i++)
            {
                for(int j = 0; j < other.children.size(); j++)
                {
                    if(children.get(i).equals(other.children.get(j)))
                    {
                        childrenThisCopy.remove(i);
                        childrenOtherCopy.remove(j);
                        shiftDown(childrenThisCopy,i);
                        shiftDown(childrenOtherCopy,j);
                        Node temp1 = new Node();
                        Node temp2 = new Node();
                        temp1.children = childrenThisCopy;
                        temp2.children = childrenOtherCopy;
                        return temp1.equals(temp2);
                    }
                }
            }
            return false;
        }
    }
    
    public static void shiftDown(HashMap<Integer,Node> c, int n)
    {
        for(int i = n; i < c.size(); i++)
        {
            c.put(i, c.get(i+1));
        }
        c.remove(c.size()-1);
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
        Node parent1 = new Node();
        
        int numLines = Integer.parseInt(f.readLine());
        
        for(int i = 0; i < numLines; i++)
        {
            String line = f.readLine();
            parent1.addStringToNode(line);
        }
        
        //out.println(parent1);
        
        Node parent2 = new Node();
        
        numLines = Integer.parseInt(f.readLine());
        
        for(int i = 0; i < numLines; i++)
        {
            String line = f.readLine();
            parent2.addStringToNode(line);
        }
        
        //out.println(parent2);
        
        if(parent1.equals(parent2))
        {
            output = "OK";
        }
        else
        {
            output = "INVALID";
        }
        
        
        
        //Code here

        out.println(output);
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
}