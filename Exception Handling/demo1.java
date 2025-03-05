public class demo1
{
    public static void main(String[] args) 
    {
        int i = 0 ;
        int j = 0;

        try
        {
            j = 18/i ;
        }
        catch(Exception e)
        {
            System.out.println("Something wrong has happened in the expression evaluation..");
        }

        System.out.println(j);
        System.out.println("Bye.");
    }
}