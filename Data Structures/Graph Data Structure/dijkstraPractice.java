import java.util.* ;

public class dijkstraPractice
{
    private class Edge {
        String vertex;
        int weight;

        Edge(String vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + vertex + ", " + weight + ")";
        }
    }

    HashMap<String,ArrayList<Edge>> adjacencyList ;

    public dijkstraPractice()
    {
        adjacencyList = new HashMap<>() ;
    }

    // Method to add an edge to the graph
    public void addEdge(String source, String destination, int weight, boolean isDirected) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // Add edge from source to destination
        adjacencyList.get(source).add(new Edge(destination, weight));

        // If the graph is undirected, also add the reverse edge
        if (!isDirected) {
            adjacencyList.get(destination).add(new Edge(source, weight));
        }
    }

    public void algorithmDijkstra(String startVertex)
    {
        HashMap<String,Integer> distance = new HashMap<>() ;
        HashMap<String,String> parent = new HashMap<>() ;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(Edge -> Edge.weight)) ;

        for(String vertex : adjacencyList.keySet())
        {
            distance.put(vertex,Integer.MAX_VALUE) ;
        }

        distance.put(startVertex,0) ;
        pq.add(new Edge(startVertex,0)) ;

        while(!pq.isEmpty())
        {
            Edge curEdge = pq.poll() ;
            String curvertex = curEdge.vertex ;

            for(Edge edges : adjacencyList.get(curvertex))
            {
                int newDist = distance.get(curvertex)+edges.weight ;

                if(newDist < distance.get(edges.vertex))
                {
                    distance.put(edges.vertex,newDist) ;
                    pq.add(new Edge(edges.vertex,newDist)) ;
                    parent.put(edges.vertex,curvertex) ;
                }
            }

        }

    }
}