public class binarySearch 
{
    public static void main(String[] args) 
    {
        int [] arr = {1,2,3,4,5,6} ;
        int tar = 8 ;
        int res = binary(arr,0,5,tar) ;

        if(res!=-1)
        {
            System.out.println("THe element found at the index : "+res) ;
        }
        else
        {
            System.out.println("The element is not  present in the array.");
        }
    }

   /*private static int binary(int [] arr,int t)
    {
        int left = 0;
        int right = arr.length - 1 ;

        while(left<=right)
        {
            int mid = (left+right)/2 ;
            
            if(arr[mid]==t)
            {
                return mid ;
            }
            else if(arr[mid]<t)
            {
                left = mid+1 ;
            }
            else if(arr[mid]>t)
            {
                right = mid-1 ;
            }
        }

        return -1 ;
    } */

    private static int binary(int [] arr,int l,int r,int t)
    {
        if(l<=r)
        {
            int mid = (l+r)/2 ;

            if(arr[mid]==t)
            {
                return mid ;
            }
            else if(arr[mid]<t)
            {
                return binary(arr,mid+1,r,t) ;
            }
            else if(arr[mid]>t)
            {
                return binary(arr,l,mid-1,t) ;
            }
        }
        return -1 ;
    }
    
}
