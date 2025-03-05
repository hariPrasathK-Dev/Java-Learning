 public class circularSinglyLinkedList 
{
    Node head,tail ;
    int size = 0 ;

    public void insertFirst(int data)
    {
        Node node = new Node() ;
        node.data = data ;

        if(head == null)
        {
            tail = node ;
        }
        node.next = head ;
        head = node ;
        tail.next = head ;
        size++ ;
    }

    public void insertLast(int data)
    {
        Node node = new Node() ;
        node.data = data ;

        if(head == null)
        {
            head = node ;
            tail = node ;
        }
        else
        {
            tail.next = node ;
            tail = node ;
        }
        tail.next = head ;
        size++ ;
    }

    public int first()
    {
        if(head != null)
        {
            return head.data ;
        }
        return -1 ;
    }

    public int last()
    {
        if(tail != null)
        {
            return tail.data ;
        }
        return -1 ;
    }

    public int removeFirst()
    {
        if(head != null)
        {
            int tempVar = head.data ;
            head = head.next ;
            if(head == null)
            {
                tail = null ;
            }
            else
            {
                tail.next = head ;
            }
            size-- ;
            return tempVar ;
        }
        return -1 ;
    }

    public void rotate()
    {
        if(tail != null)
        {
            head = head.next ;
            tail = tail.next ;
        }
    }

    public void show()
    {
        Node n = head ;
        do
        {
            System.out.print(n.data+"  ");
            n = n.next ;
        }while(n != head ) ;
        System.out.println();        
    }
    
    private class Node
    {
        int data ;
        Node next ;
    }

    public static void main(String[] args) {
        circularSinglyLinkedList csll = new circularSinglyLinkedList() ;
        csll.insertFirst(3);
        csll.insertFirst(4);
        csll.insertFirst(2);
        csll.insertLast(6);
        csll.insertLast(5);
        csll.insertLast(1);

        csll.show(); 

        csll.rotate() ;
        csll.rotate();
        csll.show() ;

    }
}
