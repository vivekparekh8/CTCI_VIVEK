package String_Array;

import java.util.HashMap;
import java.util.Map;

public class CTCI_String_Array {
	public static void rotateImage(int[][] m){
		int y=m[0].length,x=m.length;
		int [][] n = new int [m[0].length][m.length];
		int k=0;
		for(int i=x-1;i>=0;i--){
			for(int j=0;j<y;j++){
				n[j][x-1-i] = m[i][j];
				System.out.print(x-1-i+":"+n[j][x-1-i]+"-"+j+"-"+" ");
			}
			System.out.println();
		}
	}
	public static String getRecurrence(int numerator, int deno){
		if(deno == 0) return "NaN";  
	    if(numerator == 0) return "0";  
	    // 
	    String sign ="";
	    if(numerator<0 || deno<0){
	    	sign = "-";
	    }else if(numerator<0 && deno<0){
	    	sign = "";
	    }
	      
	   
	    long num = numerator, den = deno;  
	    num = Math.abs(num);  
	    den = Math.abs(den);  
	    int i=0;
	    long major = num / den;  
	    long rem = num % den;  
	    if(rem == 0) return sign+major;  
	      
	    StringBuilder ans = new StringBuilder(sign + major + '.');  
	    Map<Long, Integer> map = new HashMap<Long, Integer>();  
	    while(rem != 0) {  
	    	i++;
	        if(map.containsKey(rem)) {  
	            int index = map.get(rem);  
	            ans.insert(index, '(').append(')');  
	            break;  
	        } else {  
	            ans.append(rem * 10 / den);  
	            map.put(rem, ans.length()-1);  
	        }  
	        rem = rem * 10 % den;  
	    }  
	    System.out.println("iteration "+i);
	    return ans.toString();  
	}
	public static boolean hasUniqueChars(String s){
		int checker=0;
		for(char c:s.toCharArray()){
			int temp = c - 'a';
			if((checker & 1<<temp) == 1){
				return false;
			}
			checker |= 1<<temp; 
		}
		return true;
	}
	public static char[] reverseString(String s){
		int i=0,j=s.length()-1;
		if(s.length()==0){
			return null;
		}
		char[] ss = new char[s.length()];
		System.out.println("j"+j+s.charAt(j));
		while(i<j){
			char temp = s.charAt(i);
			ss[i++] = s.charAt(j);
			ss[j--] = temp;
			System.out.println(i+""+j);
		}
		return ss;
	}
	public static void removeDup(char[] in){
		if(in.length<2){ return;}
		boolean flag = false;
		int tail = 0;
		for(int i=0;i<in.length;i++){
			flag = false;
			for(int j=0;j<i;j++){
				if(in[i]==in[j]){
					flag = true;
					break;
				}
			}
			if(flag){
				continue;
			}
			System.out.println(in[i]);
			in[tail] = in[i];
			tail++;
		}	
		
		in[tail]='\0';
		System.out.println(in);
	}
	public static void main(String[] arg){
		String a="aa";
		System.out.println(hasUniqueChars("aad"));
		System.out.println(reverseString("ad"));
		System.out.println("----");
		removeDup("pppk".toCharArray());
		System.out.println("----");
		int[][] mat ={{1,2,3,4},{5,6,7,8},{9,10,11,12}}; 
		rotateImage(mat);
		System.out.println(getRecurrence(1,6));
	}
}
