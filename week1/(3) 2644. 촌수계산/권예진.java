package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_bj_2644_촌수계산_권예진 {
	static int[][] node;
	static boolean[] check;
	static int cnt = 0;
	static int[] distance;
	
	static void bfs(int i) { //최댓값
		ArrayDeque<Integer> q = new ArrayDeque<>();
		check[i] = true;
		distance[i] = 0;
		q.offer(i);
		while(!q.isEmpty()) {
			cnt++;
			int x = q.poll();
			for (int j = 0; j < node.length; j++) {
				if(node[x][j] == 1 && !check[j]) {
					q.offer(j);
					check[j] = true;
					distance[j] = distance[x]+1; 
				}
			}
			
		}}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int find_1 = Integer.parseInt(st.nextToken());
		int find_2 = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(br.readLine());
		
		node = new int[N][N];
		check = new boolean[N];
		distance = new int[N];
		for (int i = 0; i < E; i++) {//인접 행렬
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a-1][b-1] = 1;
			node[b-1][a-1] = 1;
		}
		bfs(find_1-1);
		if (distance[find_2-1]==0) {
			System.out.println(-1);
		}else {
			
			System.out.println(distance[find_2-1]);
		}
	}
}
