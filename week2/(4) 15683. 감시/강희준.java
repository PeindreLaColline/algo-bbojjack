package algo.bbojjak;

import java.io.*;
import java.util.*;

public class Gold3IsHard {
    static int N, M, minBlindSpot;
    static int[][] S;
    static List<CCTV> cctvs = new ArrayList<>();
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
                if (S[i][j] >= 1 && S[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, S[i][j]));  // 배열에 값 추가하면서 cctv 있는 부분 찾아서 AL추가
                }
            }
        }

        minBlindSpot = N * M;  //전체 영역 크기  ( 사각 지대가 될 거임 )
        dfs(0);
        System.out.println(minBlindSpot);
    }

    static void dfs(int depth) {
        if (depth == cctvs.size()) {	//AL 다돌면  사각지대에 최소값 비교해서 넣기
            minBlindSpot = Math.min(minBlindSpot, countBlindSpots());  //countBlindSpots : 사각지대
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int[][] original = copyArray(S);

        for (int[] dirs : getDirections(cctv.type)) {	// CCTV 종류에 따른 볼 수 있는 방향 배열 읽어서
            markSurveillance(cctv.x, cctv.y, dirs, true);   // markSurveillance 돌리기
            dfs(depth + 1);
            S = copyArray(original);		 // 배열 초기화 ( 백트래킹 )
        }
    }

    static void markSurveillance(int x, int y, int[] dirs, boolean mark) {
        for (int d : dirs) {
            int nx = x;
            int ny = y;
            while (true) {				//  getDirections 에 CCTV 타입 넣어서 리턴 받은 배열에서 뽑아서 CCTV가 감시할 방향 결정
                nx += directions[d][0];
                ny += directions[d][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || S[nx][ny] == 6) break;   // 6 = 벽
                if (S[nx][ny] == 0) S[nx][ny] = mark ? -1 : 0;				// mark 가 true 이면 -1, false 이면 0 넣기 -> 감시 하고 있는 지역을 -1로
            }
        }
    }

    static int countBlindSpots() {  // 사각지대 찾기  / 감시 되고있는 곳은 -1
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {   
                if (S[i][j] == 0) count++;
            }
        }
        return count;
    }

    static int[][] copyArray(int[][] original) {  // 이차원 배열 복사
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    static int[][] getDirections(int type) {
        switch (type) {
            case 1:
                return new int[][]{{0}, {1}, {2}, {3}};
            case 2:
                return new int[][]{{0, 1}, {2, 3}};
            case 3:
                return new int[][]{{0, 2}, {0, 3}, {1, 2}, {1, 3}};
            case 4:
                return new int[][]{{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}};
            case 5:
                return new int[][]{{0, 1, 2, 3}};
        }
        return new int[][]{};
    }

    static class CCTV {				// CCTV 좌표와 종류가 저장
        int x, y, type;

        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
