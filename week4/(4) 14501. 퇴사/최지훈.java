
import java.io.*; 
import java.util.*; 


//DP를 사용해 맨 뒤 날짜부터 그날부터 퇴사일까지 얻을 수 있는 금액 최댓값을 구하면서 앞으로 하나씩 업데이트 해준다 

public class p4_14501_퇴사_cjh {
	static int[] day, cost,dp; 
	static int N; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		day = new int[N];
		cost = new int[N];
		dp = new int[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(dp, 0);
		exit(N-1); 
	}
	static void exit(int index) {
		 if (index < 0) { System.out.println(dp[0]); return;}                               // 기본 재귀 종료 조건
		if(index == N -  1) {
			if(day[index] == 1) dp[index] = cost[index];
			else dp[index] = 0; 
			index-= 1; 
			exit(index);
			return ; 
		}
		if(N - index < day[index]) {
			if(index == N - 1) dp[index] = 0; 
			else dp[index] = dp[index + 1];                                                   //퇴사일까지 완료할 수 없는 경우 
		} 
		else if ( N == index + day[index]) dp[index] =  Math.max(dp[index+1], cost[index]); //퇴사일에 딱 끝내는 경우 
		else {
			dp[index]  = Math.max(dp[index+1], cost[index] + dp[index + day[index]]);         //퇴사일 전에 끝낼 수 있는 경우-- dp로 끝내는 날로 이동해 그 날의 최댓값이랑 더해줌 
		}
		exit(index - 1);
		return; 
	}

}
