import java.util.* ;

public class primspractice 
{
    private class Edge {
        String vertex;
        int weight;

        public Edge(String vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + vertex + "," + weight + ")";
        }
    }

    private class Pair {
        String v1;
        String v2;

        public Pair(String v1, String v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public String toString() {
            return "(" + v1 + "," + v2 + ")";
        }
    }

    HashMap<String,ArrayList<Edge>> adjacencyList ;

    public primspractice()
    {
        adjacencyList = new HashMap<>() ;

    }
    
    public void addEdge(String source, String destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight));
    }

    public void primsAlgo(String startVertex)
    {
        HashMap<String,Boolean> visited = new HashMap<>() ;
        HashMap<String,String> parent = new HashMap<>() ;
        ArrayList<Pair> MST = new ArrayList<>() ;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(Edge -> Edge.weight)) ;

        for(String vertex : adjacencyList.keySet())
        {
            visited.put(vertex,false) ;
        }

        pq.add(new Edge(startVertex,0)) ;
        int sum = 0;
        while(!pq.isEmpty())
        {
            Edge curEdge = pq.poll() ;
            String curVertex = curEdge.vertex ;

            if(visited.get(curEdge.vertex))
            {
                continue ;
            }

            visited.put(curEdge.vertex,true) ;


            if(parent.containsKey(curEdge.vertex))
            {
                MST.add(new Pair(parent.get(curEdge.vertex),curEdge.vertex)) ;
                sum += curEdge.weight ;
            }

            for(Edge edges : adjacencyList.get(curVertex))
            {
                if(!visited.get(edges.vertex))
                {
                    pq.add(edges) ;
                    parent.put(edges.vertex,curVertex) ;
                }
            }


        }
    }


}
