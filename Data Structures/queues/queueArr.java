public class queueArr 
{
    int [] queue = new int[6] ;
    int front = 0 ;
    int rear = 0 ;
    int size = 0 ;

    public void enqueue(int data)
    {
        if(!(isFull()))
        {
            queue[rear] = data ;
            rear = (rear + 1)%6 ;
            size++ ;
        }
        else
        {
            System.out.println("The queue is full.Cannot perform Enqueue opeartion.");
        }
    }

    public int dequeue()
    {
        if(!(isEmpty()))
        {
            int temp = queue[front] ;
            front = (front+1)%6 ;
            size-- ;
            return temp ;
        }
        else
        {
            System.out.println("The queue is empty.Dequeue operation cannot be performed,");
            return -1 ;
        }
    }

    public int Front()
    {
        return queue[front] ;
    }

    public boolean isEmpty()
    {
        return size==0 ;
    }

    public boolean isFull()
    {
        return size==6 ;
    }

    public void show()
    {
        for(int i=0;i<size;i++)
        {
            System.out.print(queue[(front+i)%6]+"  ");
        }
    }
}
