from collections import deque
def bfs(s, e):
    q = deque([[s,e]])
    arr[s][e] = 2
    cnt = 0
    while q:
        x, y = q.popleft()
        for w in range(4):
            nx, ny = x+dx[w], y+dy[w]
            if 0<=nx<m and 0<=ny<n:
                if arr[nx][ny] == -1:
                    cnt += 1
                    arr[nx][ny] = 2
                    q.append([nx, ny])
    count.append(cnt+1)

m, n, k = map(int, input().split())
arr = [[-1] * n for _ in range(m)]
for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    for j in range(x1, x2):
        for i in range(y1, y2):
            arr[i][j] = 0

count = []
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
for k in range(m):
    for l in range(n):
        if arr[k][l] == -1:
            bfs(k, l)
count.sort()
print(len(count))
print(*count)