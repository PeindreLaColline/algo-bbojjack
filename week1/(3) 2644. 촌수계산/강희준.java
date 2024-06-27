package algo.bbojjak;

import java.io.*;
import java.util.*;

public class MyUncle {
	static int N,M,cnt;
	static ArrayList<Integer>[] list;
	static boolean []v;
	
	
	static int bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start, 0});
        v[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int depth = current[1];

            if (node == end) {
                return depth;
            }

            for (int neighbor : list[node]) {
                if (!v[neighbor]) {
                    v[neighbor] = true;
                    queue.add(new int[] {neighbor, depth + 1});
                }
            }
        }
        return -1;
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		v = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list[w].add(z);
			list[z].add(w);
		}
		cnt = bfs(x,y);
		System.out.println(cnt);
	}

}
