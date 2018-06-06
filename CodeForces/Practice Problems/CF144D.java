import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF144D
{
    static HashMap<Long, HashSet<Road>> connections = new HashMap<Long, HashSet<Road>>();
    
    public static class Road
    {
        long dest;
        long weight;
        
        public Road(long end, long weight)
        {
            this.dest = end;
            this.weight = weight;
        }
        
        public String toString()
        {
            return dest + " " + weight;
        }
    }
    
    public static class City implements Comparable<City>
    {
        long id;
        long distTo;
        
        public City(long id)
        {
            this.id = id;
        }
        
        public City(long id, long distTo)
        {
            this.id = id;
            this.distTo = distTo;
        }
        
        public int compareTo(City o)
        {
            return (int) (distTo - o.distTo);
        }

        @Override
        public int hashCode()
        {
            return (int) (Math.random() * Integer.MAX_VALUE * 2 - Integer.MAX_VALUE);
        }
        
        public boolean equals(Object o)
        {
            return false;
        }
        
        public String toString()
        {
            return id + " " + distTo;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        HashSet<Long> visited = new HashSet<Long>();
        HashMap<Long, Long> dists = new HashMap<Long, Long>();
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        long numCities = Long.parseLong(st.nextToken());
        long numRoads = Long.parseLong(st.nextToken());
        long capital = Long.parseLong(st.nextToken());
        
        long curTempCity = numCities+1;
        
        PriorityQueue<City> pq = new PriorityQueue<City>();
        
        pq.add(new City(capital, 0));
        
        for(long m = 0; m < numRoads; m++)
        {
            st = new StringTokenizer(f.readLine());
            
            long start = Long.parseLong(st.nextToken());
            long dest = Long.parseLong(st.nextToken());
            long dist = Long.parseLong(st.nextToken());
            
            
            
            if(0 > 1)
            {
                HashSet<Road> temp;
                if(connections.get(start) != null)
                {
                    temp = connections.get(start);
                }
                else
                {
                    temp = new HashSet<Road>();
                }
                out.println("TEMP: " + temp);
                temp.add(new Road(curTempCity, 1));
                out.println("TEMP: " + temp);

                connections.put(start, temp);

                if(connections.get(curTempCity) != null)
                {
                    temp = connections.get(curTempCity);
                }
                else
                {
                    temp = new HashSet<Road>();
                }
                out.println("TEMP: " + temp);
                temp.add(new Road(start, 1));
                out.println("TEMP: " + temp);

                connections.put(curTempCity, temp);

                curTempCity++;

                for(long i = 0; i < dist - 2; i++)
                {
                    if(connections.get(curTempCity) != null)
                    {
                        temp = connections.get(curTempCity);
                    }
                    else
                    {
                        temp = new HashSet<Road>();
                    }
                    temp.add(new Road(curTempCity, 1));

                    connections.put(curTempCity + 1, temp);

                    if(connections.get(curTempCity + 1) != null)
                    {
                        temp = connections.get(curTempCity + 1);
                    }
                    else
                    {
                        temp = new HashSet<Road>();
                    }
                    temp.add(new Road(curTempCity, 1));

                    connections.put(curTempCity + 1, temp);
                    
                    curTempCity++;
                }
                
                if(connections.get(dest) != null)
                {
                    temp = connections.get(dest);
                }
                else
                {
                    temp = new HashSet<Road>();
                }
                temp.add(new Road(curTempCity - 1, 1));

                connections.put(dest, temp);

                if(connections.get(curTempCity - 1) != null)
                {
                    temp = connections.get(curTempCity - 1);
                }
                else
                {
                    temp = new HashSet<Road>();
                }
                temp.add(new Road(dest, 1));

                connections.put(curTempCity - 1, temp);
            }
            else
            {
                //out.println(connections);
                
                HashSet<Road> temp;
                if(connections.get(start) != null)
                {
                    temp = connections.get(start);
                }
                else
                {
                    temp = new HashSet<Road>();
                }
                temp.add(new Road(dest, dist));

                connections.put(start, temp);

                if(connections.get(dest) != null)
                {
                    temp = connections.get(dest);
                }
                else
                {
                    temp = new HashSet<Road>();
                }
                temp.add(new Road(start, dist));

                connections.put(dest, temp);
                
                //out.println(connections);
                //out.println();
            }
        }
        
        long goalDist = Long.parseLong(f.readLine());
        long found = 0;
        
        HashSet<String> roadsWithSilosAtExactlyHalfway = new HashSet<String>();
        
        //out.println("------------");
        
        while(pq.size() > 0)
        {
            City cur = pq.poll();
            
            //out.println("ID: " + cur.id);
            
            if(!visited.contains(cur.id))
            {
                if(cur.distTo == goalDist)
                {
                    found++;
                }
                for(Road road : connections.get(cur.id))
                {
                    if(!visited.contains(road.dest))
                        pq.add(new City(road.dest, road.weight + cur.distTo));
                }
                visited.add(cur.id);
                //out.println(cur.distTo);
                dists.put(cur.id, cur.distTo);
            }
            //out.println(pq);
            //out.println();
        }
        for(long id : dists.keySet())
        {
          //  out.println(id + " " + dists.get(id));
        }
        //out.println(found);
        int halvesToRemove = 0;
        for(long startId : connections.keySet())
        {
            HashSet<Road> roads = connections.get(startId);
            long startDist = dists.get(startId);
            
            for(Road road : roads)
            {
                long endDist = road.weight + startDist;
                long roadNotUsed = endDist - goalDist;
                long regularDist = goalDist;
                long altDistance = dists.get(road.dest) + roadNotUsed;
                
                if(startDist < goalDist && endDist > goalDist)
                {
                    //out.println(startId + " " + road.dest);
                    //out.println(regularDist + " " + altDistance);
                    //out.println();
                    if(regularDist < altDistance)
                    {
                        found++;
                    }
                    if(regularDist == altDistance)
                    {
                        //In the middle
                        found++;
                        halvesToRemove++;
                    }
                    
                }
                    
            }
        }
        //Code here
        found -= halvesToRemove / 2;

        out.println(found);
        output = "" + found;
        /*
        writer.println(output);
        writer.close();
        System.exit(0);
        */
    }
}