import java.util.* ;

public class bstUsingHashmap 
{
        HashMap<String,ArrayList<String>> adjacencyList ;
        HashSet<String> visited ;

        public bstUsingHashmap()
        {
            adjacencyList = new HashMap<>() ;
            visited = new HashSet<>() ;

        }

        public void addEdge(String source,String destination)
        {
            adjacencyList.putIfAbsent(source, new ArrayList<>()) ;
            adjacencyList.putIfAbsent(destination,new ArrayList<>()) ;

            adjacencyList.get(source).add(destination) ;
            adjacencyList.get(destination).add(source) ;
            
        }

        public void BST(String vertex)
        {
            visited.add(vertex) ;

            Queue<String> queue = new LinkedList<>() ;
            queue.add(vertex) ;

            while(!queue.isEmpty())
            {
                String curVertex = queue.poll() ;
                System.out.print(curVertex+" ");

                for(String vert : adjacencyList.get(curVertex))
                {
                    if(!visited.contains(vert))
                    {
                        queue.add(vert) ;
                        visited.add(vert) ;
                    }
                }
            }
        }   

        public static void main(String[] args) {
            bstUsingHashmap bst = new bstUsingHashmap() ;

            bst.addEdge("A","B");
            bst.addEdge("A","C");
            bst.addEdge("B","C");
            bst.addEdge("B","D");
            bst.addEdge("C","E");
            bst.addEdge("D","E");
            bst.addEdge("D","F");
            bst.addEdge("E","F");

            bst.BST("A") ;
        }

}
