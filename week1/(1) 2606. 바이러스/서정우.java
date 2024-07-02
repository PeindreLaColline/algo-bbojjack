import java.io.*;
import java.util.*;

public class 서정우 {
    static int n;
    static int m;
    static ArrayList<Integer> list[];
    static boolean visit[];
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            list[node1].add(node2);
            list[node2].add(node1);
        }

        calc(1);

        System.out.println(answer);
    }

    private static void calc(int node) {
        visit[node] = true;

        for (int nextNode : list[node]) {
            if (!visit[nextNode]) {
                answer++;
                calc(nextNode);
            }
        }
    }
}
