package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_bj_11053_가장긴증가하는부분수열_권예진 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		

		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int [] S = new int [N+1];
		for (int i = 1; i < N+1; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		int[]dp = new int[N+1];
		int max = 0;
		for (int i = 1; i < N + 1 ; i++) {
			dp[i]= 1;
			for(int k = 1; k <= i; k++) {
				if(S[i] > S[k] && dp[i] < dp[k] + 1) {
					dp[i] = dp[k] + 1;}
			}
			max = Math.max(max, dp[i]);
			}
		System.out.println(max);
		}
	}
