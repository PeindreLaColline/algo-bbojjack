import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_bj_17825_주사위윷놀이_권예진 {
	static int[] horse = new int [10];
	static int[] map = {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,0, //0 ~ 21 (가장 외각으로 가는길)
			10,13,16,19,25,30,35,40,0, //22 ~ 30 (지름길 10 거쳐서 가기)
			20,22,24,25,30,35,40,0, //31 ~ 38 (지름길 20 거쳐서 가기)
			30,28,27,26,25,30,35,40,0}; // 39 ~ 47 (지름길 30 거쳐서 가기)
	// 종료 지점 21, 30, 38, 47
	static int[] N ;
	static int ans = 0;

	static void perm(int cnt) {
		if(cnt == 10) {
			game();
			return;
		}
		for(int i=0; i<4; i++) {
			horse[cnt] = i;
			perm(cnt+1);
		}
	}

	static void game(){
		boolean[] visited = new boolean[map.length];
		int score = 0; // 현재까지 누적 점수
		int[] p = new int[4]; // 현재 말들의 위치

		for(int i = 0; i<10; i++){
			int nowDice = N[i]; // 현재 주사위 번호
			int nowHorse = horse[i]; // 현재 움직일 말 번호
			if(isFinish(p[nowHorse])) return; // 말의 현재 위치가 도착지점일때

			int next = nextPoint(p[nowHorse], nowDice);
			if(isFinish(next)){
				setVisited(visited, p[nowHorse], false);
				p[nowHorse] = next;
				continue;
			}
			if(visited[next]) return; // 그 자리에 말이 존재
			setVisited(visited, p[nowHorse], false);
			setVisited(visited, next, true); // 말이 있는 위치

			p[nowHorse] = next; // 말의 위치 저장
			score += map[p[nowHorse]];
		}
		ans = Math.max(ans, score);
	}

	static int nextPoint (int nowIdx, int dice){ // 도착 지점을 넘어 갔을때 도착 지점으로!
		int nextIdx = nowIdx + dice;
		if(nowIdx < 21 ) {
			if(nextIdx >= 21) nextIdx = 21;
		} else if(nowIdx < 30) {
			if(nextIdx >= 30) nextIdx = 30;
		} else if (nowIdx < 38) {
			if(nextIdx >= 38) nextIdx = 38;
		} else if(nowIdx < 47) {
			if(nextIdx >= 47) nextIdx = 47;
		}
		if(nextIdx == 5) return 22; // 만약 파란색 말판을 밟았을때, 그에 맞는 map 위치로!
		if(nextIdx == 10) return 31;
		if(nextIdx == 15) return 39;
		return nextIdx;
	}

	static void setVisited(boolean[] visited, int idx, boolean check){
		if(idx == 20 || idx == 29 || idx == 37 || idx == 46){ // 말이 40일 때
			visited[20] = check;
			visited[29] = check;
			visited[37] = check;
			visited[46] = check;
		}
		else if(idx == 26 || idx == 34 || idx == 43){ // 말이 25일때
			visited[26] = check;
			visited[34] = check;
			visited[43] = check;
		}
		else if(idx == 27 || idx == 35 || idx == 44){ // 말이 30일때
			visited[27] = check;
			visited[35] = check;
			visited[44] = check;
		}
		else if(idx == 28 || idx == 36 || idx == 45){ // 말이 35일때
			visited[28] = check;
			visited[36] = check;
			visited[45] = check;
		}else{
			visited[idx] = check;
		}
	}

	static boolean isFinish(int idx){
		return idx == 21 || idx == 30 || idx == 38 ||idx == 47; // 도착 인덱스일때 true 반환
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = new int[10];
		for (int i = 0; i < 10; i++) {
			N[i] = Integer.parseInt(st.nextToken());
		}
		// 말의 순서를 뽑기 (한번도 출전안하는 말도 있을 수 있음
		perm(0);
		System.out.println(ans);
		}

	}
