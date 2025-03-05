public class doublyLinkedList 
{
    Node head,tail ;
    int size = 0;

    public void insertFirst(int data)
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
            node.next = head ;
            head.prev = node ;
            head = node ;
        }
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
            node.prev = tail ;
            tail = node ;
        }
        size++ ;
    }

    public void insertAt(int data,int index)
    {
        if(index == 0)
        {
            insertFirst(data) ;
        }
        else if(index == size)
        {
            insertLast(data) ;
        }
        else
        {
            Node node = new Node() ;
            node.data = data ;
            Node n = head ;
            for(int i=0;i<index-1;i++)
            {
                n = n.next ;
            }
            Node temp = n.next ;
            n.next = node ;
            node.prev = n ;
            node.next = temp ;
            temp.prev = node ;
        }
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
            int tempVal = head.data ;
            head = head.next ;
            if(head == null)
            {
                tail = null ;
            }
            else
            {
                head.prev = null ;
            }
            size-- ;
            return tempVal ;
        }
        return -1 ;
    }

    public int removeLast()
    {
        if(tail != null)
        {
            int tempVal = tail.data ;
            tail = tail.prev ;
            if(tail == null)
            {
                head = null ;
            }
            else
            {
                tail.next = null ;
            }
            size-- ;
            return tempVal ;
        }
        return -1 ;
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

    public void showReverse()
    {
        Node n = tail ;
        while(n != null)
        {
            System.out.print(n.data+"  ");
            n = n.prev ;
        }
        System.out.println();
    }

    private class Node
    {
        int data ;
        Node prev ;
        Node next ;
    }

    public static void main(String [] args)
    {
        doublyLinkedList dll = new doublyLinkedList() ;
        
        dll.insertFirst(4) ;
        dll.insertFirst(2) ;
        dll.insertLast(6) ;
        dll.insertLast(5) ;
        dll.insertLast(1) ;
        dll.insertAt(3,2) ;
        dll.show() ;
        dll.showReverse() ;
    }
}
