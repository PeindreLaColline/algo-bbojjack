import java.io.*; 
import java.util.*; 

public class Main {
    static int MOD = 9901;
    public static void main(String[] args) throws Exception{
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sc.readLine());
        int[][] dp = new int[N + 1][3];

        // 초기값 설정
        dp[1][0] = 1; // 열에 없는 경우
        dp[1][1] = 1; // 열에 왼쪽칸에 있는 경우
        dp[1][2] = 1; // 열에 오른쪽칸에 있는 경우

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        int result = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;
        System.out.println(result);
    }
}
