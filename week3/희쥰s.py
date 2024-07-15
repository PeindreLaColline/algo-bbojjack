import sys
input = sys.stdin.readline

n,k = map(int,input().split())
S = []
A = [0] * (k+1)
A[0] = 1
for i in range(n):
    S.append(int(input()))


for a in S:
    for i in range(a, k + 1):
        A[i] += A[i-a]

print(A[k])
