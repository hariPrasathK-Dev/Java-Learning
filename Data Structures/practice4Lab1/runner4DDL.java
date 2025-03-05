public class runner4DDL 
{
    public static void main(String[] args) {
        doublyLinkedList dll = new doublyLinkedList() ;

        dll.insertFirst(5);
        dll.insertAt(6,1);
        dll.insertLast(3);
        dll.insertAt(4,3);
        dll.insertLast(2);
        dll.insertAt(1,5);
        dll.show() ;

        dll.deleteAt(0);
        dll.deleteAt(3) ;
        dll.deleteAt(3) ;

        dll.show() ;
    }
    
}
