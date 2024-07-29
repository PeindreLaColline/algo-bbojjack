
import java.io.*; 
import java.util.*; 

public class p5_2212_센서_cjh {
	static int N,K;
	static int ans; 
	static int[] pro; 
	static int[] v; 
	static int[] dif; 
	static int ts,tb; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		pro = new int[N];
		dif = new int[N - 1];
		tb = 0; ts = Integer.MAX_VALUE; 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pro[i] = Integer.parseInt(st.nextToken());
		}
		v = new int[K];
		sensor(0,0);
		System.out.println(ans);
	}
	static void sensor(int cnt, int start) { 
		Arrays.sort(pro);
//		System.out.print(pro[0] + " ");
		for(int i = 1; i < N ; i++) {
			dif[i-1] = pro[i] - pro[i-1];
		}
		Arrays.sort(dif);
		for(int i  = 0; i < N - K ; i++) {
			ans+= dif[i]; 
		}
	}

}
