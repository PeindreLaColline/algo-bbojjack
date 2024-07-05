//https://0m1n.tistory.com/115
#include <iostream>
#include <vector>
using namespace std;

int n, m;
vector<vector<int>> map;
vector<pair<int, int>> cctv;
int dir[4][2] = { {0, -1},{1, 0},{0, 1},{-1, 0} };
int ans = 98765432;

int get_ans() {
	int cur = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 0) {
				cur++;
			}
		}
	}
	return cur;
}

/*
x, y: starting index
didx: direction index
*/
void line(int x, int y, int didx) {
	didx %= 4;
	while (true) {
		x += dir[didx][0];
		y += dir[didx][1];
		if (0 <= x && x < m && 0 <= y && y < n) {
			if (map[y][x] == 6) {
				return;
			}
			else if (map[y][x] != 0) {
				continue;
			}
			else {
				map[y][x] = -1;
			}
		}
		else {
			return;
		}
		
	}
	
}

void back(int idx) {
	if (idx == cctv.size()) {
		int cur = get_ans();
		if (cur < ans) ans = cur;

		return;
	}
	int x = cctv[idx].first;
	int y = cctv[idx].second;

	vector<vector<int>> backup = map;

	for (int i = 0; i < 4; i++) {
		if (map[y][x] == 1) {
			line(x, y, i);
		}
		else if (map[y][x] == 2) {
			line(x, y, i);
			line(x, y, i+2);
		}
		else if (map[y][x] == 3) {
			line(x, y, i);
			line(x, y, i+1);
		}
		else if (map[y][x] == 4) {
			line(x, y, i);
			line(x, y, i+2);
			line(x, y, i+3);
		}
		else if (map[y][x] == 5) {
			line(x, y, i);
			line(x, y, i+1);
			line(x, y, i+2);
			line(x, y, i+3);
		}
		back(idx + 1);
		map = backup;
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	vector<int> itmp(m);
	for (int i = 0; i < n; i++) {
		map.push_back(itmp);
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
			if (map[i][j] != 0 && map[i][j] != 6) {
				cctv.push_back({ j, i });
			}
		}
	}

	back(0);

	cout << ans;
}
