package algo.bbojjak;

import java.io.*;
import java.util.*;

public class LinkBoom {
	static int N,M,cnt;
	static ArrayList<Integer>[] list;
	static boolean []v;
	
	
	static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        v[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : list[current]) {
                if (!v[neighbor]) {
                    v[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		v = new boolean[N+1];
		
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
		
		for(int i=1; i<N+1; i++) {
			if(!v[i]) {
				cnt++;
				bfs(i);
			}
		}
		
		System.out.println(cnt);
	}

}
