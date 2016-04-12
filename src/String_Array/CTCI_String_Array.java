package String_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
	public static int fib(int n){
		int ans[] = new int[n];
		ans[0] = 0;
		ans[1] = 1;
		for(int i=2;i<n;i++){
			ans[i]=ans[i-1]+ans[i-2];
		}
		return ans[n-1];
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
	public static List<String> anagrams(String[] strs) {
	    ArrayList<String> result = new ArrayList<String>();
	    if(strs == null || strs.length == 0)
	        return result;
	 
	    HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
	    for(int i=0; i<strs.length; i++){
	        char[] arr = strs[i].toCharArray();
	        Arrays.sort(arr);
	        String t = String.valueOf(arr);
	        if(map.get(t) == null){
	            ArrayList<Integer> l = new ArrayList<Integer>();
	            l.add(i);
	            map.put(t, l);
	        }else{
	            map.get(t).add(i);
	        }
	    }
	 
	    for(ArrayList<Integer> l: map.values()){
	        if(l.size() > 1){
	            for(Integer i: l){
	                result.add(strs[i]);
	            }
	        }
	    }
	 
	    return result;
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
			System.out.println(in[i]+""+flag+""+i);
			in[tail] = in[i];
			tail++;
		}	
		
		in[tail]='\0';
		System.out.println(in);
	}
	public static void findUnique(int[] arr, int low, int high){
		int mid = (low+high)/2;
		if(low>high){
			return ;
		}
		if(low == high){
			System.out.println(arr[low]);
			return;
		}
		if(mid % 2 ==0){
			if(arr[mid] == arr[mid+1]){
				findUnique(arr,mid+2,high);
			}else{
				findUnique(arr,low,mid);
			}
		}else{
			if(arr[mid] == arr[mid-1]){
				findUnique(arr,mid-2,high);
			}else{
				findUnique(arr,low,mid-1);
			}
		}
			
	}
	public static void sumEqual(int[] arr,int n){
		boolean[] b = new boolean[100];
		for(boolean v:b){
			v=false;
		}
		int temp=0;
		for(int i=0;i<arr.length;i++){
			temp = n - arr[i];
			if(temp>=0 && b[temp]){
				System.out.println(temp+":"+arr[i]);
			}
			b[arr[i]] = true;
		}
		
	}
	public static int[] removeDuplicates(int a[]) {
        int previousElement = a[0];
        int pos = 0;
        for(int i=1; i < a.length; i++) {
            int currentElement = a[i];
            if((currentElement ^ previousElement) == 0) {
                // Same Element again
            } 
            else {
            	previousElement = currentElement;
                pos++;
                a[pos] = currentElement;
            }
        }
        return Arrays.copyOf(a, pos+1);
    }  
	public static String longestCommonPrefix(String[] strs) {
	    if(strs == null || strs.length == 0)
	        return "";
	 
	    int minLen=Integer.MAX_VALUE;
	    for(String str: strs){
	        if(minLen > str.length())
	            minLen = str.length();
	    }
	    if(minLen == 0) return "";
	 
	    for(int j=0; j<minLen; j++){
	        char prev='0';
	        for(int i=0; i<strs.length ;i++){
	            if(i==0) {
	                prev = strs[i].charAt(j);
	                continue;
	            }
	 
	            if(strs[i].charAt(j) != prev){
	                return strs[i].substring(0, j);
	            }
	        }
	    }
	    
	    return strs[0].substring(0,minLen);
	}
	public static void pascal(int n){
		ArrayList<LinkedList<Integer>> num = new ArrayList<>();
		LinkedList<Integer> temp = new LinkedList<>();
		temp.add(1);
		num.add(temp);
		temp = new LinkedList<>();
		temp.add(1);
		temp.add(1);
		num.add(temp);
		temp = new LinkedList<>();
		temp.add(1);
		temp.add(2);
		temp.add(1);
		num.add(temp);
		
		temp =null;
		for(int i=3;i<=n;i++){
			int k=0;
			LinkedList<Integer> li = num.get(i-1);
			
			System.out.println("pela"+li.toString());
			LinkedList<Integer> newli = new LinkedList<>();
				for(int x=0;x<=i;x++){
					if(x==0 || x==i){
						newli.offer(1);
					}else {
						System.out.println(li.peek());
						newli.offer(li.poll()+li.peek());
						System.out.println(newli.toString());
					}
				}
				if(newli.size()!=1)
					num.add(newli);
			System.out.println("hh"+num.toString());
		}
	}
	public static void main(String[] arg){
		String a="aa";
		System.out.println(hasUniqueChars("aad"));
		System.out.println(reverseString("ad"));
		System.out.println("----");
		
		System.out.println("----");
		int[][] mat ={{1,2,2,3,4,4},{5,6,7,8},{9,10,11,12}}; 
		//rotateImage(mat);
		System.out.println(getRecurrence(1,6));
		int [] arr = {11,11,22,33,33,44,44};
		findUnique(arr,0,arr.length-1);
		System.out.println("-------------");
		sumEqual(arr, 33);
		String arrii[] = {"ab","ba"};
		System.out.println("::"+longestCommonPrefix(arrii));
		System.out.println(anagrams(arrii));
		removeDup("pkp".toCharArray());
		System.out.println(fib(8));
		pascal(6);
	}
}
