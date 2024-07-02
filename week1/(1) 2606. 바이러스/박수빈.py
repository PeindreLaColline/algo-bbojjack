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
                # visited[v]=1
                stack.append(v)

    return visited[1:]


from collections import deque
def bfs(vtx):
    visited=[0 for _ in range(N+1)]
    q = deque()
    q.append(vtx)
    visited[vtx]=1

    while q: 
        n = q.popleft()
        for v in node[n]:
            if visited[v]==0:
                q.append(v)
                visited[v]=1
    
    return visited

# result = dfs(1)
result = bfs(1)
answer=0
for c in result:
    if c==1:
        answer+=1

# 1번 컴퓨터는 제외
print(answer-1)
