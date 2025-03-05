public class lambda1
{
    public static void main(String [] args)
    {
        Printable p1 = () -> System.out.println("Hello Lambda Expressions!");
        printThing(p1) ;
    }

    static void printThing(Printable p)
    {
        p.print() ;
    }
}