import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max;
    static int[][] S;
    static boolean[][] v;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    static void tet(int cnt, int total, int x, int y) {
        if (cnt == 4) {
            max = Math.max(max, total);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && yy >= 0 && xx < N && yy < M && !v[xx][yy]) {
                v[xx][yy] = true;
                tet(cnt + 1, total + S[xx][yy], xx, yy);
                v[xx][yy] = false;
            }
        }
    }

    static void checkSpecialShape(int x, int y) {
        if (x >= 0 && x < N - 1 && y > 0 && y < M - 1) {
            int sum = S[x][y] + S[x + 1][y] + S[x][y - 1] + S[x][y + 1];
            max = Math.max(max, sum);
        }
        if (x > 0 && x < N && y > 0 && y < M - 1) {
            int sum = S[x][y] + S[x - 1][y] + S[x][y - 1] + S[x][y + 1];
            max = Math.max(max, sum);
        }
        if (x > 0 && x < N - 1 && y >= 0 && y < M - 1) {
            int sum = S[x][y] + S[x - 1][y] + S[x + 1][y] + S[x][y + 1];
            max = Math.max(max, sum);
        }
        if (x > 0 && x < N - 1 && y > 0 && y < M) {
            int sum = S[x][y] + S[x - 1][y] + S[x + 1][y] + S[x][y - 1];
            max = Math.max(max, sum);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                v[i][j] = true;
                tet(1, S[i][j], i, j);
                v[i][j] = false;
                checkSpecialShape(i, j);
            }
        }
        System.out.println(max);
    }
}
