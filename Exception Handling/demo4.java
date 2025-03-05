public class demo4 
{
    private void show() throws Exception
    {
        //Class.forName("Demo") ;

        //Not Recommended
        int i = 0;
        int j = 0 ;

        j = 18/i ;
    }
    public static void main(String [] args)
    {
        demo4 d4 = new demo4() ;
        try
        {
            d4.show() ;
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception : "+e);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array Index EXception : "+e);
        }
        catch(Exception e)
        {
            System.out.println("Some unknown One : "+e);
        }

        System.out.println("Bye! Glad to see you here and So Sad to miss you at this moment!!");
    }    
}
