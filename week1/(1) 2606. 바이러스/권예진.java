package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 권예진 {
	static int[][] node;
	static boolean[] check;
	static int cnt = 0;
	
	static void bfs(int i) { //최댓값
		ArrayDeque<Integer> q = new ArrayDeque<>();
		check[i] = true;
		q.offer(i);
		while(!q.isEmpty()) {
			cnt++;
			int x = q.poll();
			for (int j = 0; j < node.length; j++) {
				if(node[x][j] == 1 && !check[j]) {
					q.offer(j);
					check[j] = true;
				}
			}
		}}
	
	
	static void dfs(int i) { //최댓값
		if (check[i] == true) {
			return;
		}
		check[i] = true;
		cnt ++;
		for (int j = 0; j < node[i].length; j++) {
			if(node[i][j] == 1 && !check[j]) {
				dfs(j);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		node = new int[N][N];
		check = new boolean[N];
		for (int i = 0; i < E; i++) {//인접 행렬
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a-1][b-1] = 1;
			node[b-1][a-1] = 1;
		}
		bfs(0);
		//dfs(0);
		System.out.println(cnt-1);
	}
}
