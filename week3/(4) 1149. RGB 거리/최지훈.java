import java.io.*; 
import java.util.*; 

public class Main {
	static int[][] house;
	static int[][] dp; 
	static int ans;
	static int N; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		house =  new int[N][3]; 
		   dp =  new int[N][3]; 
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				int a = Integer.parseInt(st.nextToken());
				house[i][j] = a; 
			}		
		}
		price(0);
	}
	static void price(int cnt) { 
		if(cnt == 0) {
			for(int i = 0; i < 3; i++)  {
				dp[0][i] = house[0][i];
			}
			cnt+=1; 
			price(cnt);
			return;                                                                    //초기값 선언부분
		}
		else {
		dp[cnt][0] = house[cnt][0] + Math.min(dp[cnt-1][1], dp[cnt-1][2]);
		dp[cnt][1] = house[cnt][1] + Math.min(dp[cnt-1][0], dp[cnt-1][2]);
		dp[cnt][2] = house[cnt][2] + Math.min(dp[cnt-1][0], dp[cnt-1][1]); // 이후 최소값 dp로 구하는 부분 
		
		if(cnt == N-1) {
			int a = Math.min(dp[N-1][0], dp[N-1][1]);
			  ans = Math.min(         a, dp[N-1][2]);
			System.out.println(ans);  
			return;                                 // 종료조건- 끝나면 마지막 최소값 3개 비교해서 가장 작은거 출력 
			}
		cnt+=1; 
		price(cnt); // 반복구문 
		}
		return; 
	}

}
/*
 8
71 39 44     71  39  44
32 83 55     71  127 94
51 37 63     145 108 134
89 29 100    197 163 208
83 58 11     246 255 174
65 13 15     239 187 261
47 25 29     234 264 216
60 66 19     276 282 253  21323213
253
 */
