//처음으로 노드 클래스 써보기~~

import java.io.*;
import java.util.*;

public class Main_bj_2660_회장뽑기_권예진 {
    static int N;
    static int[][] p;
    static boolean[] v;
    static int[] score;

   static class Node {
        int value;
        int level;

        Node(int value, int level) {
            this.value = value;
            this.level = level;
        }
    }

    static void friend(int n) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        v[n] = true;
        q.offer(new Node(n,0));
        int max = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int j = 0; j < N + 1; j++) {
                if (p[node.value][j] == 1 && !v[j]) {
                    v[j] = true;
                    q.offer(new Node(j, node.level+1));
                    max = Math.max(max, node.level+1);
                }
            }
        }
        score[n] = max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        p = new int[N + 1][N + 1];
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 || b == -1) {
                break;
            }
            p[a][b] = 1;
            p[b][a] = 1;
        }

        score = new int[N + 1];
        // for(int i=1; i<N; i++) score[i] = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            v = new boolean[N + 1];
            friend(i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            min = Math.min(min, score[i]);
        }
        ArrayList ans = new ArrayList();
        for (int i = 1; i <= N; i++) {
            if (score[i] == min) {
                ans.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(ans.size()).append("\n");
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
