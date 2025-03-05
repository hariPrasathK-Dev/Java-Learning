public class binarySearchTree
{
     
    private class Node
    {
        int data ;
        Node leftChild ;
        Node rightChild ;

        public Node(int data)
        {
            this.data = data ;
        }
    } 

    Node root ;

    public void insert(int data)
    {
        root = insertRec(root,data) ;
    }

    public Node insertRec(Node n,int data)
    {
        if(n == null)
        {
            n = new Node(data) ;
            return n ;
        }

        if(data < n.data)
        {
            n.leftChild = insertRec(n.leftChild, data) ;
        }
        else if(data > n.data)
        {
            n.rightChild = insertRec(n.rightChild, data) ;
        }

        return n ;
    }

    public void preOrderTraversal()
    {
        preOrderRec(root);
    }

    public void preOrderRec(Node root)
    {
        if(root != null)
        {
            System.out.print(root.data+"  ");
            preOrderRec(root.leftChild);
            preOrderRec(root.rightChild);
        }
    }

    public void inOrder()
    {
        inOrderRec(root) ;
    }

    public void inOrderRec(Node root)
    {
        if(root != null)
        {
            inOrderRec(root.leftChild);
            System.out.print(root.data+"  ");
            inOrderRec(root.rightChild); 
        }
    }

    public void postOrder()
    {
        postOrderRec(root) ;
    }

    public void postOrderRec(Node root)
    {
        if(root != null)
        {
            postOrderRec(root.leftChild);
            postOrderRec(root.rightChild);
            System.out.print(root.data+"  ");
        }
    }
}
