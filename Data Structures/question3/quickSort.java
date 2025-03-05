public class quickSort 
{

    private static void Sort(int [] arr,int low,int high)
    {
        if(low < high)
        {
            int piIndex = pivotIndex(arr,low,high) ;

            Sort(arr,low,piIndex-1) ;
            Sort(arr,piIndex+1,high) ;
        }
    }

    private static int pivotIndex(int [] arr,int low,int high)
    {
        int pivot = arr[high] ;
        int i = low-1 ;
        for(int j=low;j<high;j++)
        {
            if(arr[j]<pivot)
            {
                i++ ;
                int temp = arr[i] ;
                arr[i] = arr[j] ;
                arr[j] = temp ;
            }
        }
        int temp = arr[i+1] ;
        arr[i+1] = arr[high] ;
        arr[high] = temp ;
        
        return i+1 ;
    }


    public static void main(String [] args)
    {
        int [] arr = {6,4,2,5,3,1} ;

        System.out.println("Array before Sorting : ");
        for(int num : arr)
        {
            System.out.print(num+"  ");
        }

        Sort(arr,0,(arr.length)-1) ;

        System.out.println();
        System.out.println("Array After Sorting : ");
        for(int num : arr)
        {
            System.out.print(num+"  ");
        }
    }
    
}
