
public class Sample {

    public void methodA() {

        System.out.println("\nMethod A executed.");

    }

    public void methodB() {

        System.out.println("\nEntering Method B...");

        methodA();

        System.out.println("\nMethod B executed.");

    }

    public static void main(String[] args) {

        ExecutionFlowManager manager = new ExecutionFlowManager();

        StepExecution stepManager = new StepExecution(manager);

        // Read methods from Sample.java file

        manager.readFile("Sample.java");

        // Simulate calling functions with different step controls and logging.

        System.out.println("\nStarting step execution...\n");

        stepManager.stepInto("methodB"); // Enters methodB and any calls within it

        stepManager.stepOver("methodA"); // Skips over methodA's internals

        stepManager.stepOut(); // Exits the current method (methodB)

        manager.debugger.addVariable("x", 10); // Add a test variable.

        manager.debugger.setWatchpoint("x"); //Set the watchpoint on the variable x

        manager.debugger.setBreakpoint(10); // Set a breakpoint.

        manager.debugger.updateVariable("x", 15, "Assignment at line 1");

        manager.debugger.showVariableHistory("x"); // Show history.

        manager.debugger.variableInspection("x");

        Runnable task1 = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("\nTask 1 executed.");
            } catch (InterruptedException e) {
            }
        };

        Runnable task2 = () -> {
            try {
                Thread.sleep(500);
                System.out.println("\nTask 2 executed.");
            } catch (InterruptedException e) {
            }
        };

        manager.getThreadManager().addThread(task1, 2, "Low Priority Task");

        manager.getThreadManager().addThread(task2, 1, "High Priority Task");

        manager.getThreadManager().startNextThread(); // Start high-priority first.

        manager.getThreadManager().startNextThread(); // Start low-priority next.

        System.out.println("\nFinal Execution Flow:");

        manager.displayExecutionFlow();

        System.out.println("\nResuming program execution...");

        manager.debugger.resumeExecution();

        System.out.println("\nExecution complete.");

    }

}