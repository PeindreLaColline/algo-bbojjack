import java.io.*; 
import java.util.*; 

public class Main {
	static int N,ans= 0,max = 0, min = 1001;
	static int[] pro;
	static int[] dp ; 
	public static void main(String[] args) throws Exception {	
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pro = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			pro[i] = a; 
		}
		System.out.println(longest());
	}
    static int longest() {
        int maxLength = 1;
        Arrays.fill(dp, 1); // 각 원소의 초기 부분 수열 길이를 1로 설정

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (pro[i] > pro[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }

}
