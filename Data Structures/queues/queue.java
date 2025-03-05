public class queue
{
    node head ;

    public void enqueue(int data)
    {
        node n = new node() ;
        n.data = data ;
        if(head == null)
        {
            head = n ;
        }
        else
        {
            node no = head ;
            while(no.next != null)
            {
                no = no.next ;
            }
            no.next = n ;
        }
    }

    public void dequeue()
    {
        if(head == null)
        {
            System.out.println("Queue is empty!Cannot perform dequeue operation");
        }
        else
        {   
            node no = head ;
            head = no.next ;
            System.out.println("Value to be dequeued : "+no.data);
            no = null ;
        }
    }

    public int front()
    {
        if(head != null)
        {
            return head.data ;
        }
        else
        {
            return -1 ;
        }
    }

    public boolean isEmpty()
    {
        return head == null ;
    }

    public int size()
    {
        node no = head ;
        int count = 0 ;
        while(no != null)
        {
            no = no.next ;
            count++ ;
        }
        return count ;
    }

}