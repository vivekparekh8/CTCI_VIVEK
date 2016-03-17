package any;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NoofEvenNumbered {
	public static void findEvenOccurringNumbers(int[] a)
	{
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();

		for (int num : a)
		{
			if (hash.containsKey(num))
			{
				hash.put(num, hash.get(num) ^ 1);
			}
			else
			{
				hash.put(num, 1);
			}
		}

		for (Entry<Integer, Integer> entry : hash.entrySet())
		{
			if (entry.getValue() == 0)
			{
				System.out.println(entry.getKey());
			}
		}
	}

}
