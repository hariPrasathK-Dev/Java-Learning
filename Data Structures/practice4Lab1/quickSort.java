public class quickSort 
{
    public static void main(String[] args) 
    {
        int [] arr = {1,5,6,2,4,3} ;

        System.out.println("The array before sorting : ");
        for(int num : arr)
        {
            System.out.print(num+"  ");
        }
        System.out.println();

        quick(arr,0,arr.length-1) ;
        
        System.out.println("The array after sorting : ");
        for(int num : arr)
        {
            System.out.print(num+"  ");
        } 
        
    }

    private static void quick(int [] arr,int left,int right)
    {
        if(left<right)
        {
            int pivotInd = findPivot(arr,left,right) ;

            quick(arr,left,pivotInd-1) ;
            quick(arr,pivotInd+1,right) ;
        }
    }

    private static int findPivot(int [] arr,int left,int right)
    {
        int pivot = arr[right] ;
        int j = left-1 ;
        for(int i=left;i<right;i++)
        {
            if(arr[i]<pivot)
            {
                j++ ;
                int temp = arr[j] ;
                arr[j] = arr[i] ;
                arr[i] = temp ;
            }
        }
        int temp = arr[j+1] ;
        arr[j+1] = pivot ;
        arr[right] = temp ;

        return j+1 ;
    }
    
}
