import java.util.* ;

public class  linkedList
{
    Random rand = new Random() ;
    Node head ;
    quizzList Head ;
    public void addPlayer(int playerId)
    {
        Node node = new Node() ;
        node.playerId = playerId ;
        node.next = null ;

        if(head==null)
        {
            head = node ;
        }

        else
        {
            Node n = head ;
            while(n.next!=null)
            {
                n = n.next ;
            }
            n.next = node ; 
        }
    }

    public void addQuiz(int no)
    {
        quizzList quiz = new quizzList() ;
        quiz.no = no ;
        quiz.next = null ;
        if(Head==null)
        {
            Head = quiz ;
        }

        else
        {
            quizzList q = Head;

            while(q.next!=null)
            {
                q = q.next ;
            }
            q.next = quiz ;
        }

    }
    public void show(int randInt)
    {
        Node n = head ;
        quizzList q = Head ;
        int track = 1 ;
        while(n.next!=null)
        {
            System.out.printf("\nPlayer %d ID : %d",track,n.playerId);
            System.out.printf("\nAssigned Quiz : ");
            int randint = rand.nextInt((randInt-1)+1)+0 ;
            int i =0;
            while(q.next!=null && i<(randint-1))
            {
                q = q.next ;
                i = i+1 ;
            }
            System.out.printf("%d",i+1);
            System.out.printf("\nNumber of questions in the quiz : %d",q.no);
            n = n.next ;
            track+=1 ;
        }
        System.out.printf("\nPlayer %d ID : %d",track,n.playerId);
        System.out.printf("\nAssigned Quiz : ");
            int randint = rand.nextInt((randInt-1)+1)+0 ;
            int i =0;
            while(q.next!=null && i<(randint-1))
            {
                q = q.next ;
                i = i+1 ;
            }
            System.out.printf("%d",i+1);
            System.out.printf("\nNumber of questions in the quiz : %d",q.no);
    }

    public void showQuiz()
    {
        quizzList q = Head ;
        int track = 1 ;
        while(q.next!=null)
        {
            System.out.printf("\nQuiz %d No of ques : %d",track,q.no);

            q = q.next ;
            track+=1 ;
        }
        System.out.printf("\nQuiz %d No of ques : %d",track,q.no);
    }
    
}
