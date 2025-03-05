import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

class ThreadManager {

   private Map<Integer, ThreadData> threadDict;  // Dictionary to store thread data
   private PriorityBlockingQueue<ThreadData> priorityQueue;  // Priority queue for managing thread priorities
   private int threadCounter;  // Unique counter for thread IDs

   public ThreadManager() {
       threadDict = new HashMap<>();
       priorityQueue = new PriorityBlockingQueue<>(11, Comparator.comparingInt(td -> td.priority));
       threadCounter = 0;  // Initialize counter
   }

   public void addThread(Runnable function, int priority, String name) {
       threadCounter++;
       Thread thread = new Thread(function, name);
       ThreadData threadData = new ThreadData(threadCounter, thread, priority);
       threadDict.put(threadCounter, threadData);  // Store thread data
       priorityQueue.offer(threadData);  // Push thread by priority

       SimpleLogger.logInfo("Added thread: " + name + " with priority: " + priority); // Log thread addition
   }

   public void startNextThread() {
       if (priorityQueue.isEmpty()) {
           System.out.println("No threads to start.");
           return;
       }
       ThreadData threadData = priorityQueue.poll();
       if (threadData != null) {  // Start the highest-priority thread in the queue
           threadData.thread.start();
           System.out.printf("Starting thread %s with priority %d%n", threadData.thread.getName(), threadData.priority);
           try {
               threadData.thread.join(); // Wait for this thread to finish
               SimpleLogger.logInfo("Thread finished: " + threadData.thread.getName()); // Log when a thread finishes execution.
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   }

   private static class ThreadData {  // Inner class for managing threads and their states
       int id;
       Thread thread;
       int priority;

      ThreadData(int id, Thread thread, int priority) {
          this.id = id;
          this.thread = thread;
          this.priority = priority;
      }
  }
}