//https://hyunsix.tistory.com/entry/%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EB%B0%B1%EC%A4%80-1405-%EB%AF%B8%EC%B9%9C-%EB%A1%9C%EB%B4%87?category=891807
#include <iostream>
#include <vector>
#include <iomanip>
#include <cmath>
using namespace std;

int n;
double nor, eas, sou, wes;
vector<vector<bool>> visited;

int dir[4][2] = { {0, -1},{1, 0},{0, 1},{-1, 0} };
int tnor, teas, tsou, twes;

double ans = 0.0;

void back(int cnor, int ceas, int csou, int cwes, int cur, int cx, int cy) {
	if (cur == n) {
		double anor = pow((nor * 0.01), cnor);
		double aeas = pow((eas * 0.01), ceas);
		double asou = pow((sou * 0.01), csou);
		double awes = pow((wes * 0.01), cwes);
		ans += (anor * aeas * asou * awes);
		return;
	}
	
	int nx, ny;
	for (int i = 0; i < 4; i++) {
		nx = cx + dir[i][0];
		ny = cy + dir[i][1];
		if (0 <= nx && nx <= 28 && 0 <= ny && ny <= 28) {
			if (visited[ny][nx]) continue;
			visited[ny][nx] = true;
			if (i == 0) {
				back(cnor + 1, ceas, csou, cwes, cur + 1, nx, ny);
			}
			else if (i == 1) {
				back(cnor, ceas + 1, csou, cwes, cur + 1, nx, ny);
			}
			else if (i == 2) {
				back(cnor, ceas, csou + 1, cwes, cur + 1, nx, ny);
			}
			else if (i == 3) {
				back(cnor, ceas, csou, cwes + 1, cur + 1, nx, ny);
			}
			visited[ny][nx] = false;
		}
	}
}

int main() {
	cin >> n >> eas >> wes >> sou >> nor;
	vector<bool> ctmp(29, false);
	for (int i = 0; i < 29; i++) {
		visited.push_back(ctmp);
	}

	visited[14][14] = true;
	back(0, 0, 0, 0, 0, 14, 14);
	
	cout << fixed << setprecision(20) << ans << endl;
}
