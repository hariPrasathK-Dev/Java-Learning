import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class SimpleLogger {

    private static final Logger logger = Logger.getLogger(SimpleLogger.class.getName());

    public static void setupLogger() {
        try {
            // Remove existing handlers to prevent duplicate logging
            for (Handler handler : logger.getHandlers()) {
                logger.removeHandler(handler);
            }

            logger.setLevel(Level.ALL);

            // Create logs directory if it doesn't exist
            File logDir = new File("logs");
            if (!logDir.exists()) {
                logDir.mkdir(); // Create the directory
            }

            // Console handler for logging to the console
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.INFO);
            logger.addHandler(consoleHandler);

            // File handler for logging to a file
            FileHandler fileHandler = new FileHandler("logs/simplelog.log", true);
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to log an info message
    public static void logInfo(String message) {
        logger.info(message);
    }

    // Function to log a warning message
    public static void logWarning(String message) {
        logger.warning(message);
    }

    // Function to log an error message
    public static void logError(String message) {
        logger.severe(message);
    }
}