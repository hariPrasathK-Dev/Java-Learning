import java.util.HashMap ;
import java.util.ArrayList ;
import java.util.Arrays;
import java.util.HashSet ;
import java.util.Scanner ;

public class GraphUsingHashMap 
{
    HashMap<String,ArrayList<String>> adjacencyList ;
    HashSet<String> visited ;

    public GraphUsingHashMap(ArrayList<String> vertices)
    {
        adjacencyList = new HashMap<>() ;
        visited = new HashSet<>() ;

        for(String vertex : vertices)
        {
            adjacencyList.put(vertex,new ArrayList<>()) ;
        }
    }

    public void addEdge(String source,String destination)
    {
        adjacencyList.get(source).add(destination) ;
        adjacencyList.get(destination).add(source) ;
    }

    public boolean findPath(String source,String destination,ArrayList<String> Path)
    {
        visited.add(source) ;

        if(source.equals(destination))
        {
            return true ;
        }

        Path.add(source) ;

        for(String vertex : adjacencyList.get(source))
        {
            if(!visited.contains(vertex))
            {
                if(findPath(vertex,destination,Path))
                {
                    return true ;
                } 
            }
        }
        Path.remove(Path.size()-1) ;
        return false ;
    }

    public void PATHDFS(String source,String destination)
    {
        visited.clear() ;
        ArrayList<String> Path = new ArrayList<>() ;

        if(findPath(source,destination,Path))
        {
            System.out.println("Path exists between the given set of source and destination.");
            Path.add(destination) ;
            System.out.println("Path : "+Path);
        }
        else
        {
            System.out.println("No Path exists between the given source and destination");
        }
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in) ;
        ArrayList<String> vertices = new ArrayList<>() ;
        System.out.println("Enter the number of vertices : ");
        int n = obj.nextInt() ;
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the Vertex "+(i+1));
            vertices.add(obj.next()) ;
        }
        GraphUsingHashMap grpHM = new GraphUsingHashMap(vertices) ;
        grpHM.addEdge("A","B");
        grpHM.addEdge("A","C");
        grpHM.addEdge("B","C");
        grpHM.addEdge("B","D");
        grpHM.addEdge("C","E");
        grpHM.addEdge("D","E");
        grpHM.addEdge("D","F");
        grpHM.addEdge("E","F");

        grpHM.PATHDFS("A","E");
    }
}
