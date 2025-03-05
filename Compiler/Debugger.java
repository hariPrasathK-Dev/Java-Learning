import java.util.*;
import java.io.IOException;
class Debugger {
    private MyHashMap<String, Variable> variables; // Use custom hash map instead of built-in HashMap
    private Set<String> watchpoints; // Store watchpoints
    private Set<Integer> breakpoints; // Store line breakpoints
    private int breakpointId;

    public Debugger() {
        this.variables = new MyHashMap<>();
        this.watchpoints = new HashSet<>();
        this.breakpoints = new HashSet<>(); 
        this.breakpointId = 0; // Initialize breakpoint ID
        SimpleLogger.setupLogger(); // Setup logger for Debugger
    }

    /*
    Function: addVariable(String name, Object value)
    Time Complexity: O(1)
    */
    public void addVariable(String name, Object value) {
        Variable variable = new Variable(name, value);
        variables.put(name, variable);
        SimpleLogger.logInfo("Variable '" + name + "' added with initial value: " + value);
    }

    /*
    Function: updateVariable(String name, Object value, String description)
    Time Complexity: O(1)
    */
    public void updateVariable(String name, Object value, String description) {
        if (variables.containsKey(name)) {
            Variable variable = variables.get(name);
            Object oldValue = variable.getValue();
            variable.updateValue(value, description);

            // Check if the variable is being watched and if its value changed
            if (watchpoints.contains(name) && !oldValue.equals(value)) {
                SimpleLogger.logWarning("Watchpoint triggered for '" + name + "'. Execution paused.");
                pauseExecution(name); // Pause execution if watchpoint is triggered
            }
            SimpleLogger.logInfo("Updated Variable: " + name + ", New Value: " + value);
            
            logBreakpoints();
            
         } else {
             SimpleLogger.logWarning("Variable '" + name + "' not found. Adding as new variable.");
             addVariable(name, value);
         }
     }

    /*
    Function: setWatchpoint(String variableName)
    Time Complexity: O(1)
    */
     public void setWatchpoint(String variableName) {
         if (variables.containsKey(variableName)) {
             watchpoints.add(variableName);
             SimpleLogger.logInfo("Watchpoint set on variable '" + variableName + "'.");
         } else {
             SimpleLogger.logWarning("Variable '" + variableName + "' not found. Cannot set watchpoint.");
         }
     }

    /*
    Function: variableInspection(String name)
    Time Complexity: O(1)
    */
     public void variableInspection(String name) {
         if (variables.containsKey(name)) {
             Variable variable = variables.get(name);
             SimpleLogger.logInfo("Current value of '" + name + "': " + variable.getValue());
         } else {
             SimpleLogger.logWarning("Variable '" + name + "' not found.");
         }
     }

    /*
    Function: showVariableHistory(String name)
    Time Complexity: O(n) where n is the number of history entries
    */
     public void showVariableHistory(String name) {
         if (variables.containsKey(name)) {
             Variable variable = variables.get(name);
             SimpleLogger.logInfo("History of '" + name + "':");
             for (Variable.HistoryEntry entry : variable.getHistory()) {
                 SimpleLogger.logInfo("  - " + entry.description + ": " + entry.value);
             }
         } else {
             SimpleLogger.logWarning("Variable '" + name + "' not found.");
         }
     }

    /*
    Function: logBreakpoints()
    Time Complexity: O(m) where m is the number of breakpoints
    */
     public void logBreakpoints() {
         if (breakpoints.isEmpty()) {
             SimpleLogger.logInfo("No breakpoints set.");
             return;
         }

         SimpleLogger.logInfo("Current Breakpoints:");
         for (int line : breakpoints) {
             SimpleLogger.logInfo("Breakpoint Id: " + breakpointId);
             SimpleLogger.logInfo("Breakpoint set at line: " + line);    
         }
     }

    /*
    Function: setBreakpoint(int line)
    Time Complexity: O(1)
    */
     public void setBreakpoint(int line) {
         breakpoints.add(line);
         breakpointId++;
         SimpleLogger.logInfo("Breakpoint set at line: " + line);
     }

    /*
    Function: removeBreakpoint(int line)
    Time Complexity: O(1)
    */
     public void removeBreakpoint(int line) {
         if (breakpoints.remove(line)) {
             SimpleLogger.logInfo("Breakpoint removed from line: " + line);
         } else {
             SimpleLogger.logWarning("No breakpoint found at line: " + line);
         }
     }

    /*
    Function: checkBreakpoint(int line)
    Time Complexity: O(1)
    */
     public boolean checkBreakpoint(int line) {
         return breakpoints.contains(line);
     }

    /*
    Function: pauseExecution(String variableName)
    Time Complexity: O(1) (Theoretically O(1), but waits indefinitely for user input)
    */
     public void pauseExecution(String variableName) {
         System.out.println("\nExecution paused due to change in '" + variableName + "'.");
         
         try {
             System.in.read(); // Wait for user input to resume execution
         } catch (IOException e) {
             e.printStackTrace();
         }
         
         resumeExecution();
     }

    /*
    Function: resumeExecution()
    Time Complexity: O(1)
    */
     public void resumeExecution() {
         System.out.println("\nResuming execution.");
     }
}