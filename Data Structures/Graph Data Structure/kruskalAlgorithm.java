import java.util.* ;


public class kruskalAlgorithm 
{
    private class Edge implements Comparable<Edge>
    {
        String source ;
        String destination ;
        int weight ;

        public Edge(String source,String destiantion,int weight)
        {
            this.source = source ;
            this.destination = destiantion ;
            this.weight = weight ;
        }

        @Override
        public String toString()
        {
            return "("+source+","+destination+","+weight+")" ;
        }

        @Override
        public int compareTo(Edge other)
        {
            return Integer.compare(this.weight,other.weight) ;
        }

    }

    HashMap<String,String> parent = new HashMap<>() ;
    HashMap<String,Integer> rank = new HashMap<>() ;
    ArrayList<Edge> edges = new ArrayList<>() ;

    public void addEdge(String source,String destination,int weight)
    {
        edges.add(new Edge(source,destination,weight)) ;

        parent.putIfAbsent(source,source) ;
        parent.putIfAbsent(destination,destination) ;
        
        rank.putIfAbsent(source,0) ;
        rank.putIfAbsent(destination,0) ;
    }

    public String findUltimateParent(String vertex) //Finding the Ultimate parent along with path compression
    {
        if(!parent.get(vertex).equals(vertex))
        {
            parent.put(vertex,findUltimateParent(parent.get(vertex))) ;
        }
        return parent.get(vertex) ;
    }
    
    public void Union(String vertex1,String vertex2)
    {
        String ultimateParent1 = findUltimateParent(vertex1) ;
        String ultimateParent2 = findUltimateParent(vertex2) ;

        if(!ultimateParent1.equals(ultimateParent2))
        {
            if(rank.get(ultimateParent1) > rank.get(ultimateParent2))
            {
                parent.put(ultimateParent2,ultimateParent1) ;
            }
            else if(rank.get(ultimateParent2) > rank.get(ultimateParent1))
            {
                parent.put(ultimateParent1,ultimateParent2) ;
            }
            else
            {
                parent.put(ultimateParent2,ultimateParent1) ;
                rank.put(ultimateParent1,rank.get(ultimateParent1)+1) ; 
            }
        }
    }

    public void kAlgorithm()
    {
        Collections.sort(edges) ;//Sorting the edges array based on the edge weight from lowest to highest

        ArrayList<Edge> MST = new ArrayList<>() ;
        int sum = 0;

        for(Edge edge : edges)
        {
            if(findUltimateParent(edge.source).equals(findUltimateParent(edge.destination)))
            {
                continue ;
            }

            Union(edge.source,edge.destination) ;
            MST.add(edge) ;
            sum += edge.weight ;
        }

        System.out.println("Minimum Spanning Tree : "+MST);
        System.out.println("Total Weight : "+sum);
    }

    public static void main(String[] args) {
        kruskalAlgorithm graph = new kruskalAlgorithm();

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 3);
         graph.addEdge("B", "C", 1);
         graph.addEdge("B", "D", 4);
         graph.addEdge("C", "D", 2);
         

        /*graph.addEdge("A", "C", 1);
        graph.addEdge("A", "B", 2);
        graph.addEdge("C", "B", 1);
        graph.addEdge("C", "D", 2);
        graph.addEdge("C", "E", 2);
        graph.addEdge("D", "E", 1); */

        graph.kAlgorithm();
    }
}