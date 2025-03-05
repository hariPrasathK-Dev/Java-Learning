import java.util.Scanner ;

public class AdjacencyMatrix
{
    private boolean[][] adjacentMatrix ;
    private int  numVertices ;                                                                                                                                                                                                                                                                                               

    public AdjacencyMatrix(int numVertices)
    {
        this.numVertices = numVertices ;
        adjacentMatrix = new boolean[numVertices][numVertices] ;
    }

    public void addEdge(int v1,int v2)
    {
        adjacentMatrix[v1][v2] = true ;
        adjacentMatrix[v2][v1] = true ;
    }

    public void displayMatrix()
    {
        for(int i=0;i<numVertices ;i++)
        {
            for(int j=0;j<numVertices;j++)
            {
                System.out.print(adjacentMatrix[i][j]? "1 " : "0 ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) 
    {
        Scanner obj = new Scanner(System.in) ;

        System.out.println("Enter the number of the vertices : ");
        int numVertices = obj.nextInt() ;

        AdjacencyMatrix adm1 = new AdjacencyMatrix(numVertices) ;

        System.out.println("Enter the number of edges : ");
        int numEdges = obj.nextInt() ;

        System.out.println("Enter the edges(format : \"From\" -> \"To\") : ");
        for(int i=0;i<numEdges;i++)
        {
            int from = obj.nextInt() ;
            int to = obj.nextInt() ;
            adm1.addEdge(from, to);
        }

        System.out.println("Adjacency Matrix : ");
        adm1.displayMatrix(); 

        obj.close() ;
    }
}