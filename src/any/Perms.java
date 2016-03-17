package any;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Perms {
	public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
            	System.out.println(strNew+"+"+initial);
                perm.add(charInsert(strNew, initial, i));
                System.out.println(perm.size()+"-"+charInsert(strNew, initial, i));
            }
        }
        System.out.println("Size"+perm.size());
        return perm;
    }
 
    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
    	returnList.add(new ArrayList<Integer>());
     
    	for (int i = 0; i < num.length; i++) {
    		Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
    		for (ArrayList<Integer> l : returnList) {
    			for (int j = 0; j < l.size() + 1; j++) {
    				l.add(j, num[i]);
    				ArrayList<Integer> T = new ArrayList<Integer>(l);
    				l.remove(j);
    				System.out.println(T);
    				currentSet.add(T);
    			}
    		}
    		returnList = new ArrayList<ArrayList<Integer>>(currentSet);
    	}
     
    	return returnList;
    }
 
    public static void main(String[] args) {
        //String s = "AAC";
       // String s1 = "ABC";
        String s2 = "ABCD";
        int[] n={1,2,3};
       // System.out.println("\nPermutations for " + s + " are: \n" + permutationFinder(s));
        //System.out.println("\nPermutations for " + s1 + " are: \n" + permutationFinder(s1));
        System.out.println("\nPermutations for " + s2 + " are: \n" + permuteUnique(n));
    }
}
