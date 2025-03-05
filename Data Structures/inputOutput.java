import java.io.* ;

public class inputOutput
{
    public static void main(String[] args)
    {
        try
        {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt")) ;
        writer.write("Helloo!!World..") ;

        int [] arr = {3,4,2,6,5,1} ;
        for(int num : arr)
        {
            writer.write("\n "+num) ;
        }
        writer.close() ;
        }
        catch (IOException e)
        {
            e.printStackTrace() ;
        } 

      /*  try
        {
            BufferedReader reader  = new BufferedReader(new FileReader("output.txt")) ;
            String line ;
            while((line = reader.readLine()) != null)
            {
                try{
                int ex = Integer.parseInt(line.trim()) ;
                System.out.println(ex==6) ;
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Invalid integer in line : "+line);
                }
            }
            reader.close() ;
        }

        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        */
        
    }
    
}
