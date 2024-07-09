package algo.bbojjak;

import java.io.*;
import java.util.*;

public class baek11053 {
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] S = new int[N];
		int[] T = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
            T[i] = 1;
            for (int j = 0; j < i; j++) {
                if (S[i] > S[j] && T[i] < T[j] + 1) {
                    T[i] = T[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < T[i]) {
                max = T[i];
            }
        }
        System.out.println(max);
		
	}

}
