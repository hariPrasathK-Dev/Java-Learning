class A extends Thread 
{
    public void run() //throws InterruptedException
    {
        for(int i=0;i<100;i++)
        {
            System.out.println("Hi");
            try
            {
                Thread.sleep(6) ;
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}

class B extends Thread
{
    public void run() //throws Exception
    {
        for(int i=0;i<100;i++)
        {
            System.out.println("Hello");
            try
            {
                Thread.sleep(6) ;
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}

public class demo2
{
    public static void main(String [] args)
    {
        A obj1 = new A() ;
        B obj2 = new B() ;

        obj1.setPriority(Thread.MAX_PRIORITY);
        obj1.start();
        /*try {
            Thread.sleep(10);
        } catch (Exception e) {
            // TODO: handle exception
        }*/
        obj2.start() ; 
    }    
}