public class istack 
{
    int top = 0 ;
    String [] arr ;

    public void sizeArr(int n)
    {
        arr = new String[n] ;
    }

    public void insert(String item)
    {
        arr[top] = item ;
        top++ ;
    }

    public void remove(int n)
    {
        while(n>=1 && top>=0)
        {
            top-- ;
            arr[top] = "" ;
            n-- ;
        }
        System.out.println("The stack after the removal : ");
        for(int j = top-1;j>=0;j--)
       {
            System.out.print(arr[j]+"  ");
       }
    }
    public void show()
    {
       for(int j = top-1;j>=0;j--)
       {
            System.out.print(arr[j]+"  ");
       }
    }
}
