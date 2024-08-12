package week7;

import java.io.*; 
import java.util.*; 

public class p2_4938_서강그라운드_cjh {
	static int N,M,R; 
	static int[] t; 
	static int[][] dis; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st1 = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st1.nextToken()); 
		M = Integer.parseInt(st1.nextToken()); 
		R = Integer.parseInt(st1.nextToken()); 
		t = new int[N]; 
		dis = new int [N][N]; 
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			t[i] = Integer.parseInt(st2.nextToken());
			Arrays.fill(dis[i],50);
			dis[i][i] = 0; 
		}
		
		for(int i = 0; i < R; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st3.nextToken());
			int b = Integer.parseInt(st3.nextToken());
			int l = Integer.parseInt(st3.nextToken());
			dis[a - 1][b - 1] = l;
			dis[b - 1][a - 1] = l;
		}
		
		for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dis[i][j] > dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }
		int max = 0; 
		for(int i = 0; i < N; i++) { 
			int pre = 0; 
			for(int j = 0; j < N; j++) {
				if(dis[i][j] <= M)pre+=t[j]; 
			}
			if(max < pre) max = pre; 
		}
		System.out.println(max); 
		
	}

}
