public class runner4stack 
{
    public static void main(String[] args) 
    {
        stack obj = new stack() ;
        
        obj.insert("Fruits",3) ;
        obj.insert("Vegetables",4) ;

        obj.show("Vegetables") ;

        obj.remove("Vegetables",2) ;

        obj.show("Vegetables") ;
    }
}
