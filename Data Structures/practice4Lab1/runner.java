import java.io.* ;

public class runner 
{
    public static void main(String[] args) 
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"))  ;
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt",true)) ;
            String line ;
            while((line = reader.readLine()) != null)
            {
                if(line.startsWith("PU"))
                {
                    String [] arr = line.substring(3).split(",") ;
                    for(int i=0;i<arr.length;i++)
                    {
                        System.out.print(arr[i]+"  ");
                    }
                    System.out.println();
                }
                else if(line.strip().equals("P"))
                {
                    System.out.println("Pop Operation Encountered.");
                }
                else if(line.strip().equals("TOP"))
                {
                    System.out.println("Top Operation encountered.");
                }
                else if(line.strip().equals("IsEmpty"))
                {
                    System.out.println("IsEmpty Operation encountered.");
                }
                else if(line.startsWith("Size"))
                {
                    System.out.println("Size Operation encountered.");
                }
            }

            reader.close() ;
            writer.close() ;
        }
        catch (IOException e)
        {
           e.printStackTrace();
        }

    }
    
}
