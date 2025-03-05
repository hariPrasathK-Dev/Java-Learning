public class runner4BST 
{
    public static void main(String[] args) 
    {
        binarySearchTree b = new binarySearchTree() ;

        b.insert(6) ;
        b.insert(5) ;
        b.insert(4) ;
        b.insert(3) ;
        b.insert(2) ;
        b.insert(1) ;

        b.preOrderTraversal(); 
        System.out.println();

        b.inOrder(); 
        System.out.println();
        
        b.postOrder(); 
    }   
}