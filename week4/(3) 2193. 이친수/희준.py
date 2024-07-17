import sys
input = sys.stdin.readline

n = int(input())
S = [0] * (n+1)

S[0] = 0
S[1] = 1

for i in range(2,n+1):
    S[i] = S[i-2] + S[i-1]

print(S[n])
