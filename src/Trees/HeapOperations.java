package Trees;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapOperations {
	static PriorityQueue<Integer> hHigh  = new PriorityQueue<Integer>(100, 
	        new Comparator<Integer>() {
	    public int compare (Integer o1, Integer o2) {
	        return o1.compareTo(o2);
	    }
	});

	static PriorityQueue<Integer> hLow  = new PriorityQueue<Integer>(100, 
	        new Comparator<Integer>() {
	    public int compare (Integer o1, Integer o2) {
	        return -o1.compareTo(o2);
	    }
	});

	public static void addToStream (int k) {
	    if (hHigh.size() == 0 || k > hHigh.peek()){
	        hHigh.add(k);
	    }

	    else {
	        hLow.add(k);
	    }

	    if (hLow.size() > (hHigh.size() + 1)) {
	        hHigh.add(hLow.poll());
	    }
	    if (hHigh.size() > hLow.size()){
	        hLow.add(hHigh.poll()); 
	    }
	}

	public static void main(String[] args) {
	    addToStream(3104);
	    addToStream(6185);
	    addToStream(7818);
	    addToStream(2106);
	    addToStream(5480);
	    
	    System.out.println(hLow.peek());
	}
}
