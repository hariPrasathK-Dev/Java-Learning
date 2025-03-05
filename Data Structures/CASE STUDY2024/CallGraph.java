import java.sql.Time;
import java.util.*;

class CallGraph {
    private MyHashMap<String, List<String>> graph; // Use of  custom hash map named MyHashMap

   public CallGraph() { 
       graph = new MyHashMap<>(); 
   }

   // Method to add a function call (directed edge)
   /*Time Complexity: O(1) for checking if the function exists in the hash map and O(1) for adding to the list.
    Overall: O(1) on average due to the hash map's constant time complexity for inserts. */

   public void addFunctionCall(String from, String to) { 
       if (!graph.containsKey(from)) {
           graph.put(from, new ArrayList<>());
       }
       graph.get(from).add(to); 
       System.out.println("Function call added: " + from + " -> " + to);
       SimpleLogger.logInfo("Function call added: " + from + " -> " + to); // Log addition of function calls
   }

   // Method to display the call graph
   //Time Complexity: O(n), where n is the number of functions in the graph since you iterate through all keys in the hash map.
   public void displayGraph() { 
       for (String function : graph.keySet()) { 
            System.out.println("Displaying Call Graph Info : ");
           System.out.println(function + " -> " + graph.get(function)); 
       } 
   }

   // Method to get the neighbors of a function (called functions)
   //Time Complexity: O(1) on average for retrieving a list from the hash map.
   public List<String> getCalledFunctions(String function) { 
       List<String> calledFunctions = graph.get(function);
       return calledFunctions != null ? calledFunctions : new ArrayList<>();
   } 
}