package week8;

import java.io.*; 
import java.util.*; 

public class p2_5972_택배배송_cjh {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  // 노드 수
		int M = Integer.parseInt(st.nextToken());  // 간선 수
		List<int[]>[] g = new List[N]; 
		for(int i = 0; i < N; i++) g[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			int c = Integer.parseInt(st.nextToken()); 
			g[a-1].add(new int[] {b-1,c}); 
			g[b-1].add(new int[] {a-1,c}); 
		}

		int[] d = new int[N];
		Arrays.fill(d, Integer.MAX_VALUE); // 최솟값을 저장하기 위해 초기화
		d[0] = 0;                           // 시작점의 최소 가중치를 0으로 설정

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.add(new int[] {0, 0}); // 시작점과 가중치를 우선순위 큐에 추가,v배열은 pq에서는 어짜피 가장 작은게 업데이트되므로 상관 없음. 나중에 것들은 사가지거나 pass됨. 
		
		while (!pq.isEmpty()) {
			int[] current = pq.poll();
			int currentNode = current[0];
			int currentDist = current[1];
			
			if (currentDist > d[currentNode]) continue;//종료조건? 필요없는 것들이 나오면 그냥 pass. 전부 pass되고 나면 empty 로 종료 

			for (int[] neighbor : g[currentNode]) {
				int nextNode = neighbor[0];
				int weight = neighbor[1];         
				
				if (d[nextNode] > d[currentNode] + weight) {
					d[nextNode] = d[currentNode] + weight;
					pq.add(new int[] {nextNode, d[nextNode]}); //currentNode에 해당하는 점에서 최소값 다시 update . 
				}
			}
		}
		
		System.out.println(d[N-1]);       
		br.close(); 
	}
}
