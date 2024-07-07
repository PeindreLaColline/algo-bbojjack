import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_bj_10819_차이를최대로_권예진 {
	static int N , result = 0;
	static int[] a, b;
	static boolean[] v; 
	
	private static void perm(int cnt) {
		if(cnt == N) {
			int ans = 0;
			for (int i = 0; i < N-1; i++) {
				ans += Math.abs(b[i] - b[i+1]);
			}
			result = Math.max(result, ans);
			return;
		}
		for(int i=0; i<N; i++) {
			if(v[i]) {
				continue;//없으면 중복순열
			}
			v[i] = true;
			b[cnt] = a[i];
			perm(cnt+1);
			v[i]=false;
			}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		a = new int [N];
		v =  new boolean[N]; 
		b =new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i <N; i++) {
			a[i]= (Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(a);
		
		perm(0);

		System.out.println(result);
		
	}
	
}
