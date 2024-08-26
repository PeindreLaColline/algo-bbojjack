
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_bj_7579_앱_권예진 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] a = new int[N][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i][0] = Integer.parseInt(st.nextToken()); // 메모리 바이트 수
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i][1] = Integer.parseInt(st.nextToken()); // 비활성화 했을 경우의 비용
        }

        int[] dp = new int[10001]; // 앱의 갯수 (100) * 비용의 최대 (100) == 10000 + 1 / 비용이 인덱스 , 메모리 바이트가 값
        for (int i = 0; i < N; i++) {
            for (int j = 10000; j >= 0 ; j--) {
                if(a[i][1]<=j) dp[j] = Math.max(dp[j], dp[j-a[i][1]]+a[i][0]);
            }
        }

        for (int i = 0; i < 10001; i++) { // 가장 먼저 필요한 메모리를 확보한 인덱스가 최소 비용!
            if(dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}


