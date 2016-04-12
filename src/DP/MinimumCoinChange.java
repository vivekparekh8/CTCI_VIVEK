package DP;

public class MinimumCoinChange {
	public static void main(String arg[]){
		int[] val = {1,2,5};
		int p = 25;
		int [] change = new int[p+1];
		int [] changeFinal = new int[p+1];
		changeFinal[0] = 0;
		int min = 999;
		for(int i=1;i<=p;i++){
			for (int j = 0; j < change.length; j++) {
				change[j] = -1;
			}
			for(int k=0;k<val.length;k++){
				if(val[k]<=i){
					change[k] = changeFinal[i - val[k]] + 1;
				}
			}
			changeFinal[i] = -1;
			for(int j=1;j<change.length;j++){
				if(change[j]>0 && (changeFinal[i]==-1 || changeFinal[i]>change[j])){
					changeFinal[i]=change[j];
				}
			}
		}
		System.out.println(changeFinal[p]);
	}
}
