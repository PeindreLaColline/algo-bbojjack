
import java.io.*; 
import java.util.*; 

public class p4_1339_단어수학_cjh {
	static String[] words; 
	static int[] weight; 
	static int[] alpa; 
	static int N; 
	static int ans = 0; 
	public static void main(String[] args) throws Exception{ // 각 자릿수를 가중치로 저장한 후 가중치가 가장 큰 순서대로 큰 수와 곱해서 더해준다. 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		words = new String[N]; 
		for(int i = 0; i < N; i++) {
			 words[i] = br.readLine();
		}
		alpa = new int[26];
		weight = new int[26];
		decision(); 
		System.out.println(ans);
	}
	static void decision() {   // 가중치를 더해주는 함수 
		for(String word : words) {
			int T = 1; 
			for(int i= word.length() - 1; i >= 0; i-- ) {
				weight[word.charAt(i) - 'A'] += T; 
				T *= 10; 
			}
		}
		Arrays.sort(weight); 
		plus(); 
	}
	
	static void plus() {       // 가중치를 구했으니 가중치가 가장 높은 순서대로 높은 숫자와 곱해서 더해줌 
			int T = 9; 
			for(int i = 25; i > 15; i-- ) {
				if(weight[i] == 0)break; 
				ans = ans + ( weight[i]* T); 
				T -=1; 
			}
		
	}

}
