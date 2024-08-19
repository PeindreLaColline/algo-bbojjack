//pq 안쓴 버전!


import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int INF = 200000000;
    static List<int[]>[] g;
    static int knap(int start, int end){
        boolean[] v = new boolean[N+1];
        int[] dist= new int[N+1];
        Arrays.fill(dist, INF);
        dist[start]=0;

        for(int i= 0; i<N; i++) {
            int min = Integer.MAX_VALUE;
            int minVertex=-1;
                for(int j=1; j<=N; j++) {
                    if(!v[j] && min>dist[j] ){ //최소비용 인데스 찾음
                        min=dist[j];
                        minVertex=j;
                    }
                }
            if (minVertex == -1) break;
            v[minVertex]= true; // 방문처리

            if(minVertex == end) break;

            for(int[] j : g[minVertex]) { //어떻게 왔는지는 알 수 없음. 어디 경유해서 올수도 있는데 그게 최단거리.
                if(!v[j[0]] && dist[j[0]]>min+j[1]) {
                    dist[j[0]]=min+j[1];
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

        if(ans1 >=INF || ans2 >= INF){
            ans = -1;
        }
        System.out.println(ans);

        }
}
