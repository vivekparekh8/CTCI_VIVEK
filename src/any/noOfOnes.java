package any;

public class noOfOnes {
	public static int hammingWeight(int x) {
//	    int count = 0;
//	    for(int i=1; i<5; i++){
//	        if(getBit(n, i) == true){
//	            count++;
//	        }
//	    }
//		int number_of_ones(unsigned int x) {
			  int total_ones = 0;
			  while (x != 0) {
				  System.out.println("Before"+x);
			      x = x & (x-1);
			      System.out.println("After"+x);
				  total_ones++;
			  }
			 
//			}
//	    return count;
			  return total_ones;
	}
	public static int firstMissingPositive(int[] A) {
        int n = A.length;
 
    	for (int i = 0; i < n; i++) {
    		while (A[i] != i + 1) {
    			if (A[i] <= 0 || A[i] >= n)
    				break;
 
                	if(A[i]==A[A[i]-1])
                    		break;
 
    			int temp = A[i];
    			A[i] = A[temp - 1];
    			A[temp - 1] = temp;
    		}
    	}
 
    	for (int i = 0; i < n; i++){
    		if (A[i] != i + 1){
    			return i + 1;
    		}
    	}	
 
    	return n + 1;
}
	public static boolean getBit(int n, int i){
		System.out.println(n & (1 << i));
	    return (n & (1 << i)) != 0;
	}
	public static void main(String [] arg){
		int[] n={1,2,3,100};
		System.out.println("VVV"+hammingWeight(10));
		System.out.println("1st Missing +v"+firstMissingPositive(n));
	}
}
