import java.util.*;

class Variable {
   private String name;
   private Object value; // Use Object to allow different types (e.g., Integer, List, Map)
   private List<HistoryEntry> history;

   // Inner class to represent a history entry
   public static class HistoryEntry { // Make it public for accessibility
       Object value;
       String description;

       HistoryEntry(Object value, String description) {
           this.value = value;
           this.description = description;
       }
   }

   public Variable(String name, Object value) {
       this.name = name;
       this.value = value;
       this.history = new ArrayList<>();
       this.history.add(new HistoryEntry(value, "Initialized")); // Track initial value
   }

   public void updateValue(Object newValue, String description) {
       if (!newValue.equals(this.value)) { // Only update if value changes
           this.value = newValue;
           this.history.add(new HistoryEntry(newValue, description));
           SimpleLogger.logInfo("Variable '" + name + "' updated: " + description + " -> " + newValue);
       } else {
           SimpleLogger.logInfo("Variable '" + name + "' remains unchanged.");
       }
   }

   public String getName() {
       return name;
   }

   public Object getValue() {
       return value;
   }

   public List<HistoryEntry> getHistory() {
       return history;
   }
}