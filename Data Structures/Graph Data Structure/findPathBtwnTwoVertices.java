import java.util.LinkedList ;
import java.util.ArrayList ;
import java.util.Arrays;

public class findPathBtwnTwoVertices 
{
        LinkedList<Integer> [] adjacencyList ;
        boolean [] visited ;

        public findPathBtwnTwoVertices(int vertices)
        {
            adjacencyList = new LinkedList[vertices] ;
            visited = new boolean[vertices] ;

            for(int i=0;i<vertices;i++)
            {
                adjacencyList[i] = new LinkedList<>() ;
            }
        }

        public void addEdge(int source,int destination)
        {
            adjacencyList[source].add(destination) ;
            adjacencyList[destination].add(source) ;
        }

        public boolean DFSFORPATH(int source,int destination,ArrayList<Integer> path)
        {
            visited[source] = true ;

            if(source == destination)
            {
                return true ;
            }

            path.add(source) ;

            for(int vertex : adjacencyList[source])
            {
                if(!visited[vertex])
                {
                    if(DFSFORPATH(vertex, destination, path))
                    {
                        return true ;
                    }
                }
            }

            path.remove(path.size()-1) ;
            return false ;
        }

        public void findPath(int source,int destination)
        {
            Arrays.fill(visited,false) ;
            ArrayList<Integer> Path = new ArrayList<>() ;

            if(DFSFORPATH(source, destination,Path))
            {
                System.out.println("Path from "+source+" to "+destination+" : "+Path);
            }
            else
            {
                System.out.println("No Path Exists Between "+source+" and "+destination);
            }
        }

        public static void main(String[] args) {
            findPathBtwnTwoVertices fPath = new findPathBtwnTwoVertices(6) ;

            fPath.addEdge(0,1) ;
            fPath.addEdge(0,2) ;
            fPath.addEdge(1,3) ;
            fPath.addEdge(2,3) ;
            fPath.addEdge(3,4) ;
            fPath.addEdge(4,5) ;

            int source = 0 ;
            int destination = 5 ;

            fPath.findPath(source,destination) ;
            fPath.findPath(0,6) ;
        }
}
