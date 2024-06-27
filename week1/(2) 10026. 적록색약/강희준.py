from collections import deque

N = int(input())
S = [input() for _ in range(N)]
cnt = 0
RGcnt = 0
di = [0,1,0,-1]
dj = [1,0,-1,0]
v = [[False for col in range(N)] for row in range(N)]


def RGB(x, y, color1, color2):
    queue = deque([(x, y)])
    v[x][y] = True
    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            dx = cx + di[i]
            dy = cy + dj[i]
            if 0 <= dx < N and 0 <= dy < N and not v[dx][dy] and (S[dx][dy] == color1 or S[dx][dy] == color2):
                v[dx][dy] = True
                queue.append((dx, dy))

for i in range(N):
    for j in range(N):
        if (S[i][j] == 'R' and v[i][j]==False):
            RGB(i,j,'R','R')
            cnt += 1
        elif(S[i][j] == 'G' and v[i][j]==False):
            cnt += 1
            RGB(i,j,'G','G')
        elif(S[i][j] == 'B' and v[i][j]==False):
            cnt += 1
            RGB(i,j,'B','B')

v = [[False for col in range(N)] for row in range(N)]

for i in range(N):
    for j in range(N):
        if v[i][j]==False:
            if(S[i][j] == 'R' or S[i][j] == 'G'):
                RGB(i,j,'R','G')
                RGcnt += 1
            elif(S[i][j] == 'B' and v[i][j]==False):
                RGcnt += 1
                RGB(i,j,'B','B')
print(cnt)
print(RGcnt)
