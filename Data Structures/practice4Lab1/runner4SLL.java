public class runner4SLL
{
    public static void main(String[] args)
    {
        singlyLinkedList sll = new singlyLinkedList() ;
        sll.insertAtFirst(5);
        sll.insertAt(6,1);
        sll.insertAtLast(3);
        sll.show() ;

        sll.deleteAt(2) ;
        sll.show() ;
    }
}