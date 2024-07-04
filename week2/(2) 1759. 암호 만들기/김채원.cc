/*
굳이 만들어진 암호들 다 저장할 필요없이 그때그때 출력
permMain이랑 거의 동일한 것 같아요~!
*/
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int l, c;
vector<char> alpha;
vector<char> code;

/*
vow: 현재 모음의 개수
con: 현재 자음의 개수
start: 검사 시작할 인덱스
cur: 현재 암호로 선택된 알파벳 개수
*/
void back(int vow, int con, int start, int cur) {
	if (cur == l) { //cur가 암호 길이(l)과 같다면 
		if (vow >= 1 && con >= 2) { //암호의 조건을 만족하는지 확인하고
			for (int i = 0; i < l; i++) { //출력
				cout << code[i];
			}
			cout << endl;
		}
		return;
	}
	if (start == c) return; //start가 입력받은 알파벳의 개수와 같다면 조사 끝이니까 return

	for (int i = start + 1; i < c; i++) {
		char tmp = alpha[i]; 
		code[cur] = tmp; //선택된 알파벳 저장
		if (tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u') { 
			back(vow + 1, con, i, cur + 1);
		}
		else {
			back(vow, con + 1, i, cur + 1);
		}
	}
}

int main() {
	cin >> l >> c;
	alpha.resize(c); //입력 받을 모든 알파벳
	code.resize(l); //만들어진 암호 저장 배열
	for (int i = 0; i < c; i++) {
		cin >> alpha[i];
	}
	sort(alpha.begin(), alpha.end()); //알파벳순으로 정렬

	back(0, 0, -1, 0);
}
