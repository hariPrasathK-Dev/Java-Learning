import java.util.* ;

public class topologicalSorting 
{
    private class Edge
    {
        private String vertex ;
        private int weight ;

        public Edge(String vertex,int weight)
        {
            this.vertex = vertex ;
            this.weight = weight ;
        }

        @Override
        public String toString()
        {
            return "("+vertex+","+weight+")" ;
        }
    }

    HashMap<String,ArrayList<Edge>> adjacencyListOutgoing ;
    HashMap<String,ArrayList<Edge>> adjacencyListIncoming ;

    public topologicalSorting()
    {
        adjacencyListOutgoing = new HashMap<>() ;
        adjacencyListIncoming = new HashMap<>() ;
    }

    public void addVertex(String vertex)
    {
        adjacencyListOutgoing.putIfAbsent(vertex,new ArrayList<>()) ;
        adjacencyListIncoming.putIfAbsent(vertex,new ArrayList<>()) ;
    }

    public void addEdge(String vertex1,String vertex2,int weight,boolean isDirected)
    {
        addVertex(vertex1) ;
        addVertex(vertex2) ;

        adjacencyListOutgoing.get(vertex1).add(new Edge(vertex2,weight)) ;
        adjacencyListIncoming.get(vertex2).add(new Edge(vertex1,weight)) ;
        if(!isDirected)
        {
            adjacencyListOutgoing.get(vertex2).add(new Edge(vertex1,weight)) ;
            adjacencyListIncoming.get(vertex1).add(new Edge(vertex2,weight)) ;
        }
    }

    public void removeVertex(String vertex)
    {
        if(adjacencyListOutgoing.containsKey(vertex) && adjacencyListIncoming.containsKey(vertex))
        {
            adjacencyListOutgoing.remove(vertex) ;
            adjacencyListIncoming.remove(vertex) ;

            for(String key : adjacencyListOutgoing.keySet())
            {
                Iterator<Edge> iterate = adjacencyListOutgoing.get(key).listIterator() ;

                while(iterate.hasNext())
                {
                    Edge edge = iterate.next() ;

                    if(edge.vertex.equals(vertex))
                    {
                        iterate.remove() ;
                    }
                }
            }

            for(String key : adjacencyListIncoming.keySet())
            {
                ListIterator<Edge> iterate = adjacencyListIncoming.get(key).listIterator() ;

                while(iterate.hasNext())
                {
                    Edge edge = iterate.next() ;

                    if(edge.vertex.equals(vertex))
                    {
                        iterate.remove() ;
                    }
                }
            }
        }
    }

    public int calculateInDegree(String vertex)
    {
        return adjacencyListIncoming.get(vertex).size() ;
    }

    public ArrayList<String> topologicalSort() 
    {
        HashMap<String, Integer> indegrees = new HashMap<>();
        ArrayList<String> sort = new ArrayList<>();

        // Initialize in-degrees
        for (String vertex : adjacencyListOutgoing.keySet()) 
        {
            indegrees.put(vertex, calculateInDegree(vertex));
        }

        // Queue for vertices with in-degree 0
        Queue<String> queue = new LinkedList<>();
        for (String vertex : indegrees.keySet()) 
        {
            if (indegrees.get(vertex) == 0) {
                queue.add(vertex);
            }
        }

        // Process vertices
        while (!queue.isEmpty()) 
        {
            String vertex = queue.poll();
            sort.add(vertex);

            // Decrement the in-degree of neighbors and add them to the queue if they reach 0
            if (adjacencyListOutgoing.containsKey(vertex)) 
            {
                for (Edge edge : adjacencyListOutgoing.get(vertex)) 
                {
                    String neighbor = edge.vertex;
                    indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                    if (indegrees.get(neighbor) == 0) 
                    {
                        queue.add(neighbor);
                    }
                }
            }

            // Remove processed vertex from the graph
            adjacencyListOutgoing.remove(vertex);
        }

        // Check if topological sort was possible (graph had no cycles)
        if (sort.size() != indegrees.size()) {
            System.out.println("The graph has a cycle, so topological sorting is not possible.");
            return new ArrayList<>();
        }

        return sort;
    }

    public static void main(String[] args) {
        topologicalSorting tps = new topologicalSorting() ;
        tps.addEdge("V1","V2", 0, true);
        tps.addEdge("V1","V3",0,true) ;
        tps.addEdge("V1","V4",0,true) ;
        tps.addEdge("V2","V4",0,true) ;
        tps.addEdge("V2","V5",0,true) ;
        tps.addEdge("V4","V3",0,true) ;
        tps.addEdge("V4","V5",0,true) ;

        ArrayList<String> result = tps.topologicalSort(); 
        System.out.println("The Topological Sort : "+result) ;
    }
    
}
