public class avlPractice 
{
    private class Node
    {
        int data ;
        int height ;
        Node leftChid ;
        Node rightChild ;

        public Node(int data)
        {
            this.data = data ;
            this.leftChid = this.rightChild = null ;
            this.height = 0 ;
        }
    }

    Node root = null ;

    public int getHeight(Node curNode)
    {
        if(curNode == null)
        {
            return -1 ;
        }
        return curNode.height ;
    }

    public int getBalance(Node curNode)
    {
        if(curNode == null)
        {
            return 0 ;
        }
        return (getHeight(curNode.leftChid)-getHeight(curNode.rightChild)) ;
    }

    public Node leftRotate(Node x)
    {
        Node y = x.rightChild ;
        Node temp = y.leftChid ;

        y.leftChid = x ;
        x.rightChild = temp ;

        x.height = Math.max(getHeight(x.leftChid),getHeight(x.rightChild))+1 ;
        y.height = Math.max(getHeight(y.leftChid),getHeight(y.rightChild))+1 ;

        return y ;
    }

    public Node rightRotate(Node y)
    {
        Node x = y.leftChid ;
        Node temp = x.rightChild ;

        x.rightChild = y ;
        y.leftChid = temp ;

        x.height = Math.max(getHeight(x.leftChid),getHeight(x.rightChild))+1 ;
        y.height = Math.max(getHeight(y.leftChid),getHeight(y.rightChild))+1 ;
        
        return x ;
    }

    public void insertValue(int data)
    {
        root = insertNode(data,root) ;
    }

    public Node insertNode(int data,Node curNode)
    {
        if(curNode == null)
        {
            return new Node(data) ;
        }

        if(data <= curNode.data)
        {
            curNode.leftChid = insertNode(data, curNode.leftChid) ;
        }
        else if(data > curNode.data)
        {
            curNode.rightChild = insertNode(data, curNode.rightChild) ;
        }

        curNode.height = Math.max(getHeight(curNode.leftChid),getHeight(curNode.rightChild))+1 ;

        int balance = getBalance(curNode) ;
        if(balance<-1 && data>curNode.rightChild.data)
        {
            return leftRotate(curNode) ;
        }
        else if(balance<-1 && data<curNode.rightChild.data)
        {
            curNode.rightChild = rightRotate(curNode.rightChild) ;
            return leftRotate(curNode) ;
        }
        else if(balance > 1 && data < curNode.leftChid.data)
        {
            return rightRotate(curNode) ;
        }
        else if(balance > 1 && data>curNode.leftChid.data)
        {
            curNode.leftChid = leftRotate(curNode.leftChid) ;
            return rightRotate(curNode) ;
        }
        return curNode ;
    }

    public void deleteValue(int data)
    {
        root = deleteNode(data,root) ;
    }

    public Node deleteNode(int data,Node curNode)
    {
        if(curNode == null)
        {
            return null ;
        }

        if(data < curNode.data)
        {
            curNode.leftChid = deleteNode(data, curNode.leftChid) ;
        }
        else if(data > curNode.data)
        {
            curNode.rightChild = deleteNode(data, curNode.rightChild) ;
        }

        else
        {
            if(curNode.leftChid == null && curNode.rightChild == null)
            {
                return null ;
            }
            else if(curNode.leftChid == null)
            {
                return curNode.rightChild ;
            }
            else if(curNode.rightChild == null)
            {
                return curNode.leftChid ;
            }
            else
            {
                int minValue = findMinValue(curNode.rightChild) ;
                curNode.data = minValue ;
                curNode.rightChild = deleteNode(minValue, curNode.rightChild) ;
            }
        }

        curNode.height = Math.max(getHeight(curNode.leftChid),getHeight(curNode.rightChild))+1;

        int balance = getBalance(curNode) ;
        if(balance<-1 && getBalance(curNode.rightChild)<=0)
        {
            return leftRotate(curNode) ;
        }
        else if(balance<-1 && getBalance(curNode.rightChild)>0)
        {
            curNode.rightChild = rightRotate(curNode.rightChild) ;
            return leftRotate(curNode);
        }
        else if(balance>1 && getBalance(curNode.leftChid)>=0)
        {
            return rightRotate(curNode) ;
        }
        else if(balance>1 && getBalance(curNode.leftChid)<0)
        {
            curNode.leftChid = leftRotate(curNode.leftChid) ;
            return rightRotate(curNode) ;
        }
        return curNode ;
    }

    public int findMinValue(Node curNode)
    {
        while(curNode.leftChid != null)
        {
            curNode = curNode.leftChid ;
        }
        return curNode.data ;
    }

    public void inOrderTraversal(Node curNode)
    {
        if(curNode != null)
        {
            inOrderTraversal(curNode.leftChid);
            System.out.print(curNode.data+" ");
            inOrderTraversal(curNode.rightChild);
        }
    }
    public static void main(String[] args) {
        avlPractice avl = new avlPractice() ;
        
        avl.insertValue(6) ;
        avl.insertValue(5);
        avl.insertValue(2);
        avl.insertValue(3);
        avl.insertValue(4);
        avl.insertValue(1);

        avl.inOrderTraversal(avl.root);

        avl.deleteValue(1) ;
        System.out.println();
        
        avl.inOrderTraversal(avl.root);
        System.out.println();

        System.out.println(avl.getHeight(avl.root));
        System.out.println(avl.getBalance(avl.root));
    }
    
}
