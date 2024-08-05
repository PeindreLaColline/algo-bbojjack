import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_16974_레벨햄버거_권예진 {
    static long[] b , p;
    static long ans = 0;
    static long Burger(int n, long x){
        if(x == 1 && n == 0){ // 패티 한입
            return  1;
        }
        else if(x == 1){
            return  0;
        }
        else if(x <= b[n-1] + 1){ // 가운데 패티 전까지 먹었을때
            return  Burger(n-1, x-1);
        }
        else if (x == b[n-1] + 2) { // 가운데 패티까지 먹었을때
            return p[n-1] +1;
        }
        else if (x < b[n]) { // 전체 전까지 먹었을떄
            return p[n-1] + 1 +  Burger(n-1, x- b[n-1] - 2);
        }else { // 전체를 먹었을때
            return p[n];
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());
        b = new long[N+1];
        p = new long[N+1];
        b[0] = 1;
        p[0] = 1;
        for (int i = 1; i <= N; i++){
            b[i] = 2*b[i-1] + 3;
            p[i] = 2*p[i-1] + 1;
        } // 햄버거 수
        long ans = 0;
        ans = Burger(N,X);
        System.out.println(ans);


    }

}
