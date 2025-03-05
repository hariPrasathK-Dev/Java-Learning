import java.util.List ;
import java.sql.Time;
import java.util.ArrayList ;

public class MyHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] table;
    private int capacity = 16; // Default capacity
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new Entry[capacity];
    }

    //nsert (put):Time Complexity: O(1) on average for inserting a key-value pair due to direct indexing, 
    //but can degrade to O(n) in worst-case scenarios (e.g., many collisions).
    public void put(K key, V value) {
        int index = Math.abs(key.hashCode() % capacity);
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value; // Update existing value
                    return;
                }
                current = current.next;
            }
            current.next = newEntry; // Add to the end of the chain
        }
        size++;
    }

    //Time Complexity: O(1) on average for retrieving a value by key, with potential degradation to O(n).
    public V get(K key) {
        int index = Math.abs(key.hashCode() % capacity);
        Entry<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Key not found
    }

    //Time Complexity: O(1) on average.
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    public List<K> keySet() {
        List<K> keys = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                keys.add(entry.key);
                entry = entry.next;
            }
        }
        return keys;
    }
}