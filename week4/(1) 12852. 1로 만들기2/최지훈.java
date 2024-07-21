package week4;

import java.io.*; 
import java.util.*; 
public class p1_12852_1로만들기2_cjh {
	static int N; 
	static int[] dp,pro; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;  
		One(); 
		System.out.println(dp[N]);
		Trace(N); 
	}
	static void One() {
		for(int i = 2 ; i < N+1 ; i++) {			
			if (i % 3 == 0 && i % 2 == 0) {dp[i] = Math.min(dp[i - 1] + 1, dp[ i  / 3] + 1);dp[i] = Math.min(dp[i], dp[ i  / 2] + 1);}
			else if (i % 2 == 0) {dp[i] = Math.min(dp[i - 1] + 1, dp[ i  / 2] + 1);}
			else if (i % 3 == 0) {dp[i] = Math.min(dp[i - 1] + 1, dp[ i  / 3] + 1);}
			else dp[i] = dp[i - 1]  + 1; 
		}
	}
	static void Trace(int cnt) {
		if(cnt == 1) {System.out.println(1);return; }
		if (cnt % 3 == 0 && cnt % 2 == 0) {
			if(dp[cnt / 3] == dp[cnt] - 1) {
				System.out.print(cnt + " "); Trace(cnt / 3); return; 
			}
			else if(dp[cnt / 2] == dp[cnt] - 1) {
				System.out.print(cnt + " "); Trace(cnt / 2); return; 
			}
			else {
				System.out.print(cnt + " "); Trace(cnt - 1); return; 
			}
		}
		else if (cnt % 2 == 0) {
			if(dp[cnt / 2] == dp[cnt] - 1) {
				System.out.print(cnt + " "); Trace(cnt / 2); return; 
			}
			else {
				System.out.print(cnt + " "); Trace(cnt - 1); return; 
			}
		}
		else if (cnt % 3 == 0) {
			if(dp[cnt / 3] == dp[cnt] - 1) {
				System.out.print(cnt + " "); Trace(cnt / 3); return; 
			}
			else {
				System.out.print(cnt + " "); Trace(cnt - 1); return; 
			}
		}
		else {System.out.print(cnt + " "); Trace(cnt - 1); return; }
	}
	
}
