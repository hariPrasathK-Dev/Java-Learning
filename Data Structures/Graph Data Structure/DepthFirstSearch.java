import java.util.* ;

public class DepthFirstSearch 
{
    private LinkedList<Integer> adjList[] ;
    private boolean visited[] ;

    public DepthFirstSearch(int vertices)
    {
        adjList = new LinkedList[vertices] ;
        visited = new boolean[vertices] ;

        for (int i = 0; i < vertices; i++) 
        {
            adjList[i] = new LinkedList<Integer>(); // Initialize each linked list
        }
    }

    public void addEdge(int u , int v)
    {
        adjList[u].add(v) ;
        adjList[v].add(u) ;
    }

    void DFS(int u)
    {
        visited[u] = true ;
        System.out.print(u+"  ");

        Iterator<Integer> iterate = adjList[u].listIterator() ;

        while(iterate.hasNext())
        {
            int adjacentVertex = iterate.next() ;
            if(!visited[adjacentVertex])
            {
                DFS(adjacentVertex) ;
            }
        }
    }

    public static void main(String [] args)
    {
        DepthFirstSearch G = new DepthFirstSearch(4) ;

        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 2);
        G.addEdge(2, 3);
        
        G.DFS(2);
    }
}
