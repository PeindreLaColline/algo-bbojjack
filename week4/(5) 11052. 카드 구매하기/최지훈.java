package week4;

import java.io.*; 
import java.util.*; 

public class p5_11052_카드구매하기 {
	static int N; 
	static int[] pro,dp;  
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		pro = new int[N+1];
		dp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		pro[0] = 0;dp[0] = 0;  
		for(int i = 1; i <= N; i++) {
			pro[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(dp, -1);
		dp[0] = 0;dp[1] = pro[1];  
		for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + pro[j]);
            }
        }
		System.out.println(dp[N]);
	}

}
