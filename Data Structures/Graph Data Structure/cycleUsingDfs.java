import java.util.* ;

public class cycleUsingDfs 
{
    HashMap<String,ArrayList<String>> adjacencyList ;


    public cycleUsingDfs()
    {
        adjacencyList = new HashMap<>() ;
    }

    public void addVertex(String vertex)
    {
        adjacencyList.put(vertex,new ArrayList<>()) ;
    }

    public void addEdge(String source,String destination)
    {
        adjacencyList.get(source).add(destination) ;
        adjacencyList.get(destination).add(source) ;
    }



    public boolean detectCycle(String vertex,String parent,HashSet<String> visited,ArrayList<String> path)
    {
        visited.add(vertex) ;
        path.add(vertex) ;
        for(String curVertex : adjacencyList.get(vertex))
        {
            if(!visited.contains(curVertex))
            {
                if(detectCycle(curVertex, vertex, visited, path))
                {
                    return true ;
                }
            }

            if(!parent.equals(curVertex))
            {
                path.add(curVertex) ;
                return true ;
            }
        }

        path.remove(path.size()-1) ;
        return false ;
    }

    public void cycleDetection()
    {
        HashSet<String> visited = new HashSet<>();
        ArrayList<String> path = new ArrayList<>();

        for(String vertex : adjacencyList.keySet())
        {
            if(!visited.contains(vertex))
            {
                if(detectCycle(vertex,"0",visited,path))
                {
                    System.out.println("The graph contains a cycle!");
                    String repeat = path.get(path.size()-1) ;
                    int i = 0 ;
                    for(String values : path)
                    {
                        if(values.equals(repeat))
                        {
                            break ;
                        }
                        i++ ;
                    }
                    System.out.println("Cycle : "+path.subList(i,path.size()));
                }
            }
        }
    }


    public static void main(String [] args)
    {
        cycleUsingDfs cycle = new cycleUsingDfs() ;
        cycle.addVertex("A");
        cycle.addVertex("B");
        cycle.addVertex("C");
        cycle.addVertex("D");
        cycle.addVertex("E");

        cycle.addEdge("A","B");
        cycle.addEdge("B","C");
        cycle.addEdge("C","D");
        cycle.addEdge("D","E");
        cycle.addEdge("E","B");

        cycle.cycleDetection();
    }

}
