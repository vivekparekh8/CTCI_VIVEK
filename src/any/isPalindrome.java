package any;

public class isPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Class thisii = null;
		int a = 100;
		int n = a;
	       //reversing number
	       int rev=0,rmd; 
	       while(a > 0) 
	       { 
	         rmd = a % 10; 
	         rev = rev * 10 + rmd; 
	         a = a / 10; 
	       } 
	       // Reverse a number 100 to 001
	       int temp = 100;
	       while(temp>0){
	    	   int rem = temp % 10;
	    	   if( rem == 0){
	    		   System.out.print("0");
	    	   }else{
	    		   System.out.print(rem);
	    	   }
	    	   temp = temp /10; 
	       }
	       System.out.println(":"+rev);
	       if(rev == n) 
	         System.out.println(n+" is a Palindrome Number!"); 
	       else
	         System.out.println(n+" is not a Palindrome Number!"); 
	     } 
	

}
