import java.util.List ;

public class StepExecution {

    private final ExecutionFlowManager manager;
    private static final String ANSI_BLUE = "\u001B[34m"; // Blue color for step messages
    private static final String ANSI_RESET = "\u001B[0m"; // Reset color
 
    public StepExecution(ExecutionFlowManager manager) {
        this.manager = manager;
    }
 
    public void stepInto(String functionName) {
        System.out.println(ANSI_BLUE + "\nStepping into: " + functionName + ANSI_RESET);
        manager.functionCall(functionName);
        SimpleLogger.logInfo("Stepping into: " + functionName); // Log stepping into method
    }
 
    public void stepOver(String functionName) {
        System.out.println(ANSI_BLUE + "\nStepping over: " + functionName + ANSI_RESET);
        List<String> calledFunctions = manager.getCallGraph().getCalledFunctions(functionName);
        if (!calledFunctions.isEmpty()) {
            for (String func : calledFunctions) {
                if (!func.equals(functionName)) { // Skip over the current function's internals
                    System.out.println(ANSI_BLUE + "Skipping into: " + func + ANSI_RESET);
                }
            }
            manager.functionCall(functionName); // Call the function without stepping into it.
            SimpleLogger.logInfo("Stepping over: " + functionName); // Log stepping over method
        }
    }
 
    public void stepOut() {
        System.out.println(ANSI_BLUE + "\nStepping out of current function." + ANSI_RESET);
        manager.functionReturn();
        SimpleLogger.logInfo("Stepping out of current function."); // Log stepping out of method
    }
 }