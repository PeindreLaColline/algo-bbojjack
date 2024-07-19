package week4;

import java.io.*; 
import java.util.*; 

public class p3_2193_이친수_cjh {
	static long[] dp; 
	static int N; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N  = Integer.parseInt(br.readLine());
		dp = new long[N];
		pibo();
		System.out.println(dp[N - 1]);
	}

	private static void pibo() {
		if(N == 1) {dp[0] = 1; }  
		else if ( N == 2) {dp[0] = 1; dp[1] = 1;   }
		else {
			dp[0] = 1; dp[1] = 1;  
			for(int i = 2; i < N; i++) {
				dp[i] = dp[i - 1]  + dp[i - 2];
			}
		}
		return; 
	}

}
