import java.util.*;
import java.io.*;

public class Main_bj_2212_센서_권예진 {
	static int[] sensor;
	static int N;
	
	static int find (int k) {
		if(N==k || N==1) return 0;
		Integer [] dis = new Integer [N-1];
		for (int i = 0; i < N-1 ; i++) {
			dis[i] = sensor[i+1] - sensor[i];
		}
		Arrays.sort(dis,(a,b)->b-a);
		for (int i = 0; i < k-1; i++) {
			dis[i] = 0;
		}
		
		int sum = 0;
		for (int i = 0; i < N-1; i++) {
			sum += dis[i];

		}
		return sum ;
	}

	public static void main(String[] args) throws Exception {
	//System.setIn(new FileInputStream("res/input_bj_2212.txt"));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = null;
	
	N = Integer.parseInt(br.readLine());
	int K = Integer.parseInt(br.readLine());
	sensor = new int [N];
	
	st = new StringTokenizer(br.readLine(), " ");
	for (int i = 0; i < N; i++) {
		sensor[i] = Integer.parseInt(st.nextToken());
		}
	
	Arrays.sort(sensor);

	System.out.println(find(K));
	}
	
}
