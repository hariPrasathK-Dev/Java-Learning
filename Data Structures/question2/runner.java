public class runner 
{
    public static void main(String [] args)
    {
        warehouseStack obj = new warehouseStack() ;

        obj.insert(20) ;
        obj.insert(3);
        obj.insert(4);
        obj.insert(1);
        obj.insert(6) ;
        obj.insert(5) ;
        obj.insert(2);

        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
    
}
