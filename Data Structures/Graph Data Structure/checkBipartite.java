import java.util.* ;

public class checkBipartite 
{
    HashMap<String,ArrayList<String>> adjacencyList ;
    HashSet<String> visited ;

    public checkBipartite()
    {
        adjacencyList = new HashMap<>() ;
        visited = new HashSet<>() ;
    }

    public void addVertex(String vertex) 
    {
        adjacencyList.put(vertex,new ArrayList<>()) ;
    }

    public void addEdge(String source , String destination)
    {
        adjacencyList.get(source).add(destination) ;
        adjacencyList.get(destination).add(source) ;
    }

    public boolean bipartiteNess()
    {
        HashMap<String,Integer> colorMap = new HashMap<>() ;
        Queue<String> queue = new LinkedList<>() ;

        for(String startVertex : adjacencyList.keySet())
        {
            if(!colorMap.containsKey(startVertex))
            {
                colorMap.put(startVertex,0) ;

                queue.add(startVertex) ;

                while(!queue.isEmpty())
                {
                    String vertex = queue.poll() ;
                    int currentColor = colorMap.get(vertex) ;

                    for(String neighbor : adjacencyList.get(vertex))
                    {
                        if(!colorMap.containsKey(neighbor))
                        {
                            colorMap.put(neighbor,1-currentColor) ;
                            queue.add(neighbor) ;
                        }

                        else if(colorMap.get(neighbor) == currentColor)
                        {
                            return false ;
                        }
                    }
                }
            }
        }

        return true ;
    }

    public static void main(String [] args)
    {
        checkBipartite cBPT = new checkBipartite() ;

        cBPT.addVertex("A");
        cBPT.addVertex("B");
        cBPT.addVertex("C");
        cBPT.addVertex("D");
        cBPT.addEdge("A", "B");
        cBPT.addEdge("B", "C");
        cBPT.addEdge("C", "D");
        cBPT.addEdge("D", "A");
        //cBPT.addEdge("A","C") ;

        System.out.println("Is the Graph bipartite? " + (cBPT.bipartiteNess() ? "YES" : "No"));
    }
    
}
