import java.util.Scanner;
import java.util.ArrayList ;
import java.util.Queue;
import java.util.LinkedList;
public class binaryTreeFinal<T>
{
    private  class Node
    {
        T data ;
        Node parent ;
        Node leftChild ;
        Node rightChild ;

        public Node(T data)
        {
            this.data = data ;
        }
    }


    Node root ;
    int size = 0 ;
    ArrayList<Node> n= new ArrayList<>() ;
    

    public void buildTree(T arr[])
    {
        if(arr.length == 0) return ;

        n.add(null) ;
        for(int i=0;i<arr.length;i++)
        {
            
            Node node = new Node(arr[i]) ;
            n.add(node) ;

            if(i != 0)
            {
                int parentIndex = ((i-1)/2)+1 ;
                Node parentNode = n.get(parentIndex) ;
                node.parent = parentNode ;
                if(i%2 == 1)
                {
                    parentNode.leftChild = node ;
                }
                else
                {
                    parentNode.rightChild = node ;
                }
            }
        }

        root = n.get(1) ;
        size = n.size() - 1 ;
    }

    public void preOrderTraversal(Node curInd)
    {
        if(curInd != null)
        {
            System.out.print(curInd.data+"  ");
            preOrderTraversal(curInd.leftChild);
            preOrderTraversal(curInd.rightChild);
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

    public void postOrderTraversal(Node curNode)
    {
        if(curNode != null)
        {
            postOrderTraversal(curNode.leftChild);
            postOrderTraversal(curNode.rightChild);
            System.out.print(curNode.data+"  ");
        }
    }

    public int findHeight(Node curNode,T value)
    {
        if(curNode == null) return -1 ;

        if(curNode.data.equals(value))
        {
            return findNodeHeight(curNode) ;
        }
        int leftHeight = findHeight(curNode.leftChild,value) ;
        if(leftHeight != -1) return leftHeight ;

        return findHeight(curNode.rightChild, value) ;
    }

    private int findNodeHeight(Node curNode)
    {
        if(curNode == null) return -1 ;

        int leftHeight = findNodeHeight(curNode.leftChild) ;
        int rightHeight = findNodeHeight(curNode.rightChild) ;

        return Math.max(leftHeight,rightHeight) + 1 ;
    }

    public int findDepth(Node curNode,T value)
    {
        return findNodeDepth(curNode,value,0) ;
    }

    private int findNodeDepth(Node curNode,T value,int depth)
    {
        if(curNode == null) return -1 ;

        if(curNode.data.equals(value)) return depth ;

        int leftDepth = findNodeDepth(curNode.leftChild, value, depth+1) ;
        if(leftDepth != -1) return leftDepth ;

        return findNodeDepth(curNode.rightChild, value, depth+1) ;
    }

    /*public int findDistance(Node curNode,T value1,T value2)
    {
        if(curNode == null) return -1 ;

        if(curNode.data.equals(value1)) return findNodeDistance(curNode,value1,value2,0) ;

        int leftDistance = findDistance(curNode.leftChild, value1, value2) ;
        if(leftDistance != -1) return leftDistance ;

        return findDistance(curNode.rightChild, value1, value2) ;
    }   

    private int findNodeDistance(Node curNode,T value1,T value2,int distance)
    {
        if(curNode == null) return -1 ;

        if(curNode.data.equals(value2)) return distance ;

        int leftDistance = findNodeDistance(curNode.leftChild, value1, value2, distance+1) ;
        if(leftDistance != -1) return leftDistance ;

        return findNodeDistance(curNode.rightChild, value1, value2,distance+1) ;
    } */

    public void addElement(Node curNode,T value) // Can be used for the Level Order traversal
    {
        size++ ;
        if(curNode == null)
        {
            root = new Node(value) ;
            return ;
        }

        Queue<Node> queue = new LinkedList<>() ; //LinkedList class implements the Queue interface.
        queue.add(curNode) ;
        System.out.print(curNode.data+"  ");
        while(!queue.isEmpty())
        {
            Node current = queue.poll() ;

            if(current.leftChild == null)
            {
                current.leftChild = new Node(value) ;
                return ;
            }
            else if(current.rightChild == null)
            {
                current.rightChild = new Node(value) ;
                return  ;
            }
            else
            {
                System.out.print(current.leftChild.data+"  ");
                System.out.print(current.leftChild.data+"  ");
                queue.add(current.leftChild) ;
                queue.add(current.rightChild) ;
            }
            
        }
    }

    public boolean isSymmetric(Node curNode)
    {
        if(curNode == null)
        {
            return true ;
        }
        return isMirror(curNode.leftChild,curNode.rightChild) ;
    }

    public boolean isMirror(Node leftNode,Node rightNode)
    {
        if(leftNode == null && rightNode == null)
        {
            return true ;
        }
        if(leftNode == null || rightNode == null)
        {
            return false ;
        }

        if(leftNode.data.equals(rightNode.data))
        {
           /* boolean val1 =  isMirror(leftNode.leftChild, rightNode.rightChild) ;
            boolean val2 = isMirror(leftNode.rightChild, rightNode.leftChild) ;
            return val1 && val2 ; */
            return isMirror(leftNode.leftChild,rightNode.rightChild) && isMirror(leftNode.rightChild,rightNode.leftChild) ;
        }
        return false ;
    }

    public String toInfixExpression(Node curNode)
    {
        if(curNode == null) return "" ;

        if(curNode.leftChild == null && curNode.rightChild == null) return String.valueOf(curNode.data) ;

        String leftExp = toInfixExpression(curNode.leftChild) ;
        String rightExp = toInfixExpression(curNode.rightChild) ;

        return "("+leftExp+" "+curNode.data+" "+rightExp+" "+")" ;
    }

    public Node findLCA(Node curNode,T data,T data2)
    {
        if(curNode == null || curNode.data.equals(data) || curNode.data.equals(data2))
        {
            return curNode ;
        }

        Node leftLCA = findLCA(curNode.leftChild, data, data2) ;
        Node rightLCA = findLCA(curNode.rightChild, data, data2) ;

        if(leftLCA != null && rightLCA != null)
        {
            return curNode ;
        }

        return leftLCA != null ? leftLCA : rightLCA ;
    }

    public int findDistance(Node curNode,T val1,T val2)
    {
        Node LCA = findLCA(curNode, val1, val2) ;

        int leftHeight = findDepth(LCA, val1) ;
        int rightHeight = findDepth(LCA, val2) ;

        return leftHeight+rightHeight ;
    }

    public boolean isComplete(Node curNode)
    {
        if(curNode == null)
        {
            return true ;
        }

        Queue<Node> queue = new LinkedList<>() ;
        queue.add(curNode) ;
        boolean flag = false ;

        while(!queue.isEmpty())
        {
            curNode = queue.poll() ;
            if(curNode.leftChild != null)
            {
                if(flag)
                {
                    return false ;
                }
                queue.add(curNode.leftChild) ;
            }
            else
            {
                flag = true ;
            }

            if(curNode.rightChild != null)
            {
                if(flag)
                {
                    return false ;
                }
                queue.add(curNode.rightChild) ;    
            } 
            else
            {
                flag = true ;
            }
        }
        return true ;
    }

    public boolean isProper(Node curNode)
    {
        if(curNode == null)
        {
            return true ;
        }

        if(curNode.leftChild == null && curNode.rightChild == null)
        {
            return true ;
        }

        if(curNode.leftChild == null || curNode.rightChild == null)
        {
            return false ;
        }

        return isProper(curNode.leftChild) && isProper(curNode.rightChild) ;
    }

    public int expressionEval(Node curNode)
    {
        if(curNode.leftChild == null && curNode.rightChild == null)
        {
            return Integer.parseInt(String.valueOf(curNode.data)) ;
        }

        int leftVal = expressionEval(curNode.leftChild) ;
        int rightVal = expressionEval(curNode.rightChild) ;

        switch(String.valueOf(curNode.data))
        {
            case "+" : 
                return leftVal+rightVal ;
            case "-":
                return leftVal-rightVal ;
            case "*":
                return leftVal*rightVal ;
            case "/":
                return leftVal/rightVal ;
        }
        return 0 ;
    }

    public Node findSibling(Node curNode,T data)
    {
        if(curNode == null )
        {
            return null ;
        }

        if(curNode.leftChild != null && curNode.leftChild.data.equals(data))
        {
            return curNode.rightChild ;
        }
        else if(curNode.rightChild != null && curNode.rightChild.data.equals(data))
        {
            return curNode.leftChild ;
        }

        Node leftSide = findSibling(curNode.leftChild, data) ;
        if(leftSide != null) return leftSide ;

        return findSibling(curNode.rightChild, data) ;
    }

    public void findCousin(Node curNode,T data)
    {
        if(curNode == null || curNode.data.equals(data))
        {
            System.out.println("The tree is empty or the root node does't have a cousin");
            return ;
        }

        Queue<Node> queue = new LinkedList<>() ;
        queue.add(curNode) ;
        boolean flag = false; 

        while(!queue.isEmpty())
        {
            int size = queue.size() ;

            for(int i=0;i<size;i++)
            {
                Node current = queue.poll() ;

                if(current.leftChild != null && current.leftChild.data.equals(data) ||current.rightChild != null && current.rightChild.data.equals(data))
                {
                    flag = true ;
                }
                else
                {
                    if(current.leftChild != null) queue.add(current.leftChild) ;
                    if(current.rightChild != null) queue.add(current.rightChild) ;
                }
            }

            if(flag)
            {
                while(!queue.isEmpty())
                {
                    System.out.print(queue.poll().data+"  ");
                }
                System.out.println();
                return ;
            }
        }
        System.out.println("No cousins found!!");
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in) ;
        binaryTreeFinal<String> bTF = new binaryTreeFinal<>() ;
        System.out.println("Enter the array Elements : ");
        String [] a = obj.nextLine().split(" ") ;
        /*Integer [] arr = new Integer[a.length] ;
        for(int i=0;i<a.length;i++)
        {
            arr[i] = Integer.parseInt(a[i]) ;
        } */

        bTF.buildTree(a) ;
        //bTF.addElement(bTF.root,"8");
        System.out.println();
        bTF.preOrderTraversal(bTF.root);
        System.out.println();
        System.out.println("No of elements in the tree : "+bTF.size);
        //System.out.println("The height of the node "+a[3]+" is : "+bTF.findHeight(bTF.root,a[3]) );
        //System.out.println("The depth of the node "+a[3]+" is : "+bTF.findDepth(bTF.root,a[3]));
        System.out.println("The distance between the nodes "+a[0]+" and "+a[0]+" is : "+(bTF.findDistance(bTF.root,a[0],a[0])));
        System.out.println("The expression evaluation is : "+bTF.toInfixExpression(bTF.root));
        //String [] a2 = obj.nextLine().split(" ") ;
        /*binaryTreeFinal<String>.Node lca = bTF.findLCA(bTF.root,"4","5") ;
        if(lca != null)
        {
            System.out.println(lca.data);
        }*/

        //System.out.println(bTF.findDistance(bTF.root, "4", "7")); 

        //System.out.println(bTF.isComplete(bTF.root));

        System.out.println("Proper Binary Tree ? "+bTF.isProper(bTF.root));

        System.out.println("Symmetric binary tree ? "+bTF.isSymmetric(bTF.root));

        obj.close(); 
        System.out.println(bTF.expressionEval(bTF.root));

        bTF.findCousin(bTF.root,"4");
    }
}