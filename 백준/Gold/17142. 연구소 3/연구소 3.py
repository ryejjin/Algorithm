from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
status = [list(map(int, input().split())) for _ in range(n)]
res = int(1e9)

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs():
    visit = [[0] * n for _ in range(n)]
    q = deque()
    for i in range(len(virus)):
        if comb[i] == 1:
            a, b = virus[i]
            visit[a][b] = 0
            q.append([a, b, 0])
    complete = 0
    while q:
        x, y, time = q.popleft()
        if visit[x][y] == 1 and status[x][y] != 2:
            complete = max(time, complete)
        for w in range(4):
            nx, ny = x+dx[w], y+dy[w]
            if 0>nx or nx>=n or 0>ny or ny>=n: continue
            if 0<=nx<n and 0<=ny<n and visit[nx][ny] == 0:
                if status[nx][ny] == 2 or status[nx][ny] == 0:
                    visit[nx][ny] = 1
                    q.append([nx, ny, time+1])

    for i in range(n):
        for j in range(n):
            if status[i][j] == 0 and visit[i][j] == 0:
                complete = int(1e9)

    return complete

def sol(i, k):
    global res
    # 바이러스가 m개 만큼 활성화 됐을 때,
    if k == m:
        res = min(res, bfs())
        return
    # 바이러스를 활성화시키는 조합
    else:
        for a in range(i, len(virus)):
            comb[a] = 1
            sol(a+1, k+1)
            comb[a] = 0
            pass
        return

# 0은 빈 칸, 1은 벽, 2는 바이러스의 위치
virus = []
for i in range(n):
    for j in range(n):
        if status[i][j] == 2:
            virus.append([i, j])
comb = [0]*len(virus)

sol(0, 0)

if res == int(1e9):
    print(-1)
else:
    print(res)