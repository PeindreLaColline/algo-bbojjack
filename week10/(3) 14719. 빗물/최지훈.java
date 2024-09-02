import java.io.*; 
import java.util.*; 

public class Main {
    static int H, W, ans = 0;
    static int[] width;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        width = new int[W];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            width[i] = Integer.parseInt(st2.nextToken());
        }

        int[] leftMax = new int[W];
        int[] rightMax = new int[W];

        // 좌측에서 최대 높이 계산
        leftMax[0] = width[0];
        for (int i = 1; i < W; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], width[i]);
        }

        // 우측에서 최대 높이 계산
        rightMax[W - 1] = width[W - 1];
        for (int i = W - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], width[i]);
        }

        // 물이 고일 수 있는 양 계산
        for (int i = 0; i < W; i++) {
            int waterHeight = Math.min(leftMax[i], rightMax[i]);
            if (waterHeight > width[i]) {
                ans += waterHeight - width[i];
            }
        }

        System.out.println(ans);
    }
}
