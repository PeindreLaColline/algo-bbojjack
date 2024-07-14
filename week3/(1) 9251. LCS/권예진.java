import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_bj_9251_LCS_권예진 {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		

		String N = br.readLine();
		String K = br.readLine();
		
		char [] w = new char[N.length()+1];
		char [] v = new char[K.length()+1];
		
		for (int i = 1; i < N.length()+1; i++) {
			w[i] = N.charAt(i-1);

		}
		for (int i = 1; i < K.length()+1; i++) {
			v[i] = K.charAt(i-1);

		}
		int[][] dp = new int[N.length()+1][K.length()+1];
		for (int i = 1; i < N.length()+1 ; i++) {
			for(int h= 1; h< K.length()+1; h++)  {
				if(w[i] == v[h]) {
					dp[i][h]  = dp[i-1][h-1] + 1;} // 같으면 대각선 위 + 1
				
			else {
					dp[i][h]= Math.max(dp[i-1][h],dp[i][h-1]); //다르면 옆이나 위에 값 비교
					}
				}
			}
		
		System.out.println(dp[N.length()][K.length()]);
	}
	
}



