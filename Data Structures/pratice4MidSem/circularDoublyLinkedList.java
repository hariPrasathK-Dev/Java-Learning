public class circularDoublyLinkedList 
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
        head.prev = tail ;
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
            node.prev = tail ;
            tail = node ;
        }
        head.prev = tail ;
        tail.next = head ;
        size ++ ;
    }

    public void insertAt(int data,int index)
    {
        if(index == 0)
        {
            insertFirst(data);
        }
        else if(index == size)
        {
            insertLast(data);
        }
        else
        {
            Node node = new Node() ;
            node.data = data ;
            Node n = head ;
            for(int i = 0;i<index-1;i++)
            {
                n = n.next ;
            }
            Node temp = n.next ;
            n.next = node ;
            node.prev = n ;
            node.next = temp ;
            temp.prev = node ;
            size++ ;
        }
    }

    public int removeFirst()
    {
        if(head != null)
        {
            int temp = head.data ;
            head = head.next ;
            if(head == null)
            {
                tail = null ;
            }
            else
            {
                head.prev = tail ;
                tail.next = head ;
            }
            size-- ;
            return temp ;
        }
        return -1 ;
    }
    
    public int removeLast()
    {
        if(tail != null)
        {
            int temp = tail.data ;
            tail = tail.prev ;
            if(tail == null)
            {
                head = null ;
            }
            else
            {
                head.prev = tail ;
                tail.next = head ;
            }
            size-- ;
            return temp ;
        }
        return -1 ;
    }

    public void removeAt(int index)
    {
        if(index == 0)
        {
            removeFirst() ;
        }
        else if(index == size-1)
        {
            removeLast() ;
        }
        else
        {
            Node n = head ;
           for(int i=0;i<index-1;i++)
           {
                n = n.next ;
           }
           Node temp = n.next ;
           n.next = temp.next ;
           temp.next.prev = n ;
        }
    }

    public void show()
    {
        Node n = head ;
        do
        {
            System.out.print(n.data+"  ");
            n = n.next ;
        }while(n != head) ;
        System.out.println();
    }

    public void showReverse()
    {
        Node n = tail ;
        do
        {
            System.out.print(n.data+"  ");
            n = n.prev ;
        }while(n != tail) ;
        System.out.println();
    }
    private class Node
    {
        int data ;
        Node next;
        Node prev ;
    }

    public static void main(String [] args)
    {
        circularDoublyLinkedList dll = new circularDoublyLinkedList() ;
        
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
