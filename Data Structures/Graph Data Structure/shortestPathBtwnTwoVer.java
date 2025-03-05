import java.util.* ;
public class shortestPathBtwnTwoVer 
{
    HashMap<String,ArrayList<String>> adjacencyList ;
    HashSet<String> visited ;

    public shortestPathBtwnTwoVer()
    {
        adjacencyList = new HashMap<>() ;
        visited = new HashSet<>() ;
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

    public ArrayList<Pair<String,Integer>> findShortestPathBFS(String source,String destination)
    {
        ArrayList<Pair<String,Integer>> path = new ArrayList<>() ;
        if(!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination))
        {
            return null ;
        }

        visited.add(source) ;
        
        Queue<Pair<String,Integer>> queue = new LinkedList<>() ;
        queue.add(new Pair(source,0)) ;

        while(!queue.isEmpty())
        {
            Pair<String,Integer> node = queue.poll() ;
            path.add(node) ;
            String vertex = node.getKey() ;
            int distance = node.getValue() ;

            if(vertex.equals(destination))
            {
                return path ;
            }

            for(String neighbor : adjacencyList.get(vertex))
            {
                if(!visited.contains(neighbor))
                {
                    visited.add(neighbor) ;
                    queue.add(new Pair(neighbor,distance+1)) ;
                    distance++ ;
                }
            }
        }
        return null ;
    }

    public static void main(String[] args) {
        shortestPathBtwnTwoVer sPBTV = new shortestPathBtwnTwoVer() ;
        sPBTV.addVertex("A");
        sPBTV.addVertex("B");
        sPBTV.addEdge("A","B");
        sPBTV.addVertex("C");
        sPBTV.addVertex("D");
        sPBTV.addEdge("A","C");
        sPBTV.addEdge("C","D");

        System.out.println("The Shortest Path is : "+sPBTV.findShortestPathBFS("A","D")) ;
    }
    
}
