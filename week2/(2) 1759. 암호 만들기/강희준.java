package Algo_question;

import java.io.*;
import java.util.*;
public class baek1759 {
    static int L,C,vcnt,ccnt;
    static String[] c,b;
    static StringBuilder sb = new StringBuilder();

    static void PW(int cnt, int start){
        if(cnt == L){
            vcnt =0;
            ccnt =0;
            for(int i = 0; i<L; i++){
                if(b[i].equals("a") || b[i].equals("e") || b[i].equals("i") ||b[i].equals("o") || b[i].equals("u"))
                    vcnt++;
                else{
                    ccnt ++;
                }
            }
            if(vcnt >=1 && ccnt >=2){
                for(int i=0; i<L; i++){
                    sb.append(b[i]);
                }
                sb.append("\n");
            }
            return;
        }
        for(int i=start; i<C; i++){
            b[cnt] = c[i];
            PW(cnt+1,i+1);
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        c = new String[C];
        b = new String[L];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            c[i] = st.nextToken();
        }
        Arrays.sort(c);
        PW(0,0);
        System.out.println(sb);
    }
}
