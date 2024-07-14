import java.io.*; 
import java.util.*; 

public class Main {
	static String[] letter1 ; 
	static String[] letter2 ; 
	static int[][] dp; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t1 = br.readLine(); letter1  = t1.split("");
		String t2 = br.readLine(); letter2  = t2.split("");
		dp = new int[letter1.length+1][letter2.length+1];
		for(int i = 0; i <= letter1.length; i++) Arrays.fill(dp[i], 0);
//		for(String a : letter1) System.out.print(a); 
//		for(String b : letter2) System.out.print(b); 
//		System.out.println(); 
		lcs(1,1); 
	}
	static void lcs(int i,int j ) {
		if (i == letter1.length + 1) {System.out.println(dp[letter1.length][letter2.length]); return;} 
		if (j == letter2.length + 1) {i+=1; j = 1; lcs(i,j); return;} 
		
		if( 1<= i && i <= letter1.length && 1 <= j && j <= letter2.length) {
			if(letter1[i -1].equals(letter2[j-1])) {dp[i][j] = dp[i-1][j-1] + 1;}
			else {dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);}
		}
		j+=1; 
		lcs(i,j);
		return; 
	}
}
