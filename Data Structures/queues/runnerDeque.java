public class runnerDeque 
{
    public static void main(String [] args)
    {
        deque obj = new deque() ;

        obj.enqueueFirst(6) ;
        obj.enqueueFirst(5) ;
        obj.enqueueLast(4);
        obj.enqueueLast(3);

        
        System.out.printf("\nEmpty : %s",obj.isEmpty());
        System.out.printf("\nSize : %d",obj.size());
        obj.show();
    
        obj.dequeueLast();
        obj.dequeueFirst();

        System.out.printf("\nEmpty : %s",obj.isEmpty());
        System.out.printf("\nSize : %d",obj.size());

        obj.dequeueFirst();
        obj.dequeueFirst();

        System.out.printf("\nFront Element : %d",obj.front());
        System.out.printf("\nLast Element : %d",obj.last());
        obj.dequeueLast();

        obj.show() ;
    }
    
}
