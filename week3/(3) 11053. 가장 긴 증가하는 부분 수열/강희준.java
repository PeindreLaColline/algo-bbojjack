import java.io.*;
import java.util.*;

public class Main {
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] S = new int[N];
		int[] T = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {     // 입력 받은 배열
			S[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {  // 최대 문자열 길이를 저장할 배열   // 각 인덱스를 골랐을때 최대 문자열의 길이를 저장해둠
			T[i] = 1;
			for (int j = 0; j < i; j++) {
				if (S[i] > S[j] && T[i] < T[j] + 1) {    i 가  j 보다 큼   -> 지금 고른 숫자보다 작은 숫자가 뒤에 있으면 그 숫자의 T배열값 +1  
					T[i] = T[j] + 1;				// T배열은 현재 고른 숫자까지의 가장 긴 부분수열 길이
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {     // 저장해둔 배열을 돌면서 최대 값을 찾음
			if (max < T[i]) {
				max = T[i];
			}
		}
		System.out.println(max);

	}

}
