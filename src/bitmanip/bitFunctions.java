package bitmanip;

import java.util.HashSet;
import java.util.Iterator;

public class bitFunctions {
	//get nth bit from left
	public static boolean getBit(int n,int i){
		return ((n & (1<<i-1)) ==0)?false:true;
	}
	public static int getSingleNumberFromArray(int [] arr){
		int x=0;
		for(int a : arr){
			x= x^a;
		}
		return x;
	}
	public static int maxBinaryGap(int a){
		int count = -1,max=0,temp=0; 
		while(a>0){
			 temp = a&1;
			 a >>=1;
			 if(temp ==0 && count >= 0){
				 System.out.println(count);
				 count++;
			 }
			 if (1 == temp) {
					max = count > max ? count : max;
					count = 0;
			}
			
		}
		return max;
	}
	public static int singleNumber(int[] A) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int n : A) {
			if (!set.add(n))
				System.out.println(n+""+set.remove(n));
		}
		System.out.println(set.size());
		Iterator<Integer> it = set.iterator();
		return it.next();
	}
	//Doubt
	public static int singleNumberotherThrees(int[] A) {
	    int ones = 0, twos = 0, threes = 0;
	    for (int i = 0; i < A.length; i++) {
	        twos |= ones & A[i];
	        System.out.println(twos);
	        ones ^= A[i];
	        threes = ones & twos;
	        ones &= ~threes;
	        twos &= ~threes;
	    }
	    return ones;
	}
	public static int noofones(int x){
		int total_ones = 0;
		  while (x != 0) {
			  System.out.println("Before"+x);
		      int temp = x & (1);
		      System.out.println("After"+x);
		      
		      if (temp==1)
		    	  total_ones++;
		      x = x>>1;
		  }
		  return total_ones;
	}
	public static int reverseBits(int n){
		
		return n;
	}
	public static void main(String [] arg){
		System.out.println("nth bit from left"+getBit(21,2));
		int[] n={
				2,3,4,4,4,3,5,5,5,3
		};
		System.out.println("Single from array:"+singleNumber(n));
		System.out.println("Max Bin gap:"+maxBinaryGap(9));
		System.out.println("No of ones"+noofones(21));
		System.out.println("Reverse Bits"+reverseBits(21));
		System.out.println(9^15);
	}
}
