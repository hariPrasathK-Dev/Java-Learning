@FunctionalInterface
interface A
{
    int show(int a,int b) ;
}

/*class B implements A
{
    public void show()
    {
        System.out.println("Hi!");
    }
} */


/*class B implements A
{
    public void show(int a,int b)
    {
        System.out.println("Hi inside the lambda!");
        return (a+b) ;
    }
}
 */
public class lambda2
{
    public static void main(String[] args) 
    {
        A obj = (int a,int b) -> 
        {
            System.out.println("Hi inside the lambda!");
            return (a+b) ;
        } ;
        int res = obj.show(2,3) ;
        System.out.println("The result is : "+res);
    }
}