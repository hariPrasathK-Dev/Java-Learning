public class AVLTree
{
    private class Node
    {
        int data ;
        int height ;
        Node leftChild ;
        Node rightChild ;

        public Node(int data)
        {
            this.data = data ;
            this.leftChild = this.rightChild = null ;
            this.height = 0 ;
        }
    }

    Node root = null ;

    public int height(Node curNode)
    {
        if(curNode == null)
        {
            return -1 ;
        }
        return curNode.height ;
    }

    public int getbalance(Node curNode)
    {
        if (curNode == null)
        {
            return 0 ;
        }

        return height(curNode.leftChild) - height(curNode.rightChild) ;
    }

    public Node leftRotate(Node x)
    {
        Node y = x.rightChild ;
        Node temp = y.leftChild ;

        y.leftChild = x ;
        x.rightChild = temp ;

        x.height = Math.max(height(x.leftChild),height(x.rightChild)) + 1 ;
        y.height = Math.max(height(y.leftChild),height(y.rightChild)) + 1 ;

        return y ;
    }

    public Node rightRotate(Node y)
    {
        Node x = y.leftChild ;
        Node temp = x.rightChild ;

        x.rightChild = y ;
        y.leftChild = temp ;

        x.height = Math.max(height(x.leftChild),height(x.rightChild)) + 1 ;
        y.height = Math.max(height(y.leftChild),height(y.rightChild)) + 1 ;

        return x ;
    }

    public void insertValue(int data)
    {
        root = insertNode(data, root) ;
    }

    public Node insertNode(int data,Node curNode)
    {
        if(curNode == null)
        {
            return new Node(data) ;
        }

        if(data <= curNode.data)
        {
            curNode.leftChild = insertNode(data, curNode.leftChild) ;
        }
        else if(data > curNode.data)
        {
            curNode.rightChild = insertNode(data, curNode.rightChild) ;
        }

        curNode.height = Math.max(height(curNode.leftChild),height(curNode.rightChild))+1 ;

        int balance = getbalance(curNode) ;

        if(balance < -1 && data > curNode.rightChild.data)
        {
            return leftRotate(curNode) ;
        }

        else if(balance < -1 && data < curNode.rightChild.data)
        {
            curNode.rightChild = rightRotate(curNode.rightChild) ;
            return leftRotate(curNode) ;
        }

        else if(balance > 1 && data < curNode.leftChild.data)
        {
            return rightRotate(curNode) ;
        }

        else if(balance > 1 && data > curNode.leftChild.data)
        {
            curNode.leftChild = leftRotate(curNode.leftChild) ;
            return rightRotate(curNode) ;
        }

        return curNode ;
    }

    public void deleteValue(int data)
    {
        root = deleteNode(data, root) ;
    }

    public Node deleteNode(int data,Node curNode)
    {
        if(curNode == null) return null ;

        if(curNode.data > data)
        {
            curNode.leftChild = deleteNode(data, curNode.leftChild) ;
        }
        else if(data > curNode.data)
        {
            curNode.rightChild = deleteNode(data, curNode.rightChild) ;
        }

        else
        {
            if(curNode.leftChild == null && curNode.rightChild == null)
            {
                return null ;
            }
            if(curNode.leftChild == null)
            {
                return curNode.rightChild ;
            }
            else if(curNode.rightChild == null)
            {
                return curNode.leftChild ;
            }
            else
            {
                int minValue = findMin(curNode.rightChild) ;
                curNode.data = minValue ;
                curNode.rightChild = deleteNode(minValue, curNode.rightChild) ;
            }
        }

        curNode.height = Math.max(height(curNode.leftChild),height(curNode.rightChild))+1 ;

        int balance = getbalance(curNode) ;

        if(balance < -1 && getbalance(curNode.rightChild)<=0)
        {
            return leftRotate(curNode) ;
        }

        else if(balance < -1 && getbalance(curNode.rightChild)>0)
        {
            curNode.rightChild = rightRotate(curNode.rightChild) ;
            return leftRotate(curNode) ;
        }

        else if(balance > 1 && getbalance(curNode.leftChild)>=0)
        {
            return rightRotate(curNode) ;
        }

        else if(balance > 1 && getbalance(curNode.leftChild)<0)
        {
            curNode.leftChild = leftRotate(curNode.leftChild) ;
            return rightRotate(curNode) ;
        }

        return curNode ;
    }

    public int findMin(Node curNode)
    {
        while(curNode.leftChild != null)
        {
            curNode = curNode.leftChild ;
        }
        return curNode.data ;
    }

    public void inorderTravesal(Node curNode)
    {
        if(curNode != null)
        {
            inorderTravesal(curNode.leftChild);
            System.out.print(curNode.data+"  ");
            inorderTravesal(curNode.rightChild);
        }
    }

    public static void main(String [] args)
    {
        AVLTree avl = new AVLTree() ;
        
        avl.insertValue(6) ;
        avl.insertValue(5);
        avl.insertValue(2);
        avl.insertValue(3);
        avl.insertValue(4);
        avl.insertValue(1);

        avl.inorderTravesal(avl.root);

        avl.deleteValue(1) ;
        System.out.println();
        
        avl.inorderTravesal(avl.root);
        System.out.println();

        System.out.println(avl.height(avl.root));
        System.out.println(avl.getbalance(avl.root));
    }
}