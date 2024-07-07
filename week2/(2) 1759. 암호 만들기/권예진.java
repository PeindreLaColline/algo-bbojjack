import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_bj_1759_암호만들기_권예진 {
	static int L, C, result = 0;
	static char[] a, b;
	static boolean[] v; 
	static StringBuilder sb;
	
	static void perm(int cnt,int start) {
		if(cnt == L) {	
			if(find(b)) {
			sb = new StringBuilder();
			for (int i = 0; i < L; i++) {
				sb.append(b[i]);
			}
			System.out.println(sb);}
			return;
		}
		for(int i=start; i<C; i++) {

			b[cnt] = a[i];
			perm(cnt+1,i+1);

			}
	}
	
	static boolean find(char[] a) {
		int aeiou = 0;
		int bcd = 0;
		for(char i : a) {
			if(i== 'a' || i== 'e' || i== 'i' || i== 'o' || i== 'u') {
				aeiou ++;
			}else {
				bcd ++;
			}
		}
		if(aeiou >= 1 && bcd >=2) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		a = new char [C];
		v = new boolean[C]; 
		b = new char[L];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i <C; i++) {
			a[i]= st.nextToken().charAt(0);
		}
		Arrays.sort(a);

		perm(0,0);

		
	}
	
}
