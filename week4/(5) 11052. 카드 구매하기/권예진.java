import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_bj_11052_카드구매하기_권예진 {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		

		int N = Integer.parseInt(br.readLine());
		int[] card = new int [N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N+1];
		
		for (int i = 1; i < N+1 ; i++) {
			for(int h= 1; h<= i; h++)  {
				dp[i]= Math.max(dp[i], card[h] + dp[i-h]);
			}
			System.out.println(Arrays.toString(dp));
		}
	
		System.out.println(dp[N]);
		
	}
	
}



/*
입력
4
1 5 6 7

출력
[0, 1, 0, 0, 0]
[0, 1, 5, 0, 0]
[0, 1, 5, 6, 0]
[0, 1, 5, 6, 10]
10

1, 2, 3, 4, ..., N 순서대로 최대값(최대 금액을 구한다)

	for (int i = 1; i < N+1 ; i++) {
			for(int h= 1; h<= i; h++)  {
				dp[i]= Math.max(dp[i], card[h] + dp[i-h]);
			}

예를 들면 i  2이면)
카드를 2개를 택할때-> (1개 택, 1개 택 -> 1+1 = 2), (2개 택, 0개 택 -> 5+0 = 5) => 최댓값 5
i가 3이면)
카드를 3개를 택할때-> (1개 택, 2개 택 -> 1+5 = 6), (2개 택, 1개 택 -> 5+1 = 6), (3개 택, 0개 택 -> 6+0) => 최댓값 6

for(int h= 1; h<= i; h++) 앞에서 부터 택하여 중복을 허용한다.
*/
