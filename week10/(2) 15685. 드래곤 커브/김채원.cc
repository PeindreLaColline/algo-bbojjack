//https://velog.io/@skyepodium/%EB%B0%B1%EC%A4%80-15685-%EB%93%9C%EB%9E%98%EA%B3%A4-%EC%BB%A4%EB%B8%8C
#include <iostream>
#include <vector>
using namespace std;

int dir[4][2] = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
vector<int> route;
vector<vector<bool> > map(101, vector<bool>(101, false));
int n, x, y, d, g;

void print_all(){
    for(int i =0; i<=100; i++){
        for(int j =0; j<=100; j++){
            cout<<map[i][j]<<" ";
        }
        cout<<endl;
    }
}

void dragon_curve(){
    int s = route.size();
    for(int i =s-1; i>=0; i--){
        route.push_back((route[i]+1)%4);
    }
}

int main(){
    cin>>n;
    
    for(int i =0; i<n; i++){
        cin>>x>>y>>d>>g;        

        route.clear();
        route.push_back(d);
        for(int j = 0; j<g; j++){
            dragon_curve();
        }

        map[y][x] = true;
        for(int j =0;j<route.size(); j++){
           
            x += dir[route[j]][0];
            y += dir[route[j]][1];

            map[y][x] = true;

        }
    }

    int ans = 0;
    for(int i =0; i<100; i++){
        for(int j =0; j<100; j++){
            if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) ans++;
        }
    }

    //print_all();

    cout<<ans<<endl;
}
