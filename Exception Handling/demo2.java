public class demo2 
{
    public static void main(String[] args) 
    {
        int i = 20 ;
        int j = 0 ;
        try
        {
            j = 18/i ;

            if(j==0)
                throw new ArithmeticException("I don't want j to have the value 0.") ;
        }  
        catch(ArithmeticException e)
        {
            j = 18/1 ;
            System.out.println("Default value to be printed!" + e);
        }
        System.out.println(j);
        System.out.println("Bye.");
    }
    
}
