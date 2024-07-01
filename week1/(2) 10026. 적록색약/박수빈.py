N = int(input())
arr = [[0 for _ in range(N)] for _ in range(N)]
arr_rg = [[0 for _ in range(N)] for _ in range(N)]
for i in range(N):
    ip = input()
    for j in range(N):
        if ip[j]=='R':
            arr[i][j]=1
            arr_rg[i][j]=1
        elif ip[j]=='G':
            arr[i][j]=2
            arr_rg[i][j]=1
        else:
            arr[i][j]=3
            arr_rg[i][j]=3

from collections import deque
dx=[-1,1,0,0]
dy=[0,0,-1,1]
def bfs(i,j,c,arr,visited):
    q = deque()
    q.append([i,j])
    while q:
        target = q.popleft()
        for i in range(4):
            nx = target[0]+dx[i]
            ny = target[1]+dy[i]
            if 0<=nx<N and 0<=ny<N and visited[nx][ny]==0:
                if arr[nx][ny]==c:
                    visited[nx][ny]=1
                    q.append([nx,ny])

visited = [[0 for _ in range(N)] for _ in range(N)]
visited_rg = [[0 for _ in range(N)] for _ in range(N)]
answer=0
answer_rg = 0
for i in range(N):
    for j in range(N):
        # 정상인의 경우
        if arr[i][j]!=0 and visited[i][j]==0:
            visited[i][j]=1
            bfs(i,j,arr[i][j],arr,visited)
            # 구역 수 +1
            answer+=1
        # 적록색약인 경우
        if arr_rg[i][j]!=0 and visited_rg[i][j]==0:
            visited_rg[i][j]=1
            bfs(i,j,arr_rg[i][j],arr_rg,visited_rg)
            answer_rg+=1

print(answer,answer_rg)
