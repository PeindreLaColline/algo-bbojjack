#include <iostream>
#include <vector>
#include <string>
#include <queue>
using namespace std;

int row, col;
vector<vector<bool>> map;
vector<vector<bool>> visited;
vector<vector<int>> way;

int dir[4][2] = { {0, -1}, {1, 0}, {0, 1}, {-1, 0 } };
int ans = 0;

void bfs(int cx, int cy) {
	queue<pair<int, int>> togo;
	togo.push({ cx, cy });

	int nx, ny;
	int leng = -1;
	while (!togo.empty()) {
		cx = togo.front().first;
		cy = togo.front().second;
		togo.pop();

		for (int i = 0; i < 4; i++) {
			nx = cx + dir[i][0];
			ny = cy + dir[i][1];
			if (0 <= nx && nx < row && 0 <= ny && ny < col) {
				if (!visited[ny][nx] && map[ny][nx]) {
					visited[ny][nx] = true;
					way[ny][nx] = way[cy][cx] + 1;
					if (leng < way[ny][nx]) leng = way[ny][nx];
					togo.push({ nx, ny });
				}
			}
		}
	}
	if (leng > ans) ans = leng;
}

void init() {
	for (int i = 0; i < col;i++) {
		for (int j = 0; j < row;j++) {
			visited[i][j] = false;
			way[i][j] = 0;
		}
	}
}

int main() {
	cin >> col >> row;
	map.resize(col, vector<bool>(row, false));
	string s;
	for (int i = 0; i < col; i++) {
		cin >> s;
		for (int j = 0; j < row; j++) {
			if (s[j] == 'L') map[i][j] = true;
		}
	}
	
	visited.resize(col, vector<bool>(row));
	way.resize(col, vector<int>(row));

	for (int i = 0; i < col; i++) {
		for (int j = 0; j < row; j++) {
			if (!map[i][j]) continue;
			init();
			visited[i][j] = true;
			bfs(j, i);
		}
	}
	cout << ans;
}
