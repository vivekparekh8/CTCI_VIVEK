package linkedlists;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
 
public class LRUCache < K, V > extends LinkedHashMap < K, V > {
 
    private int capacity; // Maximum number of items in the cache.
     
    public LRUCache(int capacity) { 
        super(capacity, 1.0f, true); // Pass 'true' for accessOrder.
        this.capacity = capacity;
    }
     
    protected boolean removeEldestEntry(Entry entry) {
        return (size() > this.capacity);
    } 
    public static void main(String [] arg){
    	LRUCache<String,Integer> new1= new LRUCache<>(3);
    	new1.put("Vivek", 1);
    	new1.put("Aadit", 2);
    	new1.put("Aait", 3);
    	new1.put("Aaeit", 3);
    	System.out.println(new1.values());
    }
}