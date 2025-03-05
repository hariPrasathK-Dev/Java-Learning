public class selectionSort 
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
        selection(arr) ;

        System.out.println("The array after sorting : ");
        for(int num:arr)
        {
            System.out.print(num+"  ");
        }
    }

    private static void selection(int [] arr)
    {
        for(int i=0;i<arr.length-1;i++)
        {
            int minInd = i ;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[minInd]>arr[j])
                {
                    minInd = j ;
                }
            }
            if(minInd != i)
            {
                int temp = arr[i] ;
                arr[i] = arr[minInd] ;
                arr[minInd] = temp ;
            }

        }
    }
    
}
