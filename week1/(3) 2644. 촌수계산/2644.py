N = int(input())
ta,tb = map(int,input().split())

persons = { n+1:[] for n in range(N)}
visited = [ 0 for _ in range(N+1)]
M = int(input())
for _ in range(M):
    p,c = map(int,input().split())
    persons[p].append(c)
    persons[c].append(p)

# example 1 > persons = {1: [2, 3], 2: [1, 7, 8, 9], 3: [1], 4: [5, 6], 5: [4], 6: [4], 7: [2], 8: [2], 9: [2]}
def dfs(v,t):
    stack=[]
    stack.append([v,0])
    visited[v]=1

    while stack :
        nxt,depth = stack.pop()
        if nxt==t :
            return depth

        for nxt_gen in persons[nxt]:
            if visited[nxt_gen]==0 :
                stack.append([nxt_gen,depth+1])
                visited[nxt_gen]=1
    return -1

answer = dfs(tb,ta)
print(answer)
