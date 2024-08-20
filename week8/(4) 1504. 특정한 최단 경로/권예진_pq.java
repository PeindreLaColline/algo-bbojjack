pq 쓴 버전!

import java.io.*;
import java.util.*;
public class Main_bj_1504_특정한최단경로_권예진 {
    static int N;
    static int INF = 200000000; //간선의 수 200,000 가중치 최댓값 1,000
    static List<int[]>[] g;
    static int knap(int start, int end){
        boolean[] v = new boolean[N+1];
        int[] dist= new int[N+1];
        Arrays.fill(dist, INF); // integer.MAX 쓰면 오버플로우 생김
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1[1],o2[1])); //int[] 정렬안됨(람다 필요), 가중치 기준
        dist[start]=0;
        pq.offer(new int[]{start,dist[start]});// 정접 0 ,비용 1

        while(!pq.isEmpty()) {
            int[] vc = pq.poll();
            int min= vc[1];
            int minVertex= vc[0];
            if(v[minVertex]) continue; //싸이클방지//

            v[minVertex]= true; // 방문처리
            for(int[] j : g[minVertex]) {
                if(!v[j[0]] && dist[j[0]]>min+j[1]) { //minEdge 갱신
                    dist[j[0]]=min+j[1];
                    pq.offer(new int[]{j[0],dist[j[0]]});
                }
            }
        }
        return dist[end];

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        N =Integer.parseInt(st.nextToken());
        int E =Integer.parseInt(st.nextToken());
        g = new List[N+1];


        for (int i = 0; i <= N; i++) g[i]= new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new int[] {b,c});
            g[b].add(new int[] {a,c});
        }
        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans1 = 0;
        ans1 += knap(1,v1);
        ans1 += knap(v1,v2);
        ans1 +=  knap(v2, N);

        int ans2 = 0;
        ans2 += knap(1,v2);
        ans2 += knap(v2,v1);
        ans2 +=  knap(v1, N);


        int ans = Math.min(ans1, ans2);

        if(ans1 >= INF || ans2 >= INF){
            ans = -1;
        }
        System.out.println(ans);

        }
}
