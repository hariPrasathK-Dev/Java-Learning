public class circularSLL 
{
    Node head ;
    Node tail ;

    public void insertAtFirst(int data)
    {
        Node node = new Node() ;
        node.data = data ;

        if(head == null)
        {
            head = node ;
            tail = node ;
            node.next = head ;
        }
        else
        {
            node.next = head ;
            head = node ;
            tail.next = node ;
        }
        
    }

    public void insertAtLast(int data)
    {      
        Node node = new Node() ;
        node.data = data ;

        if(head == null)
        {
            head = node ;
            tail = node ;
            node.next = head ;
        }
        else
        {
            tail.next = node;
            node.next = head ;
            tail = node ;
        }

    }

    public void insertAt(int data,int index)
    {
        if(index == 0)
        {
            insertAtFirst(data);
        }
        else
        {
            Node n = head ;
            for(int i=0;i<index-1;i++)
            {
                n = n.next ;
            }
            if(n == tail)
            {
                insertAtLast(data);
            }
            else
            {
                Node node = new Node() ;
                node.data = data ;
                node.next = n.next ;
                n.next = node ;
            }
        }
    }

    public void deleteAt(int index)
    {
        if(index == 0)
        {
            Node temp = head ;
            head = temp.next ;
            tail.next = head ;
            temp = null ;
        }
        else
        {
            Node n = head ;
            for(int i=0;i<index-1;i++)
            {
                n = n.next ;
            }
            if(n.next == tail)
            {
                tail = n ;
                tail.next = head ;
            }
            else
            {
                Node temp = n.next ;
                n.next = temp.next ;
                temp = null ;
            }
        }

    }
    
    public void show()
    {
        Node n = head ;
        do
        {
            System.out.print(n.data+" --> ");
            n = n.next  ;
        }while(n != head) ;
        System.out.println("End");
    }
    private class Node
    {
        int data ;
        Node next ;
    }
}
