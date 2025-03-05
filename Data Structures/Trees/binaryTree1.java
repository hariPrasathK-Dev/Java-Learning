import java.util.ArrayList ;

public class binaryTree1 
{
    private class Node 
    {
        int data ;
        Node parent ;
        Node leftChild ;
        Node rightChild ;

        public Node(int data)
        {
            this.data = data ;
        }
    }

    Node root ;
    int size ;

    public void buildTree(int [] arr)
    {
        if(arr.length == 0)
        {
            return ;
        }

        ArrayList<Node> node = new ArrayList<>() ;
        node.add(null) ;

        for(int i=0;i<arr.length;i++)
        {
            Node tempnode = new Node(arr[i]) ;
            node.add(tempnode) ;
            if(i != 0)
            {
                if(arr[i] != -1)
                {
                    int parentIndex = ((i-1)/2)+1 ;
                    Node parentNode = node.get(parentIndex) ;

                    if(parentNode != null)
                    {
                        tempnode.parent = parentNode ;

                        if(i%2 == 1)
                        {
                            parentNode.leftChild = tempnode ;
                        }
                        else
                        {
                            parentNode.rightChild = tempnode ;
                        }

                    }
                }
                else
                {
                    node.add(null) ;
                }
            }
        }
        root  = node.get(1) ;
        size = node.size() - 1 ;
    }

    public void inOrderTraversal(Node curNode)
    {
        if(curNode != null)
        {
            inOrderTraversal(curNode.leftChild);
            System.out.print(curNode.data+"  ");
            inOrderTraversal(curNode.rightChild);
        }
    }

    public void preOrderTraversal(Node curNode)
    {
        if(curNode != null)
        {
            System.out.print(curNode.data+"  ");
            inOrderTraversal(curNode.leftChild);
            inOrderTraversal(curNode.rightChild);
        }
    }

    public void postOrderTraversal(Node curNode)
    {
        if(curNode != null)
        {
            postOrderTraversal(curNode.leftChild);
            postOrderTraversal(curNode.rightChild);
            System.out.print(curNode.data+"  ");
        }
    }

   

    public static void main(String [] args)
    {
        binaryTree1 b1 = new binaryTree1() ;

        int [] a = {1,2,3,4,5,6,7} ;
        b1.buildTree(a);

        b1.inOrderTraversal(b1.root);
        System.out.println();

        b1.preOrderTraversal(b1.root);
        System.out.println();

        b1.postOrderTraversal(b1.root);
        System.out.println();
    }
    
}
