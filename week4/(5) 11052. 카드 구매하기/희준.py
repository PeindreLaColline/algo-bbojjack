import sys
input = sys.stdin.readline

n = int(input())
S = list(map(int,input().split()))
P = [0 for _ in range(n+1)]

for i in range(1,n+1):
    for j in range(i,n+1):
        if(j%i==0):
            P[j] = max(P[j],S[i-1]*(j//i))
        elif j>i:
            P[j] = max(P[j],S[i-1]+P[j-i])

print(P[n])
