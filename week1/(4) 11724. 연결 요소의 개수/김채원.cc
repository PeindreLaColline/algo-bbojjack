#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n, m;
vector<vector<bool>> map;
vector<bool> visited;
queue<int> togo;

int get_ind() {
	for (int i = 1; i <= n; i++) {
		if (visited[i] == false) return i;
	}
	return -1;
}

void bfs() {
	while (!togo.empty()) {
		int cp = togo.front();
		togo.pop();
		for (int i = 1; i <= n; i++) {
			if (visited[i] == false && map[cp][i] == true && cp!=i) {
				visited[i] = true;
				togo.push(i);
			}
		}
	}
}

int main() {
	cin >> n >> m;
	vector<bool> btmp(n+1);
	visited.resize(n+1, false);
	for (int i = 0; i <= n; i++) {
		map.push_back(btmp);
	}
	int a, b;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		map[a][b] = true;
		map[b][a] = true;
	}

	int ans = 0;
	while (true) {
		int cp = get_ind();
		if (cp == -1) {
			break;
		}
		else {
			togo.push(cp);
			visited[cp] = true;
			bfs();
			ans++;
		}
	}
	cout << ans;
}
