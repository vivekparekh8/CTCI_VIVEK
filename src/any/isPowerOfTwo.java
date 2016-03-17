package any;

public class isPowerOfTwo {
	public static boolean isPowerOfTwoOrNot(int n) {
	    if(n<=0 || n%2!=0) 
	        return false;
	 
	    while(n>2){
	        int t = n>>1;
	        int c = t<<1;
	        System.out.println(t+":::"+c);
	        if(n-c != 0)
	            return false;
	 
	        n = n>>1;
	    }
	 
	    return true;
	}
	public static void main(String [] arg){
		System.out.println("VVV"+isPowerOfTwoOrNot(256));
	}
	
}
