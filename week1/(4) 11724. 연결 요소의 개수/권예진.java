import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_bj_11724_연결요소의개수_권예진 {
	static int[][] graph;
	static boolean[] check;
	static int N,M;
	static int C;

	
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		check[i] = true; 
		q.offer(i);// 방문처리하고 값 대입. -> 큐에 들어가는 값이 줄어듦.
		while(!q.isEmpty()) {
			int x =q.poll();
			C++;
			for (int j = 0; j < N+1; j++) {
				if(graph[x][j] == 1 && !check[j]) {
					q.offer(j);
					check[j] = true;
				}
			}
		}
}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N+1][N+1];
		check = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		int ans = 0;
		C = 1;
		while(C < N+1) {
			bfs(C);
			ans++;
		}	
		System.out.println(ans);

	}
}
