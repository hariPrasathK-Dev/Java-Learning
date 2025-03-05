import java.util.* ;

public class binaryTree 
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
    int size = 0 ;

    public void buildTree(int [] arr)
    {
        if(arr.length == 0)
        {
            return ;
        }

        ArrayList<Node> node = new ArrayList<>() ;
        node.add(null) ;
        for(int i = 0;i<arr.length;i++)
        {
            if(arr[i] != -1)
            {
                Node tempNode = new Node(arr[i]) ;
                node.add(tempNode) ;
                if(i != 0)
                {
                    int parentIndex = ((i-1)/2)+1 ;
                    Node parentNode = node.get(parentIndex) ;
                    tempNode.parent = parentNode ;

                    if(i%2 == 1)
                    {
                        parentNode.leftChild = tempNode ;
                    }
                    else
                    {
                        parentNode.rightChild = tempNode ;
                    }
                }
            }
            else
            {
                node.add(null) ;
            }
        }

        root = node.get(1) ;
        size = node.size() - 1 ;

    }

    /*public Integer findElementParent(int value) {
        Node parent = findElementParentHelper(root, value);
        return parent != null ? parent.data : null;
    }

    // Helper method to recursively find the parent of a node
    private Node findElementParentHelper(Node current, int targetValue) {

        if (current == null) {
            return null;
        }

        if ((current.leftChild != null && current.leftChild.data == targetValue) ||
            (current.rightChild != null && current.rightChild.data == targetValue)) {
            return current;
        }

        Node leftResult = findElementParentHelper(current.leftChild, targetValue);
        if (leftResult != null) {
            return leftResult;
        }

        return findElementParentHelper(current.rightChild, targetValue);
    } */

    public void findParent(Node curNode)
    {
        if(curNode != null)
        {
            if(curNode.leftChild != null || curNode.rightChild != null)
            {
                System.out.println("Parent node : "+curNode.data);
                System.out.println("Child Nodes : "+curNode.leftChild.data+"  "+curNode.rightChild.data);
            }
            findParent(curNode.leftChild);
            findParent(curNode.rightChild);
        }
    }

    public void elementsParent(Node curNode,int value)
    {
        if(curNode != null)
        {
            if(curNode.leftChild != null || curNode.rightChild != null)
            {
                if(curNode.leftChild.data == value || curNode.rightChild.data == value)
                {
                    System.out.println("The parent Node of the given Node : "+curNode.data);
                    return ;
                }
    
                elementsParent(curNode.leftChild, value) ;
                elementsParent(curNode.rightChild, value) ;
            }
        }
    }

    public int findDepth(Node curNode,int value)
    {
        return depthCalculator(curNode,value,0) ;
    }

    public int depthCalculator(Node curNode,int val,int curHeight)
    {
        if(curNode == null)
        {
            return -1 ;
        }
        if(curNode.data == val)
        {
            return curHeight ;
        }

        int leftHeight = depthCalculator(curNode.leftChild,val,curHeight+1) ;

        if(leftHeight != -1)
        {
            return leftHeight ;
        }
        return depthCalculator(curNode.rightChild, val, curHeight+1) ;

    }

    public int findHeight(int value)
    {
        Node node = findNode(root,value) ;
        if(node != null)
        {
            return calculateHeight(node) ;
        }
        return -1 ;
    }

    public Node findNode(Node curNode,int val)
    {
        if(curNode == null)
        {
            return null ;
        }

        if(curNode.data == val)
        {
            return curNode ;
        }

        Node leftNode = findNode(curNode.leftChild,val) ;
        if(leftNode != null)
        {
            return leftNode ;
        }

        return findNode(curNode.rightChild,val) ;
    }

    public int calculateHeight(Node node)
    {
        if(node == null)
        {
            return -1 ;
        }
        int leftHeight = calculateHeight(node.leftChild) ;
        int rightHeight = calculateHeight(node.rightChild) ;

        return (Math.max(leftHeight,rightHeight)+1) ;
    }

    public void inOrderTraversal(Node curNode) {
        if (curNode != null) {
            inOrderTraversal(curNode.leftChild);
            System.out.print(curNode.data + "  ");
            inOrderTraversal(curNode.rightChild);
        }
    }

    public void preOrderTraversal(Node curNode) {
        if (curNode != null) {
            System.out.print(curNode.data + "  ");
            preOrderTraversal(curNode.leftChild);
            preOrderTraversal(curNode.rightChild);
        }
    }

    public void postOrderTraversal(Node curNode) {
        if (curNode != null) {
            postOrderTraversal(curNode.leftChild);
            postOrderTraversal(curNode.rightChild);
            System.out.print(curNode.data + "  ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7,8,9,10,11,12,13};

        binaryTree b = new binaryTree();
        b.buildTree(arr);

        System.out.println();
        // b.inOrderTraversal(b.root);
        // System.out.println();
        // b.preOrderTraversal(b.root);
        // System.out.println();
        // b.postOrderTraversal(b.root);

        // Find the parent of node with value 5
        //b.elementsParent(b.root,1);
        System.out.println("The depth of the Node element 10 : "+b.findDepth(b.root,10));
        System.out.println("The height of the binary tree : "+b.findHeight(1));
    }
}