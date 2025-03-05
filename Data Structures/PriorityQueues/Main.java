import java.util.ArrayList ;

public class Main 
{
    public static void main(String[] args) throws Exception
    {
        Heap heap = new Heap() ;
        ArrayList<Integer> a ;

        heap.insert(13,'A') ;
        heap.insert(10,'O') ;
        heap.insert(27,'H') ;
        heap.insert(6,'R') ;
        heap.insert(5,'P') ;
        heap.insert(22,'V') ;

       /* System.out.println(heap.findHeight());
        System.out.println("No of internal nodes : "+heap.inner());
        System.out.println("No of external nodes : "+heap.leaf());
        System.out.println("Depth of the sixth element : "+heap.findDepth(5));
        //heap.heapSort() ;
        System.out.println("Item removed : "+heap.remove());
        System.out.println("Item removed : "+heap.remove());
        System.out.println("Item removed : "+heap.remove());
        //a = heap.heapSort() ;
        //System.out.println(a); */

        ArrayList<Tuple> arr = heap.heapSort() ;
        for(Tuple tuple : arr)
        {
            System.out.println("("+tuple.getPriority()+","+tuple.getValue()+")");
        }
        
    }
    
}
