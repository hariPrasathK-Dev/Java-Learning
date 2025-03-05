public class bubbleSort 
{
    public static void main(String[] args) 
    {
        int [] arr = {6,5,4,3,2,1} ;
        
        System.out.println("The array before sorting : ");
        for(int num:arr)
        {
            System.out.print(num+"  ");
        }
        System.out.println();

        bubble(arr) ;

        System.out.println("The array after sorting : ");
        for(int num:arr)
        {
            System.out.print(num+"  ");
        }
    }

    private static void bubble(int [] arr)
    {
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=0;j<arr.length-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j] ;
                    arr[j] = arr[j+1] ;
                    arr[j+1] = temp ;
                }
            }
        }
    }
    
}
