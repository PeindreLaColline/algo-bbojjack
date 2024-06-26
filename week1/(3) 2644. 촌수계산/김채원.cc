#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int peo, rel;
vector<vector<bool>> v;
vector<bool> visited;

int a, b;
int ans = -1;

queue<int> togo;
queue<int> ntogo;
queue<int> vide;

void bfs() {
	int cnt = 1;
	while (!ntogo.empty()) {
		togo = ntogo;
		ntogo = vide;
		cnt++;

		while (!togo.empty()) {
			int s = togo.front();
			togo.pop();

			for (int i = 1; i <= peo; i++) {
				if (v[s][i] == 1 && visited[i] == false) {
					if (i == b) {
						ans = cnt;
						return;
					}
					visited[i] = true;
					ntogo.push(i);
				}
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> peo;
	vector<bool> itmp(peo+1, 0);
	for (int i = 0; i <= peo; i++) {
		v.push_back(itmp);
	}
	visited.resize(peo + 1, false);
	
	cin >> a >> b;
	cin >> rel;
	int t1, t2;
	for (int i = 0; i < rel; i++) {
		cin >> t1 >> t2;
		v[t1][t2] = 1;
		v[t2][t1] = 1;
	}
	
	for (int i = 1; i <= peo; i++) {
		if (v[a][i] == 1) ntogo.push(i);
	}
	bfs();
	cout << ans;
}
