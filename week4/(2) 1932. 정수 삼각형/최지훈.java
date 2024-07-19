import java.io.*; 
import java.util.*; 

public class p2_1932_정수삼각형_cjh {
	static int dp[][],pro[][]; 
	static int N; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N][N];
		pro = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j <=i ; j++ ) {
				pro[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {Arrays.fill(dp[i], 0);}
		dp[0][0] = pro[0][0]; 
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j <=i ; j++ ) {
				dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + pro[i+1][j]);
				dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + pro[i+1][j+1]);
			}
		}
		int max = -1;
		for(int i = 0; i < N; i++) {max = Math.max(max, dp[N-1][i]);}
		System.out.println(max);
	}

}
