import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] dp, pro;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 동전의 종류 개수와 목표 금액 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        // 동전의 종류 입력
        pro = new int[n];
        for (int i = 0; i < n; i++) {
            pro[i] = Integer.parseInt(br.readLine());
        }
        
        // DP 배열 초기화
        dp = new int[k + 1];
        
        // 결과 출력
        System.out.println(coin());
    }

    static int coin() {
        dp[0] = 1; // 0원을 만드는 경우의 수는 1가지 (아무 동전도 사용하지 않는 경우)
        
        for (int i = 0; i < n; i++) {
            for (int j = pro[i]; j <= k; j++) {
                dp[j] += dp[j - pro[i]];
            }
        }
        
        return dp[k];
    }
}
