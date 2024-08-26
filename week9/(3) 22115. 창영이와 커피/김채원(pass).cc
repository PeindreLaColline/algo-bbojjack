//dp
#include <iostream>
#include <vector>
using namespace std;

int n, k;
vector<int> caff;
vector<int> dp;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin>>n>>k;
    caff.resize(n);
    dp.resize(k+1, 98765432);
    dp[0] = 0;

    for(int i =0; i<n; i++){
        cin>>caff[i];
        for(int j =k; j>=caff[i]; j--){
            dp[j] = min(dp[j], dp[j-caff[i]]+1);
        }
    }

    if(dp[k] == 98765432) cout<<-1;
    else cout<<dp[k];
}
