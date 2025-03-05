import java.util.* ;

public class stack
{

    Scanner obj = new Scanner(System.in) ;
    Node head ;

    private class Node
    {
        String title ;
        istack data = new istack() ;
        Node next ;
    }

    public void insert(String name,int num)
    {
        Node node = new Node() ;
        node.title = name ;
        node.next = null ;
        node.data.sizeArr(num) ;
        for(int i = 1;i<=num;i++)
        {
            System.out.println("Enter the "+name+" \'s item value "+i+" : ");
            node.data.insert(obj.nextLine()) ;
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

    public void remove(String name,int num)
    {
        Node n =head ;
        while(n != null)
        {
            if(n.title.equals(name))
            {
                break ;
            }
            n = n.next ;
        }
        n.data.remove(num) ;
    }

    public void show(String name)
    {
        Node n = head ;
        while(n != null)
        {
            if(n.title .equals(name))
            {
                break ;
            }
            n = n.next ;
        }
        if(n!=null)
        {
            n.data.show() ;
        }
        else
        {
            System.out.println("The specified item type is not present.");
        }
    }
}