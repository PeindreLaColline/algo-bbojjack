package week9;

import java.io.*; 
import java.util.*; 

public class p2_14728_벼락치기 {
	static int N,T, K, S ; 
	static int[][] pro, dp; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); 
		T = Integer.parseInt(st.nextToken()); 
		pro = new int[N+1][2]; 
		dp = new int[N+1][T + 1]; 
		for(int i = 1; i <= N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine()); 
			K = Integer.parseInt(st2.nextToken()); 
			S = Integer.parseInt(st2.nextToken()); 
			pro[i][0] = K; 
			pro[i][1] = S; 
		}
		 for (int i = 1; i < N + 1; i++) {
			    for (int k = 1; k < T + 1; k++) {
			      int itemWeight = pro[i][0];
			      if (itemWeight > k)
			        dp[i][k] = dp[i - 1][k];
			      else {
			        dp[i][k] = Math.max(dp[i - 1][k], pro[i][1] + dp[i - 1][k - itemWeight]);
			      }
			    }
			  }
		 System.out.println(dp[N][T]); 
	}
}
