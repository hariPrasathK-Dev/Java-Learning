public class singlyLinkedList 
{
    Node head ;

    public void insertAtFirst(int data)
    {
        Node node = new Node(data) ;
        node.next = head ;
        head = node ;
    }


    public void insertAt(int data,int index)
    {
        if(index==0)
        {
            insertAtFirst(data);
        }
        else
        {
            Node node = new Node(data) ;
            Node n = head ;

            for(int i = 0;i<index-1;i++)
            {
                n = n.next ;
            }
            node.next = n.next ;
            n.next = node ;
        }
    }

    public void insertAtLast(int data)
    {
        Node node = new Node(data) ;

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
        }
    }

    public void deleteAt(int index)
    {
        Node n =head ;
        if(n==null)
        {
            System.out.println("The list is empty to be deleted.");
        }
        else
        {
            for(int i=0;i<index-1;i++)
            {
                n = n.next ;
            }
            Node temp = n.next ;
            n.next = temp.next ;
            temp = null ;
        }
    }

    public void show()
    {
        Node n =head ;
        while(n != null)
        {
            System.out.print(n.data+"  ");
            n=  n.next ;
        }
        System.out.println();
    }

    private class Node
    {
        int data ;
        Node next ;

        public Node(int data)
        {
            this.data = data ;
        }
    }    
}
