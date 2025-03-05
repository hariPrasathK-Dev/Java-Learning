import java.io.* ;

public class stack 
{
	Node head ;
	
	public void push(int data)
	{
		Node node = new Node() ;
		node.data = data ;
		
		if(head == null)
		{
			head = node ;
		}
		else
		{
			node.next = head ;
			head  = node ;
		}
	}
	
	public void pop()
	{
		Node n = head ;
		head = n.next ;
		int temp = n.data ;
		n = null ;
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt",true)) ;
			writer.write(temp+"\n") ;
			
			writer.close() ;
		}
		catch(IOException e)
		{
			e.printStackTrace() ;
		}
		
	}
	
	public void front()
	{
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt",true)) ;
			writer.write(head.data+"\n") ;
			
			writer.close() ;
		}
		catch(IOException e)
		{
			e.printStackTrace() ;
		}
	}
	
	public void isEmpty()
	{
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt",true)) ;
			if(head == null)
			{
				writer.write("True\n") ;
			}
			else
			{
				writer.write("False\n");
			}
			
			writer.close() ;
		}
		catch(IOException e)
		{
			e.printStackTrace() ;
		}
	}
	
	public void size()
	{
		Node n = head ;
		int count = 0 ;
		while(n != null)
		{
			count++ ;
			n = n.next ;
		}
		
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt",true)) ;
			writer.write(count+"\n") ;
			
			writer.close() ;
		}
		catch(IOException e)
		{
			e.printStackTrace() ;
		}
	}

}
