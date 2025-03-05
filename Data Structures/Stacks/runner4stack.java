import java.io.* ;

public class runner4stack 
{
	public static void main(String [] args)
	{
		stack obj = new stack() ;
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("input.txt")) ;
			String line ;
			while((line=reader.readLine()) != null)
			{
				if(line.startsWith("PU"))
				{
					String [] values = line.substring(3).trim().split(",") ;
					for(String value : values)
					{
						obj.push(Integer.parseInt(value)) ;
					}
				}
				else if(line.startsWith("P"))
				{
					obj.pop() ;
				}
				else if(line.startsWith("F"))
				{
					obj.front() ;
				}
				else if(line.startsWith("S"))
				{
					obj.size() ;
				}
				else if(line.startsWith("IsEmp"))
				{
					obj.isEmpty();
				}
			}
			reader.close() ;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
