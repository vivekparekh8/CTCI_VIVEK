package any;

public class AssignChocolates {

	public int[] assignChocolates(int[] ages) {
		int[] assign = new int[ages.length];
		for (int i = 0; i < ages.length; i++) {
			assign[i] = 1;
		}
		for (int i = 1; i < ages.length; i++) {
			if (ages[i] > ages[i-1]) {
				assign[i] = assign[i-1] + 1;
			}
		}
		for (int i = ages.length-2; i >= 0; i--) {
			if (ages[i] > ages[i+1]) {
				assign[i] = assign[i+1] + 1;
			}
		}
		return assign;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ages = new int[]{2, 6, 1, 3, 2, 1, 9};
		AssignChocolates c = new AssignChocolates();
		int[] assign = c.assignChocolates(ages);
		for (int i = 0; i < assign.length; i++) {
			System.out.print(assign[i] + " ");
		}
	}

	static int func(String s, char a, char b) {
		if (s.isEmpty())
			return -1;

		char[] strArray = s.toCharArray();

		int i = 0;
		int aIndex = 0;
		int bIndex = 0;
		//while ()
		while (aIndex == 0 && bIndex == 0 && i < strArray.length) {
			if (strArray[i] == a)
				aIndex = i;
			if (strArray[i] == b)
				bIndex = i;
			i++;
		}
	
		// return aIndex ? (bIndex == 0?aIndex :Math.min(a,b)):(bIndex !=0 ?bIndex :-1);
		if (aIndex != 0) {
			if (bIndex == 0)
				return aIndex;
			else
				return Math.min(a, b);
		} else {
			if (bIndex != 0)
				return bIndex;
			else
				return -1;
		}
	}

}