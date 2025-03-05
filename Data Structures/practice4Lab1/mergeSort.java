public class mergeSort 
{
    public static void main(String[] args) 
    {
        int [] arr = {5,6,3,2,4,1} ;

        System.out.println("The array before sorting : ");
        for(int num : arr)
        {
            System.out.print(num+"  ");
        }
        System.out.println();

        merge(arr,0,arr.length - 1) ;

        System.out.println("The array after sorting : ");
        for(int num : arr)
        {
            System.out.print(num+"  ");
        }
        
    }

    private static void merge(int [] arr,int left,int right)
    {
        if(left<right)
        {
            int mid = (left+right)/2 ;

            merge(arr,left,mid) ;
            merge(arr,mid+1,right) ;

            conquer(arr,left,mid,right) ;
        }
    }

    private static void conquer(int [] arr,int left,int mid,int right)
    {
        int lSize = mid-left+1 ;
        int rSize = right-mid ;
        int [] lArr = new int[lSize] ;
        int [] rArr = new int[rSize] ;

        for(int i=0;i<lSize;i++)
        {
            lArr[i] = arr[left+i] ;
        }

        for(int j=0;j<rSize;j++)
        {
            rArr[j] = arr[mid+1+j] ;
        }

        int lInd = 0 ;
        int rInd = 0 ;
        int key = left ;
        while(lInd < lSize && rInd < rSize)
        {
            if(lArr[lInd]<=rArr[rInd])
            {
                arr[key] = lArr[lInd] ;
                lInd++ ;
            }
            else
            {
                arr[key] = rArr[rInd] ;
                rInd++ ;
            }
            key++ ;
        }
        while(lInd<lSize)
        {
            arr[key] = lArr[lInd] ;
            lInd++ ;
            key++ ;
        }
        while(rInd<rSize)
        {
            arr[key] = rArr[rInd] ;
            rInd++ ;
            key++ ;
        }
    }
}
