public class runner 
{
    public static void main(String[] args) 
    {
      /*  queue q = new queue() ;

        q.enqueue(3) ;
        q.enqueue(4) ;
        q.enqueue(1) ;

        q.dequeue() ;
        q.dequeue() ;

        System.out.println("Value at the beginning : "+q.front()); ;

        System.out.println("Empty : "+q.isEmpty()); 

        q.dequeue(); 

        System.out.println("Size of the queue : "+q.size()); */

        queueArr qArr = new queueArr() ;

        qArr.enqueue(3);
        qArr.enqueue(4);
        qArr.enqueue(1);
        qArr.enqueue(5);
        qArr.enqueue(6);

        qArr.dequeue() ;
        qArr.dequeue() ;

        qArr.enqueue(2);
        qArr.enqueue(9);
        qArr.enqueue(7);

        qArr.show() ;

        System.out.println();
        System.out.println("First element : "+qArr.Front());

    }
    
}
