public class singlyLinkedList
{
    Node head ; 
    Node tail ;
    int size = 0 ;
    public void insertFirst(int data)
    {
        Node node = new Node() ;
        node.data = data ;

        if(head == null)
        {
            tail = node; 
        }
        node.next = head ;
        head = node ;
        size++ ;
    }

    public void insertLast(int data)
    {
        Node node = new Node() ;
        node.data = data ;

        if(head == null)
        {
            head = node ;
            tail = node; 
        }
        else
        {
            tail.next = node ;
            tail = node ;
        }
        size++ ;
    }

    public int first()
    {
        if(head !=null)
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
            size-- ;
            return tempVar ;
        
        }
        
        return -1 ;
    }

    public int Size()
    {
        return size ;
    }

    public boolean isEmpty()
    {
        return size==0 ;
    }

    public void sort()
    {
        Node current,suffix ;
        current = head ;
        while(current != null)
        {
            suffix = current.next ;
            while(suffix != null)
            {
                if(current.data > suffix.data)
                {
                    int tempVal = current.data ;
                    current.data = suffix.data ;
                    suffix.data = tempVal ;
                }
                suffix = suffix.next ;
            }
            current  =current.next ;
        }
    }

    public void show()
    {
        Node n = head ;
        while(n != null)
        {
            System.out.print(n.data+"  ");
            n = n.next ;
        }
        System.out.println();
    }

    private  class Node
    {
        int data ;
        Node next ;
    }


    public static void main(String[] args) 
    {
        singlyLinkedList sll = new singlyLinkedList() ;
        sll.insertFirst(5);
        sll.insertLast(3);
        sll.insertFirst(4);
        sll.insertFirst(2);
        sll.insertLast(6);
        sll.insertLast(1);

        System.out.println("First element : "+sll.first());
        System.out.println("Last element : "+sll.last());
        sll.removeFirst() ;
        System.out.println("First element : "+sll.first());
        System.out.println("Size : "+sll.size);
        sll.removeFirst() ;
        sll.show();
        sll.sort() ;
        sll.show();

    }
}