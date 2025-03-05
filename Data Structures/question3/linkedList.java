import java.util.* ;

public class linkedList
{
    Scanner obj = new Scanner(System.in) ;
    Node head ;

    public void insert(int size,String name)
    {
        Node node = new Node() ;
       // node.sInsert(size);
        node.next = null ;
        node.name = name ; 

        for(int i=1;i<=size;i++)
        {
            System.out.println("Enter the "+name+ "\'s item value "+i+" : ");
            node.data.push(obj.nextLine());
        }  

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

    public void show()
    {
        Node n = head ;
        int nodeCount = 1 ;
        while(n != null)
        {
            System.out.println("Node "+nodeCount+" Stack Values :");
            n.data.showValue();
            n = n.next ;
            nodeCount++ ;
        }
    } 

   /* public void remove(String name,int num)
    {
        Node n = head ;
        while(n != null)
        {
            if(n.name == name)
            {
                break ;
            }
            n = n.next ;
        }
        n.data.remove(num) ;
    } */

   /* public void view_No(String name)
    {
        Node n = head ;
        while(n != null)
        {
            if(n.name == name)
            {
                break ;
            }
            n = n.next ;
        }
        n.data.viewNo() ;
    } */
    
}
