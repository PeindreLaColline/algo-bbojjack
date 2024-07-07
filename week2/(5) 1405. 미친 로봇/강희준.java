import java.util.Scanner;

public class Main {
    static int N;
    static double[] prob = new double[4];  // 동, 서, 남, 북 이동 확률
    static boolean[][] visited = new boolean[30][30];  // 방문 여부 체크
    static int[] dx = {1, -1, 0, 0};  // 동, 서, 남, 북 이동
    static int[] dy = {0, 0, 1, -1};
    static double result = 0.0;
    
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        for (int i = 0; i < 4; i++) {
            prob[i] = sc.nextInt() * 0.01;  // 확률을 퍼센트에서 소수로 변환
        }
        
        sc.close();
        
        visited[15][15] = true;  // 시작점 방문 표시
        dfs(15, 15, 0, 1.0);  // DFS 탐색 시작
        
        System.out.printf("%.10f\n", result);
    }
    
    public static void dfs(int x, int y, int count, double probability){
        if (count == N) {
            result += probability;  // 모든 이동을 완료한 경우 확률을 결과에 더함
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (!visited[nx][ny]) {  // 새로운 위치가 방문되지 않았다면
                visited[nx][ny] = true;
                dfs(nx, ny, count + 1, probability * prob[i]);
                visited[nx][ny] = false;  // 탐색 완료 후 방문 표시 해제
            }
        }
    }
}
