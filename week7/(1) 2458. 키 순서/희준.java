import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a][b] = true;
        }

        //a가 b보다 작고 b가 c보다 작으면 a는 c보다 작다
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (graph[i][j] || graph[j][i]) {
                    count++;
                }
            }

            if (count == n - 1) {
                result++;
            }
        }
//for(boolean[] b:graph) System.out.println(Arrays.toString(b));
//[false, true, false, true, true, true]
//[false, false, false, false, false, false]
//[false, true, false, true, false, true]
//[false, true, false, false, false, true]
//[false, true, false, true, false, true]
//[false, false, false, false, false, false]
        System.out.println(result);
    }
}
