import java.util.List ;
import java.util.function.Consumer;
import java.util.Arrays ;

public class forEachMethod 
{
    public static void main(String[] args) 
    {
        List<Integer> nums = Arrays.asList(6,5,2,1,3) ;

        /*for(int i=0;i<nums.size();i++)
        {
            System.out.println(nums.get(i));
        } */

        /*for(int n:nums)
        {
            System.out.println(n);
        } */

        /*Consumer<Integer> cons = new Consumer<Integer>() 
        {
            public void accept(Integer integer)
            {
                System.out.println(integer);
            }
        }; 
        
        nums.forEach(cons) ;
        */

        nums.forEach(n -> System.out.println(n));
    }
    
}
