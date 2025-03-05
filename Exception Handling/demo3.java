class customException extends  Exception
{
    public customException(String str)
    {
        super(str) ;
    }
}

public class demo3 
{
    public static void main(String [] args)
    {
        int i = 2;
        int j = 0;

        try
        {
            j = 1/i ;

            if(j==0)
                throw new customException("It has been assigned the value 0.") ;
        }
        catch(customException e)
        {
            j = 1/1 ;
            System.out.println("Catched he custome Exception! "+ e);
        }

        System.out.println(j);
        System.out.println("Bye.");
    }
}
