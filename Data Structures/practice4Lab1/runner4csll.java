public class runner4csll 
{
    public static void main(String[] args) 
    {
        circularSLL obj = new circularSLL() ;
        
        obj.insertAtFirst(5);
        obj.insertAt(6, 1);
        obj.insertAtLast(3) ;

        obj.show() ;
        
        obj.deleteAt(2);
        obj.show();
    }
}
