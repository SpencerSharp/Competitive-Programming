import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF20C
{
    static class Node implements Comparable
    {
        long number;
        long weightToReach = Long.MAX_VALUE;
        HashMap<Long,Long> connections;
        boolean visited = false;
        Node reacher = null;
        
        public Node()
        {
            
        }
        
        public Node(long n)
        {
            number = n;
            connections = new HashMap<Long,Long>();
        }
        
        public void addEdge(Edge e)
        {
            if(number==e.n1)
            {
                if(connections.get(e.n2)!=null)
                {
                    if(connections.get(e.n2) > e.w)
                    {
                        connections.put(e.n2,e.w);
                        //out.println("SUCCESS");
                    }
                }
                else
                {
                    connections.put(e.n2,e.w);
                }
            }
            else
            {
                if(connections.get(e.n1)!=null)
                {
                    if(connections.get(e.n1) > e.w)
                    {
                        connections.put(e.n1,e.w);
                        //out.println("SUCCESS");
                    }
                }
                else
                {
                    connections.put(e.n1,e.w);
                }
            }
        }
        
        public void addNewReacherPos(Node r, long w)
        {
            if(w < weightToReach)
            {
                reacher = r;
                weightToReach = w;
            }
        }
        
        public StringBuilder reacherStringBuilder()
        {
            if(number==1)
            {
                StringBuilder sb = new StringBuilder();
                sb.append("1 ");
                return sb;
            }
            return reacher.reacherStringBuilder().append(" " + number);
        }
        
        public String reacherString()
        {
            return reacher.reacherStringBuilder().append(" " + number).toString();
        }
        
        public int compareTo(Object o)
        {
            Node other = (Node) o;
            if(weightToReach > other.weightToReach)
            {
                return 1;
            }
            else if(weightToReach < other.weightToReach)
            {
                return -1;
            }
            return 0;
        }
        
        public String toString()
        {
            return "" + number;
        }
    }
    
    static class Edge
    {
        long n1;
        long n2;
        long w;
        
        public Edge(long n1, long n2, long w)
        {
            this.n1 = n1;
            this.n2 = n2;
            this.w = w;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        //out.println(Math.pow(10,11));
        //out.println(Integer.MAX_VALUE);
        
        long total = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        
        HashMap<Long,Node> nodes = new HashMap<Long,Node>();
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        long numNodes = Long.parseLong(st.nextToken());
        long numEdges = Long.parseLong(st.nextToken());
        
        //end = numNodes;
        
        for(long i = 0; i < numNodes; i++)
        {
            Node n = new Node(i+1);
            nodes.put(i+1,n);
        }
        
        for(long i = 0; i < numEdges; i++)
        {
            st = new StringTokenizer(f.readLine());
            Edge e = new Edge(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
            nodes.get(e.n1).addEdge(e);
            nodes.get(e.n2).addEdge(e);
        }
        
        //out.println(nodes);
        nodes.get(1l).weightToReach = 0;
        
        //pq.add(nodes.get(1l));
        
        boolean isInitLoop = true;
        
        Node cur = nodes.get(1l);
        
        while(isInitLoop || cur.number != numNodes)
        {
            isInitLoop = false;
            if(!cur.visited)
            {
                //out.println(cur);
                //out.println("YES");
                cur.visited = true;
                long distToCur = cur.weightToReach;
                HashMap<Long,Long> connections = cur.connections;
                //out.println(connections);
                for(Map.Entry<Long, Long> entry : connections.entrySet())
                {
                    Node n = nodes.get(entry.getKey());
                    long reacherDist = distToCur + entry.getValue();
                    n.addNewReacherPos(cur, reacherDist);
                    if(!n.visited && n.number != cur.number)
                    {
                        //out.println("ADDED- "+n);
                        pq.add(n);
                    }
                }
            }
            if(pq.size()==0)
                break;
            cur = pq.poll();
        }
        //out.println("----");
        if(cur.number == numNodes)
        {
            output = cur.reacherString();
        }
        else
        {
            output = "-1";
        }
        //out.println(cur);
        //out.println(cur.reacher.reacher.reacher.reacher);
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}