package week8;

import java.io.*; 
import java.util.*; 

public class p5_11909_배열탈출_cjh {
	static int n;
	static int[][] A,dp; 
	static int[] ni = {1,0}; 
	static int[] nj = {0,1}; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		n = Integer.parseInt(br.readLine()); 
		A = new int[n+1][n+1]; 
		dp = new int[n+1][n+1]; 
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			for(int j = 1; j <= n; j++) {
				A[i][j] = Integer.parseInt(st.nextToken()); 
				dp[i][j] = Integer.MAX_VALUE; 
			}
		}
		 dp[1][1] = 0; //시작점은 1 
		 
		 int t = 0; // 이동하는 배열 사이 값 차이

	        for(int i=1;i<=n;i++){
	            for(int j=1;j<=n;j++){
	                if(i == n && j == n) break; //도착지 도착 시 탈출
	                if(i != n){
	                    if(A[i+1][j] >= A[i][j]){ ///이동 못할 시
	                        t = A[i+1][j] - A[i][j]+1; //버튼 눌러서 값 올려주기
	                        dp[i+1][j] = Math.min(dp[i+1][j],t+dp[i][j]);
	                    }
	                    else{
	                        dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]);
	                    }
	                }
	                if(j != n){
	                    if(A[i][j+1] >= A[i][j]){ ///이동 못할 시
	                        t = A[i][j+1] - A[i][j]+1; //버튼 눌러서 값 올려주기
	                        dp[i][j+1] = Math.min(dp[i][j+1],t+dp[i][j]);
	                    }
	                    else{
	                        dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]);
	                    }
	                }
	            }
	        }
		 
		System.out.println(dp[n][n]); 
	}


}
