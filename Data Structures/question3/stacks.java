public class stacks 
{
    node4stack head ;
    int n = 0 ;
    public void size(int s)
    {
        n = s ;
    }

    public void push(String data)
    {
            node4stack node = new node4stack() ;
            node.data = data ;

            if(head != null)
            {
                node.next = head ;
            }
            head = node ;
    }

    public void showValue()
    {
        node4stack n = head ;
        while(n != null)
        {
            System.out.println(n.data);
            n = n.next ;
        }
    }
}
