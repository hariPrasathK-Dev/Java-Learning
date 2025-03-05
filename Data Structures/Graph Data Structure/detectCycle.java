import java.util.LinkedList ;
import java.util.Iterator ;
import java.util.ArrayList ;

public class detectCycle {
    
    int vertices ;
    LinkedList<Integer> [] adjacencyList ;

    public void addEdge(int source,int destination)
    {
        adjacencyList[source].add(destination) ;
        adjacencyList[destination].add(source) ;
    }
    public detectCycle(int vertices)
    {
        this.vertices = vertices ;
        adjacencyList = new LinkedList[vertices] ;

        for(int i=0;i<vertices;i++)
        {
            adjacencyList[i] = new LinkedList<>() ;
        }
    }

    public boolean hasCyclesDFS(int node,int parent , boolean [] visited,ArrayList<Integer> path)
    {
        visited[node] = true ;
        path.add(node) ;
        Iterator<Integer> iterate = adjacencyList[node].listIterator() ;
        
        while(iterate.hasNext())
        {
            int neighbor = iterate.next() ;
            if(!visited[neighbor])
            {
                if(hasCyclesDFS(neighbor, node, visited,path))
                {
                    return true ;
                }
            }

            else if(neighbor != parent)
            {
                path.add(neighbor) ;
                return true ;
            }
        }
        path.remove(path.size()-1) ;
        return false ;
    }

    public void hasCycles()
    {
        boolean [] visited = new boolean[vertices] ;
        ArrayList<Integer> path = new ArrayList<>() ;

        for(int i=0;i<vertices;i++)
        {
            if(!visited[i])
            {
                if(hasCyclesDFS(i, -1, visited,path))
                {
                    System.out.println("Cycle is detected in the Graph");
                    int startInd = path.indexOf(path.get(path.size()-1)) ;
                    System.out.println("Cycle Path : "+path.subList(startInd,path.size()));
                    return ;
                }
            }
        }
        System.out.println("Cycle is not detected in the Graph") ;
    }

    public static void main(String[] args) {
        detectCycle dtcyl = new detectCycle(5) ;

        dtcyl.addEdge(0,1) ;
        dtcyl.addEdge(1,2) ;
        dtcyl.addEdge(2,3) ;
        dtcyl.addEdge(3,4) ;
        dtcyl.addEdge(4,1) ;

        dtcyl.hasCycles();
    }
}
