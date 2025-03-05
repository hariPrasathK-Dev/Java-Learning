public class Tuple {

    int priority ;
    char value ;
    public Tuple(int priority,char value)
    {
        this.priority = priority ;
        this.value = value ;
    }
    
    public int getPriority()
    {
        return priority ;
    }

    public char getValue()
    {
        return value ;
    }
}
