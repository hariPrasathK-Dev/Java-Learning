public class warehouseStack 
{
    Node head ;

    public void insert(int data)
    {
        Node node = new Node() ;
        node.data = data ;
        node.next = null ;

        if(head!=null)
        {
            node.next = head ;
        }
        head = node ;
    }

    public int pop()
    {
        Node n = head ;
        if(head!=null)
        {
            if(n.next!=null)
            {
                head = n.next ;
            }
            else
            {
                head = null ;
            }
            return n.data ;
        }
        else
        {
            return 0 ;
        }
    }

    

}
