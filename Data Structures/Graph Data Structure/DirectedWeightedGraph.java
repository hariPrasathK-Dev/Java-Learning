import java.util.* ;

public class DirectedWeightedGraph 
{
    HashMap<String,ArrayList<Pair<String,Integer>>> adjacencyListOutgoing ;
    HashMap<String,ArrayList<Pair<String,Integer>>> adjacencyListIncoming ;

    public DirectedWeightedGraph()
    {
        adjacencyListOutgoing = new HashMap<>() ;
        adjacencyListIncoming = new HashMap<>() ;
    }

    public void addVertex(String vertex)
    {
        adjacencyListOutgoing.putIfAbsent(vertex,new ArrayList<>()) ;
        adjacencyListIncoming.putIfAbsent(vertex,new ArrayList<>()) ;
    }

    public void addEdge(String source,String destination,int weight,boolean isDirected)
    {
        addVertex(source) ;
        addVertex(destination) ;

        adjacencyListOutgoing.get(source).add(new Pair<>(destination,weight)) ;
        adjacencyListIncoming.get(destination).add(new Pair<>(source,weight)) ;

        if(!isDirected)
        {
            adjacencyListOutgoing.get(destination).add(new Pair<>(source,weight)) ;
            adjacencyListIncoming.get(source).add(new Pair<>(destination,weight)) ;
        }
    }

    public void removeVertex(String vertex)
    {
        if(adjacencyListOutgoing.containsKey(vertex) && adjacencyListIncoming.containsKey(vertex))
        {
            adjacencyListOutgoing.remove(vertex) ;
            adjacencyListIncoming.remove(vertex) ;

            for(String neighbor : adjacencyListOutgoing.keySet())
            {
                adjacencyListOutgoing.get(neighbor).removeIf(Pair -> Pair.getKey().equals(vertex)) ;
            }

            for(String neighbor : adjacencyListIncoming.keySet())
            {
                adjacencyListIncoming.get(neighbor).removeIf(Pair -> Pair.getKey().equals(vertex)) ;
            }
        }
    }

    public boolean isEdge(String vertex1, String vertex2) {
        if (adjacencyListOutgoing.containsKey(vertex1)) {
            for (Pair<String,Integer> pair : adjacencyListOutgoing.get(vertex1)) {
                if (pair.getKey().equals(vertex2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void removeEdge(String vertex1, String vertex2, boolean isDirected) {
        if (isEdge(vertex1, vertex2)) {
            Iterator<Pair<String,Integer>> iterate = adjacencyListOutgoing.get(vertex1).listIterator() ;
            while(iterate.hasNext())
            {
                Pair<String,Integer> pair= iterate.next() ;
                String vertex = pair.getKey() ;
                if(vertex.equals(vertex2))
                {
                    iterate.remove();
                }
            }

            Iterator<Pair<String,Integer>> iterate2 = adjacencyListIncoming.get(vertex2).listIterator() ;
            while(iterate2.hasNext())
            {
                Pair<String,Integer> pair= iterate2.next() ;
                String vertex = pair.getKey() ;
                if(vertex.equals(vertex1))
                {
                    iterate2.remove();
                }
            }

            if (!isDirected) {
                adjacencyListOutgoing.get(vertex2).removeIf(Pair ->Pair.getKey().equals(vertex2));
                adjacencyListIncoming.get(vertex1).removeIf(Pair ->Pair.getKey().equals(vertex2));
            }
        }
    }

    public ArrayList<String> allVertex() {
        return new ArrayList<>(adjacencyListOutgoing.keySet());
    }

    public int countVertex() {
        return adjacencyListOutgoing.size();
    }

    public void allEdge() {
        System.out.println("Outgoing Edges:");
        for (String key : adjacencyListOutgoing.keySet()) {
            System.out.println(key + " -> " + adjacencyListOutgoing.get(key));
        }

        System.out.println("Incoming Edges:");
        for (String key : adjacencyListIncoming.keySet()) {
            System.out.println(key + " -> " + adjacencyListIncoming.get(key));
        }
    }

    public void countEdges() {
        int countOutgoing = 0, countIncoming = 0;

        for (ArrayList<Pair<String,Integer>> edges : adjacencyListOutgoing.values()) {
            countOutgoing += edges.size();
        }
        for (ArrayList<Pair<String,Integer>> edges : adjacencyListIncoming.values()) {
            countIncoming += edges.size();
        }

        System.out.println("Outgoing Edges: " + countOutgoing);
        System.out.println("Incoming Edges: " + countIncoming);
    }

    public static void main(String[] args) {
        DirectedWeightedGraph graph = new DirectedWeightedGraph() ;
        graph.addEdge("A", "B", 10, true);
        graph.addEdge("B", "C", 20, true);
        graph.addEdge("C", "D", 30, true);
        graph.addEdge("D","A",40,true) ;

        System.out.println("Total Number of Vertices : "+graph.countVertex());
        graph.countEdges();

        System.out.println("Vertices : "+graph.allVertex());
        graph.allEdge();

        graph.removeEdge("A","B",true);
        System.out.println("After the removalOf the Edge A -> B : ");

        System.out.println("Total Number of Vertices : "+graph.countVertex());
        graph.countEdges();

        System.out.println("Vertices : "+graph.allVertex());
        graph.allEdge();

        graph.removeVertex("B");
        System.out.println("After the removal of the Vertex B : ");

        System.out.println("Total Number of Vertices : "+graph.countVertex());
        graph.countEdges();

        System.out.println("Vertices : "+graph.allVertex());
        graph.allEdge();

        //System.out.println("Outgoing: " + graph.adjacencyListOutgoing);
        //System.out.println("Incoming: " + graph.adjacencyListIncoming);
    }
}