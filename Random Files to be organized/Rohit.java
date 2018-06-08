import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

/*
FROM UIL SET A PROGRAMMING PRACTICE
*/
public class Rohit {
    public static int globalMax;
    public static class Node
    {
        public int num;
        ArrayList<Node> children = new ArrayList<Node>();
        public Node()
        {
            
        }
        
        public Node(int n)
        {
            num = n;
        }
        
        public void addNode(Node n)
        {
            children.add(n);
        }
        
        public int getNodeNum()
        {
            return num;
        }
        public ArrayList<Node> getChildRay()
        {
            return children;
        }
        
        public String getChildren()
        {
            String s = "";
            for(Node n : children)
                s += n + " ";
            if(s.length()>0)
                s = s.substring(0,s.length()-1);
            return s;
        }
        
        public String toString()
        {
            return ""+num;
        }
    }
            
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("/Users/spencersharp/Desktop/input.txt"));
        int numCases = Integer.parseInt(sc.nextLine());
        for(int curCase = 0; curCase < numCases; curCase++)
        {
            String levelInfo = sc.nextLine();
            ArrayList<Node> nodes = new ArrayList<Node>();
            nodes.add(new Node(0));
            
            globalMax = 0;
            buildTree(nodes,levelInfo,0);
            int n = Integer.parseInt(sc.nextLine());
            //out.println(nodes.get(0).getChildren());
            String children = getChildrenOfNode(n,nodes.get(0));
            if(n>globalMax)
                out.println("NOT IN TREE");
            else
                out.println(children.equals("")?"NO CHILDREN":children);
        }
    }
    
    public static String getChildrenOfNode(int target, Node n)
    {
        if(target==n.getNodeNum())
            return n.getChildren();
        String ret = "";
        for(Node no : n.getChildRay())
        {
            String children = getChildrenOfNode(target,no);
            if(!children.equals(""))
                ret = children;
        }
        //out.println(n);
        return ret;
    }
    
    public static ArrayList<Node> buildTree(ArrayList<Node> nodesOnLastLevel, String info, int max)
    {
        ArrayList<Node> nodesOnThisLevel = new ArrayList<Node>();
        int numPerOnThisLevel = Integer.parseInt((info.charAt(0)+""));
        if(info.length()>=2)
            info = info.substring(2);
        else
            info = "";
        for(int i = 0; i < nodesOnLastLevel.size(); i++)
        {
            for(int j = 0; j < numPerOnThisLevel; j++)
            {
                Node n = new Node(++max);
                nodesOnThisLevel.add(n);
                nodesOnLastLevel.get(i).addNode(n);
            }
        }
        globalMax = max;
        if(!info.equals(""))
            return buildTree(nodesOnThisLevel,info,max);
        return nodesOnThisLevel;
    }
}