import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator ;

public class BreadthFirstSearch 
{
    private LinkedList<Integer> adjList[] ;
    private boolean visited[] ;
    
    public BreadthFirstSearch(int vertices)
    {
        adjList = new LinkedList[vertices] ;
        visited = new boolean[vertices] ;

        for(int i=0;i<vertices;i++)
        {
            adjList[i] = new LinkedList<>() ;
        }
    }

    void addEdge(int u,int v)
    {
        adjList[u].add(v) ;
        adjList[v].add(u) ;
    }

    void BFS(int u)
    {
        visited[u] = true ;

        Queue<Integer> queue = new LinkedList<>() ;
        queue.add(u) ;

        while(!queue.isEmpty())
        {
            int curVertex = queue.poll() ;
            System.out.print(curVertex+"  ");

            //Iterator<Integer> iterate = adjList[curVertex].listIterator() ;

            
           /*while(iterate.hasNext())
            {
                int vertex = iterate.next() ;
                if(!visited[vertex])
                {
                    visited[vertex] = true ;
                    queue.add(vertex) ;
                }
            } */

            //OR

            for(int i : adjList[curVertex])
            {
                if(!visited[i])
                {
                    visited[i] = true ;
                    queue.add(i) ;
                }
            }
        }
    }

    public static void main(String [] args)
    {
        BreadthFirstSearch G = new BreadthFirstSearch(6) ;

        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0,3);
        G.addEdge(1,4);
        G.addEdge(3,5);
        
        G.BFS(0);
    }
}
