import java.util.ArrayList ;

public class Heap
{
    ArrayList<Tuple> list ;

    public Heap()
    {
        list = new ArrayList<>() ;
    }

    private void swap(int index1,int index2)
    {
        Tuple temp = list.get(index1) ;
        list.set(index1,list.get(index2)) ;
        list.set(index2,temp) ;
    }

    private int parentIndex(int index)
    {
        return (index - 1)/2 ;
    }

    private int leftChildIndex(int index)
    {
        return 2*index + 1 ;
    }

    private int rightChildIndex(int index)
    {
        return 2*index + 2 ;
    }

    private void upHeap(int index)
    {
        if(index == 0)
        {
            return ;
        }

        int parentInd = parentIndex(index) ;
        if(list.get(index).getPriority() < list.get(parentInd).getPriority())
        {
            swap(index,parentInd) ;
            upHeap(parentInd) ;
        }
        return ;
    }

    private void downHeap(int index)
    {
        int minInd = index ;
        int leftChildInd = leftChildIndex(index) ;
        int rightChildIndex = rightChildIndex(index) ;

        if(leftChildInd<list.size() && list.get(leftChildInd).getPriority() < list.get(minInd).getPriority())
        {
            minInd = leftChildInd ;
        }

        if(rightChildIndex < list.size() && list.get(minInd).getPriority() > list.get(rightChildIndex).getPriority())
        {
            minInd = rightChildIndex ;
        }

        if(minInd != index)
        {
            swap(minInd,index) ;
            downHeap(minInd);
        }
        return ;
    }

    public void insert(int data,char Value)
    {
        Tuple newTuple = new Tuple(data, Value) ;
        list.add(newTuple) ;

        if(list.size() > 1)
        {
            upHeap(list.size()-1) ;
        }
    }

    public Tuple remove() throws Exception
    {
        if(!list.isEmpty())
        {
            Tuple temp = list.get(0) ;
            Tuple last = list.remove(list.size()-1) ;
           
            if(!list.isEmpty())
            {
                list.set(0,last) ;
                downHeap(0) ;
            }
            return temp ;
        }

        else
        {
            throw new Exception("Removing from an empty Heap!") ;
        }
    }
    
    public ArrayList<Tuple> heapSort() throws Exception
    {
        if(list.isEmpty())
        {
            throw new Exception("Cannot perform Heap Sort since Heap is Empty") ;
        }
        
        ArrayList<Tuple> arr = new ArrayList<>() ;
        while(!list.isEmpty())
        {
            arr.add(this.remove()) ;
        }
        return arr ;
    }

    public int inner()
    {
        return (int) Math.floor(list.size()/2) ;
    }

    public int leaf()
    {
        return (int) Math.ceil(list.size()/2) ;
    }
    public int findHeight()
    {
        if(list.isEmpty()) return 0 ;

        return (int) Math.floor(Math.log(list.size())/Math.log(2)) ;
    }

    public int findDepth(int index)
    {
        if(list.isEmpty()) return -1 ;

        return (int) Math.floor(Math.log(index+1)/Math.log(2)) ;
    }
}