import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        ArrayList<int[]>[] g = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) g[i] = new ArrayList<>(); // 인접 리스트 초기화
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new int[]{b, c}); // 인접정점번호, 비용
        }
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st1.nextToken());
        int end = Integer.parseInt(st1.nextToken());
        
        int[] d = new int[N + 1];
        Arrays.fill(d, Integer.MAX_VALUE); // 각 정점까지의 최소 가중치 저장
        
        d[start] = 0; // 시작점의 최소 가중치를 0으로 설정
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // 최소 힙 사용
        que.offer(new int[]{start, 0});

        while (!que.isEmpty()) {
            int[] currBus = que.poll();
            int currEnd = currBus[0];
            int currDist = currBus[1];

            // 방문 처리와 함께 현재 큐에서 꺼낸 경로가 이미 발견된 최소 거리보다 큰 경우 스킵
            if (currDist > d[currEnd]) continue;

            for (int[] b : g[currEnd]) { // 다음 노드에 담겨있는 버스 정보들
                int nextEnd = b[0];
                int nextDist = currDist + b[1];

                if (d[nextEnd] > nextDist) {
                    d[nextEnd] = nextDist;
                    que.offer(new int[]{nextEnd, nextDist}); // 우선순위 큐에 추가
                }
            }
        }

        System.out.println(d[end]);
    }
}
