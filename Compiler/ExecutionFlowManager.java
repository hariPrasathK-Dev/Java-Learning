import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ExecutionFlowManager {

    private CallGraph callGraph; // To manage and visualize the function calls
    private Stack<String> callStack; // Stack to manage the current call stack
    private List<String> executionFlow; // To track the order of executed functions
    Debugger debugger; // Instance of Debugger class
    private StepExecution stepExecution; // Instance of StepExecution class
    private ThreadManager threadManager; // Instance of ThreadManager class

    public ExecutionFlowManager() {
        callGraph = new CallGraph();
        callStack = new Stack<>();
        executionFlow = new ArrayList<>();
        debugger = new Debugger(); // Initialize debugger
        stepExecution = new StepExecution(this); // Initialize StepExecution
        threadManager = new ThreadManager(); // Initialize ThreadManager

        SimpleLogger.setupLogger(); // Setup logger for ExecutionFlowManager class as well.
    }

    // Method to read function definitions from a Java file.(Here Sample.java)
    //Time Complexity: O(m), where m is the number of lines in the file being read. Each line is processed once.
    public void readFile(String filename) { 
        try { 
            File file = new File(filename); 
            Scanner scanner = new Scanner(file); 
            while (scanner.hasNextLine()) { 
                String line = scanner.nextLine().trim(); 
                if (line.startsWith("public void")) { // Simple check for method definitions 
                    String methodName = line.split(" ")[2].split("\\(")[0]; 
                    System.out.println("Found method: " + methodName); 
                    if (line.contains("methodA")) { 
                        callGraph.addFunctionCall(methodName, "methodA"); 
                    } 
                    if (line.contains("methodB")) { 
                        callGraph.addFunctionCall(methodName, "methodB"); 
                    } 
                } 
            } 
            scanner.close(); 
        } catch (FileNotFoundException e) { 
            System.out.println("File not found: " + filename); 
            e.printStackTrace(); 
        } 
    }

    // Method to simulate a function call.
    //Time Complexity: O(1) for pushing to the stack and adding to execution flow.
    public void functionCall(String functionName) { 
        callStack.push(functionName); 
        executionFlow.add(functionName); // Track execution flow 

        System.out.println("Function called: " + functionName);
        System.out.println("Current Call Stack: " + callStack);

        // Display called functions from the current function
        List<String> calledFunctions = callGraph.getCalledFunctions(functionName);
        System.out.println("Called Functions: " + calledFunctions);

        // Log current watchpoints for visibility
        debugger.logBreakpoints();

        SimpleLogger.logInfo("Function called: " + functionName);  
        SimpleLogger.logInfo("Current Call Stack: " + callStack.toString());
        SimpleLogger.logInfo("Called Functions: " + calledFunctions.toString());
    }

    // Method to simulate returning from a function.
    //Time Complexity: O(1) for popping from the stack.
    public void functionReturn() { 
        if (!callStack.isEmpty()) { 
            String returnedFunction = callStack.pop(); 
            System.out.println("Returned from: " + returnedFunction); 

            if (!executionFlow.isEmpty()) { 
                executionFlow.remove(executionFlow.size() - 1); // Remove last executed function 
            } 

            System.out.println("Current Call Stack: " + callStack); 
        } else { 
            System.out.println("Call stack is empty."); 
        } 
    }

   // Method to display the current execution flow.
   //Time Complexity: O(n), where n is the number of executed functions stored in executionFlow.
   public void displayExecutionFlow() { 
       System.out.println("Current Execution Flow: " + executionFlow); 
   }

   public Stack<String> getCallStack() {
       return callStack;
   }

   public CallGraph getCallGraph() {
       return callGraph;
   }

   public StepExecution getStepExecution() {
       return stepExecution; // Return the StepExecution instance
   }

   public ThreadManager getThreadManager() {
       return threadManager; // Return the ThreadManager instance
   }
}