package Algo_question;

import java.io.*;
import java.util.*;

public class baek1182 {
    static int N, S, count;
    static int[] A;

    static void findSubsets(int index, int currentSum) {
        // index가 N에 도달하면 종료
        if (index == N) {
            // currentSum이 S와 같고 부분집합이 공집합이 아닌 경우 count 증가
            if (currentSum == S) count++;
            return;
        }

        // 현재 원소를 포함하지 않는 경우
        findSubsets(index + 1, currentSum);

        // 현재 원소를 포함하는 경우
        findSubsets(index + 1, currentSum + A[index]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        count = 0;
        findSubsets(0, 0);

        // S가 0일 경우 공집합을 제외해야 하므로 count를 하나 줄여야 함
        if (S == 0) count--;

        System.out.println(count);
    }
}
