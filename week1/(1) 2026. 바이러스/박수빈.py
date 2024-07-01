N = int(input())
T = int(input())

node = {n+1:[] for n in range(N)}
for _ in range(T):
    a,b = map(int,input().split())
    node[a].append(b)
    node[b].append(a)

def dfs(vtx):
    visited = [ 0 for _ in range(N+1)]

    stack = [vtx]
    while stack :
        target = stack.pop()
        if visited[target]==1: continue
        visited[target]=1

        for v in node[target]:
            if visited[v]==0:
                stack.append(v)

    return visited[1:]

check = dfs(1)
answer=0
for c in check:
    if c==1:
        answer+=1

print(answer-1)
