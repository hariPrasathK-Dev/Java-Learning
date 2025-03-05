public class doublyLinkedList 
{
    Node head ;

    public void insertFirst(int data)
    {
        Node node = new Node() ;
        node.data = data ;

        if(head != null)
        {
            node.next = head ;
            head.prev = node ;
        }
        head = node ;
    }

    public void insertAt(int data,int index)
    {
        if(index==0)
        {
            insertFirst(data);
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
            node.next = temp ;
            node.prev = n ;
            n.next = node ;
            if(temp != null)
            {
                temp.prev = node ;
            }
        }
    }

    public void insertLast(int data)
    {
        Node node = new Node() ;
        node.data = data ;

        if(head==null)
        {
            head = node ;
        }
        else
        {
            Node n = head ;
            while(n.next != null)
            {
                n = n.next ;
            }
            n.next = node ;
            node.prev = n ;
        }
    }

    public void deleteAt(int index)
    {
        if(index==0)
        {
            Node temp = head ;
            head = temp.next ;
            head.prev = null ;
            temp = null ;
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
            if(temp.next != null)
            {
                temp.next.prev = n ;
            }
        }
    }

    public void show()
    {
        Node n = head ;
        Node last = null;
        while(n != null)
        {
            System.out.print(n.data+" --> ");
            last = n ;
            n = n.next ;
        }
        System.out.println("End");

        while(last != null)
        {
            System.out.print(last.data+" <-- ");
            last = last.prev ;
        }
        System.out.println("Start");
    }
    private class Node
    {
        int data ;
        Node next ;
        Node prev ;
    }
    
}
