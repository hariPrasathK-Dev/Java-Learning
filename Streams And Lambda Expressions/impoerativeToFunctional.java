import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//import java.util.stream.Stream ;
public class impoerativeToFunctional {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> evenNumbers = new ArrayList<>();
        /*for (int n : numbers) 
        {
            if (n % 2 == 0) 
            {
                evenNumbers.add(n);
            }

        } */

        evenNumbers = numbers.stream().filter(n -> n%2==0).collect(Collectors.toList()) ;

        evenNumbers.forEach(n -> System.out.println(n));
    }

}