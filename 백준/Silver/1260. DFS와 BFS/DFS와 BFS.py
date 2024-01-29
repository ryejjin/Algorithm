def dfs(k):
    visited[k] = 1
    anw_dfs.append(k)
    for w in range(1, n+1):
        if adjM[k][w] == 1 and visited[w] == 0:
            dfs(w)

def bfs(k):
    visit = [0] * (n+1)
    q = [k]
    visit[k] = 1
    while q:
        t = q.pop(0)
        anw_bfs.append(t)
        for x in adjL[t]:
            if not visit[x]:
                q.append(x)
                visit[x] = visit[t] + 1

n, m, v = map(int, input().split())
adjM = [[0] * (n+1) for _ in range(n+1)]
adjL = [[] * (n+1) for _ in range(n+1)]
visited = [0] * (n+1)
anw_dfs = []
anw_bfs = []
for _ in range(m):
    s, e = map(int, input().split())
    adjM[s][e] = 1
    adjM[e][s] = 1
    adjL[s].append(e)
    adjL[e].append(s)
for i in range(len(adjL)):
    adjL[i].sort()

dfs(v)
bfs(v)
print(*anw_dfs)
print(*anw_bfs)