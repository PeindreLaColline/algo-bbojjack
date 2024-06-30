import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 서정우 {
    static int n;
    static int m;
    static ArrayList<Integer> list[];
    static boolean visit[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list[node1].add(node2);
            list[node2].add(node1);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                answer++;
                calc(i);
            }
        }
        System.out.println(answer);
    }

    private static void calc(int node) {
        visit[node] = true;

        for (int childNode : list[node]) {
            if (!visit[childNode]) {
                calc(childNode);
            }
        }
    }
}

