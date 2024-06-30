package algo.bbojjak;

import java.io.*;
import java.util.*;
public class TreeParents {
	static int N,a,b;
	static boolean[] v;
	static ArrayList<Integer>[] list;
	static int[] x;
	
	static void tree(int i) {
		v[i] = true;
		for( int j = 0; j < list[i].size(); j++) {
			if(!v[list[i].get(j)]) {
				v[list[i].get(j)] = true;
				x[list[i].get(j)] = i;
				tree(list[i].get(j));
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		x = new int[N+1];
		
		list = new ArrayList[N+1];
		v = new boolean[N+1];
		for(int i = 1; i <=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
			
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		tree(1);
		for(int i = 2; i<x.length; i++) {
			System.out.println(x[i]);
		}
	}
}
