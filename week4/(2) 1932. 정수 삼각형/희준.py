import sys
input = sys.stdin.readline

n = int(input())
S = [[] for _ in range(n)]
for i in range(n):
    S[i] = list(map(int,input().split()))

for i in range(1,n):
    for j in range(len(S[i])):
        if j==0:
            S[i][j] += S[i - 1][j]
        elif j == (len(S[i]) - 1):
            S[i][j] += S[i - 1][j - 1]
        else:
            S[i][j] += max(S[i - 1][j - 1], S[i - 1][j])

print(max(S[n-1]))
