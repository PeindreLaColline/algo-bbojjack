import sys
input = sys.stdin.readline

n = int(input())
S = [[0, 0] for _ in range(n)]
for i in range(n):
    S[i][0], S[i][1] = map(int, input().split())

P = [0] * (n + 1)

for i in range(n):
    if S[i][0]+i <=n:
        P[S[i][0]+i] = max(P[S[i][0]+i],P[i]+S[i][1])
    P[i+1] = max(P[i+1],P[i])

print(max(P))
