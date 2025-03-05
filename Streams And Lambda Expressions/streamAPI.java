import java.util.Arrays ;
import java.util.List ;
import java.util.stream.Stream ;

public class streamAPI 
{
    public static void main(String [] args)
    {
        List<Integer> nums = Arrays.asList(6,5,2,8,1,7) ;

        Stream<Integer> data = nums.stream();
        Stream<Integer> filteredData = data.filter(n -> n%2==1) ;
        Stream<Integer> sortedData = filteredData.sorted() ;
        Stream<Integer> mappedData = sortedData.map(n -> n*2) ;
        int result = mappedData.reduce(0,(a,b) -> a+b) ;
       // mappedData.forEach(n -> System.out.println(n));
       System.out.println("The sum : "+result);
    }
}
