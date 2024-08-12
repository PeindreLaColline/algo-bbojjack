import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        int dest;
        int cost;

        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    static int n, m;
    static ArrayList<Node>[] list;
    static int answer[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        answer = new int[n][n];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Node(dest, cost));
            list[dest].add(new Node(start, cost));
        }

        for (int i = 1; i <= n; i++) {
            calc(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    sb.append("-").append(" ");
                } else {
                    sb.append(answer[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void calc(int start) {
        PriorityQueue<Node> qu = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        qu.add(new Node(start, 0));

        int[] dist = new int[n + 1];
        boolean[] visit = new boolean[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        visit[start] = true;

        while (!qu.isEmpty()) {
            Node cur = qu.poll();
            int curDest = cur.dest;
            int curCost = cur.cost;
            visit[curDest] = true;

            if (dist[curDest] < curCost) {
                continue;
            }

            for (Node node : list[curDest]) {
                int dest = node.dest;
                int cost = node.cost + curCost;

                if (dist[dest] > cost && !visit[dest]) {
                    dist[dest] = cost;
                    answer[dest - 1][start - 1] = curDest;
                    qu.add(new Node(dest, cost));
                }
            }
        }
    }
}
