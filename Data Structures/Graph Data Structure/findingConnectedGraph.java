import java.util.LinkedList ;


public class findingConnectedGraph 
{
    boolean [] visited ;
    LinkedList<Integer> [] adjList ;

    public findingConnectedGraph(int vertices)
    {
        visited = new boolean[vertices] ;
        adjList = new LinkedList[vertices] ;

        for(int i=0;i<vertices;i++)
        {
            adjList[i] = new LinkedList<>() ;
        }
    }

    public void addEdge(int u,int v)
    {
        //FOr an undirected Graph : 
        adjList[u].add(v) ;
        adjList[v].add(u) ;
    }

    public void DFS(int u)
    {
        visited[u] = true ;

        for(int i : adjList[u])
        {
            if(!visited[i])
            {
                visited[i] = true ;
                DFS(i) ;
            }
        }
    }

    public void isConnected()
    {
        DFS(0) ;

        for(boolean bool : visited)
        {
            if(!bool)
            {
                System.out.println("The graph is not a connected Graph!");
                return ;
            }
        }
        System.out.println("The graph is a connected graph!");
    }

    public static void main(String[] args) {
        findingConnectedGraph fG = new findingConnectedGraph(6) ;

        fG.addEdge(0, 1);
        fG.addEdge(0, 2);
        fG.addEdge(1, 3);
        fG.addEdge(3, 4);
        //fG.addEdge(4, 5);

        fG.isConnected();
    }
    
}
