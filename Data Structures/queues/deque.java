    public class deque 
    {
        Node head ;
        Node tail ;
        int size = 0 ;
        public void enqueueFirst(int data)
        {
            Node n = new Node() ;
            n.data = data ;
            if(head==null)
            {
                head = n ;
                tail = n ;
            }
            else
            {
                n.next = head ;
                head = n ;
            }
            size++ ;
        }

        public void enqueueLast(int data)
        {
            Node n = new Node() ;
            n.data = data ;
            if(head==null)
            {
                head = n ;
            }

            else
            {
                tail.next = n ;
            }
            tail = n ;    
            size++ ;
        }

        public void dequeueFirst()
        {
            if(head==null )
            {
                System.out.printf("\nEmpty queue.Cannot perform dequeue operation.");
            }


            else
            {
                Node n = head ;
                head = n.next ;
                if(head == null)
                {
                    tail = null ;
                }
                n = null ;
                
            }
            size-- ;
        }

        public void dequeueLast()
        {
            if(head==null)
            {
                System.out.printf("\nEmpty queue.Cannot perform dequeue operation.");
            }

            else if(head==tail)
            {
                head = null ;
                tail = null ;
            }

            else
            {
                Node l = head ;
                while(l.next != tail )
                {
                    l = l.next ;
                }
                tail = l ;
                tail.next = null ;
            }
            size-- ;
        }

        public int front()
        {
            if(head==null)
            {
                
                return -1 ;
            }
            else
            {
                return head.data ;
            }
        }

        public int last()
        {
            if(tail==null)
            {
                
                return -1 ;
            }
            else
            {
                return tail.data ;
            }
        }

        public boolean isEmpty()
        {
            return size<=0 ;
        }

        public int size()
        {
            return size ;
        }
        
        public void show()
        {
            System.out.println();
            Node n = head ;
            while(n!=null)
            {
                System.out.print(n.data+"  ");
                n = n.next ;
            }
        }

        private static class Node
        {
            int data ;
            Node next ;
        }
    }
