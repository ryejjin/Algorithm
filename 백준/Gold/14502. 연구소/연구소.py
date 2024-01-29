from collections import deque
import copy

def wall(cnt):
    if cnt == 3:
        bfs()
        return
    else:
        for i in range(n):
            for j in range(m):
                if ar[i][j] == 0:
                    ar[i][j] = 1
                    wall(cnt+1)
                    ar[i][j] = 0

def bfs():
    global result
    q = deque()
    arr = copy.deepcopy(ar)
    for i in range(n):
        for j in range(m):
            if arr[i][j] == 2:
                q.append((i, j))

    while q:
        x, y = q.popleft()
        for w in range(4):
            nx, ny = x+dx[w], y+dy[w]
            if 0<=nx<n and 0<=ny<m:
                if arr[nx][ny] == 0:
                    arr[nx][ny] = 2
                    q.append((nx, ny))
    c = 0
    for k in range(n):
        for l in range(m):
            if arr[k][l] == 0:
                c += 1
    result = max(result, c)

n, m = map(int, input().split())
ar = [list(map(int, input().split())) for _ in range(n)]
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

result = 0
wall(0)
bfs()

print(result)