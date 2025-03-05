public class insertionSort 
{
    public static void main(String[] args) 
    {
        int [] arr = {1,4,3,6,3,7,2} ;

        System.out.println("The array before sorting : ");
        for(int num : arr)
        {
            System.out.print(num+"  ");
        }
        System.out.println();
        
        insertion(arr) ;
        System.out.println("The array after sorting : ");
        for(int num : arr)
        {
            System.out.print(num+"  ");
        }
    }

    private static void insertion(int [] arr)
    {
        for(int i=1;i<arr.length;i++)
        {
            int key = arr[i] ;
            int j = i-1 ;

            while(j>=0 && arr[j]>key)
            {
                arr[j+1] = arr[j] ;
                j-- ;
            }
            arr[j+1] = key ;
        }
    }
    
}
