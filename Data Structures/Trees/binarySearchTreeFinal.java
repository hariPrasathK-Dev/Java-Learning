public class binarySearchTreeFinal
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

    Node root = null ;

    public void insert(int data)
    {
        root = insertValue(root,data);
    }

    public Node insertValue(Node curNode,int data)
    {
        if(curNode == null)
        {
            Node nodeBuild = new Node(data) ;
            return nodeBuild;
        }

        else if(data < curNode.data)
        {
            curNode.leftChild = insertValue(curNode.leftChild,data);
        }

        else if(data > curNode.data)
        {
            curNode.rightChild = insertValue(curNode.rightChild, data);
        }
        return curNode ; 
    }

    public void preOrderTraversal(Node curNode)
    {
        if(curNode != null)
        {
            System.out.print(curNode.data+"  ");
            preOrderTraversal(curNode.leftChild);
            preOrderTraversal(curNode.rightChild);
        }
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

    public Node search(Node curNode,int data)
    {
        if(curNode == null || curNode.data == data)
        {
            return curNode ;
        }

        if(curNode.data > data)
        {
            return search(curNode.leftChild,data) ;
        }

        return search(curNode.rightChild, data) ;
    }

    public int findminimum(Node curNode)
    {
        if(curNode == null)
        {
            return -1 ;
        }

        else if(curNode.leftChild == null)
        {
            return curNode.data ;
        }
        else 
        {
            int min = findminimum(curNode.leftChild) ;
            return min ;
        } 
    }

    public int findMaximum(Node curNode)
    {
        if(curNode == null) return -1 ;

        else if(curNode.rightChild == null) return curNode.data ;

        else 
        {
            int max = findMaximum(curNode.rightChild) ;
            return max ;
        }
    }

    public int findHeight(Node curNode,int data)
    {
        if(curNode == null)
        {
            return -1; 
        }
        
        if(curNode.data == data)
        {
            return findNodeHeight(curNode) ;
        }
        
        if(curNode.data > data)
        {
            int leftHeight = findHeight(curNode.leftChild, data) ;
            return leftHeight ;
        }
        
        return findHeight(curNode.rightChild, data) ;
    }
    private int findNodeHeight(Node curNode) 
    {
        if(curNode == null)
        {
            return -1 ;
        }
        int leftHeight = findNodeHeight(curNode.leftChild) ;
        int rightHeight = findNodeHeight(curNode.rightChild) ;

        return Math.max(leftHeight, rightHeight)+1 ;
    }

    public Node deleteNode(Node curNode,int data)
    {
        if(curNode == null) return null ;

        if(data < curNode.data) 
        {
            curNode.leftChild = deleteNode(curNode.leftChild, data) ;
        }
        else if(data > curNode.data)
        {
           curNode.rightChild = deleteNode(curNode.rightChild, data) ;
        }
        else
        {
            //Case1 : No children
            if(curNode.leftChild == null && curNode.rightChild == null)
            {
                return null ;
            }
            //Case2 : One Child
            else if(curNode.rightChild == null)
            {
                return curNode.leftChild ;
            }
            else if(curNode.leftChild == null)
            {
                return curNode.rightChild ;
            }
            //Case3 : two Children
            Node minNode = findMin(curNode.rightChild) ;
            curNode.data = minNode.data ;
            curNode.rightChild = deleteNode(curNode.rightChild,minNode.data) ;
        } 
        return curNode ;
    }

    private Node findMin(Node curNode)
    {
        while(curNode.leftChild != null)
        {
            curNode = curNode.leftChild ;
        }
        return curNode ;
    }
    public static void main(String [] args)
    {
        binarySearchTreeFinal BSTF = new binarySearchTreeFinal() ;
        BSTF.insert(4);
        BSTF.insert(7) ;
        BSTF.insert(5) ;
        BSTF.insert(6) ;
        BSTF.insert(3) ;
        BSTF.insert(1) ;
        BSTF.insert(2) ;

       // BSTF.preOrderTraversal(BSTF.root);
        //System.out.println();
        BSTF.inOrderTraversal(BSTF.root);
        System.out.println();

        Node n = BSTF.search(BSTF.root,7) ;
        if(n != null)
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }

        System.out.println(BSTF.findminimum(BSTF.root));
        System.out.println(BSTF.findMaximum(BSTF.root)); 
        System.out.println("The height of the given binary search tree : "+BSTF.findHeight(BSTF.root, 4));
        BSTF.deleteNode(BSTF.root, 7) ;
        BSTF.inOrderTraversal(BSTF.root);
    }
}
