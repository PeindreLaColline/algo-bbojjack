/*
주어진 맵으로 bfs한 번 (색약 아닐 때)
맵 전체 순회해서 g인 부분 r로 변경
수정된 맵으로 bfs 한 번 더 (색약 일때)
*/
#include <iostream>
#include <vector>
#include <queue>
#include <string>
using namespace std;

int dir[4][4] = { {0,-1},{1,0}, {0,1}, {-1,0} };

int n;
vector<vector<int>> map;
vector<vector<bool>> visited;

queue<pair<int, int>> togo;

int yes, no;

void bfs(int tar) {
	int cx, cy, nx, ny;
	while (!togo.empty()) {
		cx = togo.front().first;
		cy = togo.front().second;
		togo.pop();

		for (int i = 0; i< 4; i++) {
			nx = cx + dir[i][0];
			ny = cy + dir[i][1];
			//map현재 좌표의 색과 target 색이 같으면 q에 추가
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[ny][nx] && map[ny][nx] == tar) {
				visited[ny][nx] = true;
				togo.push({ nx, ny });
			}
		}
	}
}

int main() {
	cin >> n;
	vector<int> itmp(n);
	vector<bool> btmp(n, false);

	string tmp;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		map.push_back(itmp);
		visited.push_back(btmp);
		for (int j = 0; j < n; j++) {
			map[i][j] = tmp[j];
		}
	}

	//색약 아닐 때
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!visited[i][j]) {
				yes++;
				togo.push({ j, i });
				bfs(map[i][j]);
			}
		}
	}

	//visited 배열 초기화
	visited.clear();
	for (int i = 0; i < n; i++) {
		visited.push_back(btmp);
	}

	//맵에서 g인 부분 r로 변경
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (map[i][j] == 71) map[i][j] = 82;
		}
	}

	//색약일 때
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!visited[i][j]) {
				no++;
				togo.push({ j, i });
				bfs(map[i][j]);
			}
		}
	}
	cout << yes << " " << no << endl;

}
