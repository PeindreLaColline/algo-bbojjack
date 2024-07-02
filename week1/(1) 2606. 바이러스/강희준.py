N = int(input())
M = int(input())
S = [[] for _ in range(N+1)]
v = [False] * (N+1)

cnt = 0

def virus(x):
    global cnt
    v[x] = True
    for i in S[x]:
        if not v[i]:
            cnt += 1
            virus(i)
    return cnt

for i in range(M):
    x, y = map(int, input().split())
    S[x].append(y)
    S[y].append(x)

ccnt = virus(1)

print(ccnt)
