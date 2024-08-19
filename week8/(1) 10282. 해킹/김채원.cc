#include <iostream>
#include <vector>
#include <queue>
using namespace std;

#define INF 98765432

/*
n 컴퓨터 개수
d 의존성 개수
c 해킹당한 컴퓨터의 번호
*/
int n, d, c;

/*
map[i].first 는 i에 의존함
map[i].first가 감염되면 i도 감염되고 시간은 map[i].second초 걸림
*/
vector<vector<pair<int, int> > > map;
vector<int> dis;

struct compare{
    bool operator()(const pair<int, int> &a, const pair<int, int> &b){
        return a.second > b.second;
    }
};

void initial(){
    map.resize(n+1);
    dis.resize(n+1);
    for(int i =0; i<=n;i++){
        dis[i] =INF;
        map[i].clear();
    }
}

void get_dis()
{
    priority_queue<pair<int, int>, vector<pair<int, int> >, compare> togo;
    togo.push(make_pair(c, 0));
    dis[c] = 0;
    int cur, nex;
    while (!togo.empty())
    {
        cur = togo.top().first;
        togo.pop();
        
        for (int i = 0; i < map[cur].size(); i++){
            nex = map[cur][i].first;
            if(dis[nex] > map[cur][i].second + dis[cur]){
                dis[nex] = map[cur][i].second + dis[cur];
                togo.push(make_pair(nex, dis[nex]));
            }
        }
    }

    int ans = 0;
    int cnt = 0;

    for (int i = 1; i <= n; i++)
    {
        if(dis[i] !=INF){
            cnt++;
            if(ans < dis[i]){
                ans = dis[i];
            }
        }
    }
    cout << cnt << " " << ans<<endl;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int test_case;
    cin >> test_case;
    for (int T = 0; T < test_case; T++){
        cin >> n >> d >> c;
        initial();

        int x, y, z;
        for (int i = 0; i < d; i++)
        {
            cin >> x >> y >> z;
            map[y].push_back(make_pair(x, z));
        }
        get_dis();
    }
}
