#include <iostream>
#include <vector>
using namespace std;

int n, k;
vector<int> caff;
int ans = 98765432;

/*
s: start
sum: sum of caff
num: num of caff
*/
void knap(int s, int sum, int num){
    if(num>=ans) return;
    if(k<sum) return;
    else if(k==sum){
        if(num< ans) ans = num;
        return;
    }
    for(int i =s+1; i<n; i++){
        knap(i, sum+caff[i], num+1);
        knap(i, sum, num);
    }
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin>>n>>k;
    caff.resize(n);
    for(int i =0; i<n; i++){
        cin>>caff[i];
    }

    knap(-1, 0, 0);

    if(ans == 98765432) cout<<-1;
    else cout<<ans;
}
