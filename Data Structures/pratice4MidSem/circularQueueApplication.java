public class circularQueueApplication {

    int front = 0;
    int rear = 0;
    int size = 0;
    int num;
    String[] arr;

    // Set the size of the circular queue
    public void setSize(int n) {
        arr = new String[n];
        num = n;
    }

    // Enqueue an element into the queue
    public void enQueue(String data) {
        if (!isFull()) {
            arr[rear] = data;
            rear = (rear + 1) % num;
            size++;
        }        
    }

    // Dequeue an element from the front
    public String deQueue() {
        if (!isEmpty()) {
            String data = arr[front];
            front = (front + 1) % num;
            size--;
            return data;
        }
        return "";  // Empty queue returns empty string
    }

    // Rotate the front pointer (used for Josephus problem)
    public void rotate() {
        front = (front + 1) % num;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size <= 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == num;
    }

    // Josephus problem simulation with a step count of k
    public void josephs(int k) {
        while (size > 1) {
            // Rotate the queue k-1 times
            for (int i = 0; i < k - 1; i++) {
                rotate();
            }
            // Dequeue the player who is out
            String out = deQueue();
            System.out.println("The player out is: " + out);
        }
        // The last remaining player is the winner
        System.out.println("The last player remaining is: " + arr[front]);
    }

    public static void main(String[] args) {
        // Input list of players
        String[] inp = {"Pivi", "Vijay", "Anuj", "Harish", "Karthik", "Hari"};

        // Initialize the circular queue
        circularQueueApplication queApp = new circularQueueApplication();
        queApp.setSize(inp.length);

        // Enqueue all players into the circular queue
        for (int i = 0; i < inp.length; i++) {
            queApp.enQueue(inp[i]);
        }

        // Perform the Josephus problem with step count of 3
        queApp.josephs(3);
    }
}
