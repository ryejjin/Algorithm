import sys
input = sys.stdin.readline
from collections import deque

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
ans = [[0]*m for _ in range(n)]

di = [1, 0, -1, 0]
dj = [0, 1, 0, -1]

def bfs(x, y):
    q = deque([(x, y)])
    while q:
        i, j = q.popleft()
        for w in range(4):
            ni, nj = i+di[w], j+dj[w]
            if 0<=ni<n and 0<=nj<m:
                if arr[ni][nj] == 1 and ans[ni][nj] == 0:
                    ans[ni][nj] = ans[i][j] +1
                    q.append((ni, nj))

for i in range(n):
    for j in range(m):
        if arr[i][j] == 2:
            bfs(i, j)

for i in range(n):
    for j in range(m):
        if arr[i][j] == 1 and ans[i][j] == 0:
            ans[i][j] = -1

for i in range(n):
    print(*ans[i])