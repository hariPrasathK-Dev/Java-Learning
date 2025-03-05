public class stack 
{
    int top = 0 ;
    String [] arr ;

    public void size(int n)
    {
       arr = new String[n] ;
    }
    public void push(String value)
    {
        arr[top] = value ;
        top++ ;
    }

    public void showValue()
    {
        for(int j=top-1;j>=0;j--)
        {
            System.out.println(arr[j]);
        }
    }

    public void remove(int num)
    {
        int count = 1 ;
        while(count<=num && top>=0)
        {
            top-- ;
            arr[top] = "" ;
            count++ ;
             
        }
        System.out.println("The stack after remove operation : ");
        for(int j=top-1;j>=0;j--)
        {
            System.out.println(arr[j]);
        }
    }

    public void viewNo()
    {
        System.out.println("The number of items available : "+(top));
    }
    
}
