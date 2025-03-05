
public class linearSearch
{
    public static void main(String[] args) {
        int [] arr = {6,5,4,3,2,1} ;
        int tar = 7 ;
        int res = linear(arr,tar) ;

        if(res != -1)
        {
            System.out.println("The given element found at the index : "+res) ;
        }
        else
        {
            System.out.println("The given element is not present in the array.") ;
        }
    }

    private static int linear(int [] arr,int t)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==t)
            {
                return i ;
            }
        }
        return -1 ;
    }

}