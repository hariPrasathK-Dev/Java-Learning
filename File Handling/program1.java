import java.util.Scanner ;
import java.io.File ;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter ;
import java.io.IOException ;

public class program1
{
    public static void main(String [] args)
    {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) 
        {
            System.out.println("Enter a String : ");
            String input = reader.readLine() ;

           System.out.println("Hey "+input);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}