import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_bj_10819_부분수열의합_권예진 {
	static int N, S, result = 0;
	static int[] a;
	static boolean[] v; 
	
	private static void subset(int cnt, int ans) {
		if(cnt == N) {
			if(ans == S) {
				result++;
			}
				return;
				}
		subset(cnt+1,ans+a[cnt]);
		subset(cnt+1,ans);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N  =Integer.parseInt(st.nextToken());
		S  =Integer.parseInt(st.nextToken());
		
		a = new int [N];
		v =  new boolean[N]; 

		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i <N; i++) {
			a[i]= (Integer.parseInt(st.nextToken()));
		}
		subset(0, 0);
		
		if (S == 0) {
		System.out.println(result-1);}
		else {
			System.out.println(result);
		}
		
	}
	
}
