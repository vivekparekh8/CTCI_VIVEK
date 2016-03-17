package any;

public class PrimeLessthanN {
	public static Integer primeNo(int n){
		Boolean[] primes = new Boolean[n+1];
		Integer out = 2;
		for(int i=2;i<=n;i++){
			primes[i] = true;
		}
		for(int i=2;i<Math.sqrt(n-1);i++){
			if(primes[i]){
				for(int j=i+i;j<n;j=j+i){
						primes[j] = false;
				}
			}
		}
		for(int i=n-1;i>=2;i--){
			if(primes[i]){
				out = i;
				System.out.println(i);
				break;
			}
		}
		return out;
	}
	public static void main(String[] args){
		primeNo(81);
	}
}
