import java.util.* ;

public class runner 
{
    public static void main(String [] args)
    {
        Random rand = new Random() ;
        int randInt = rand.nextInt((10-2)+1)+2 ;

        linkedList list = new linkedList() ;

        for(int i =0;i<randInt;i++)
        {
            list.addPlayer(rand.nextInt((156-101)+1)+101);
        }

        for(int i=0;i<randInt;i++)
        {
            list.addQuiz(rand.nextInt((10-2)+1)+2) ;
        }

        list.show(randInt) ;
        //list.showQuiz();

    }
    
}
