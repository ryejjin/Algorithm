from collections import deque
import sys
input = sys.stdin.readline

n, l, r = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

time = 0

di = [1, 0, -1, 0]
dj = [0, 1, 0, -1]

def bfs(x, y):
    q = deque([(x, y)])
    temp = [(x, y)]
    while q:
        i, j = q.popleft()
        for w in range(4):
            ni, nj = i+di[w], j+dj[w]
            if 0<=ni<n and 0<=nj<n and visit[ni][nj]==0:
                dif = abs(arr[ni][nj]-arr[i][j])
                if l<=dif<=r:
                    visit[ni][nj] = 1
                    q.append((ni, nj))
                    temp.append((ni, nj))
    return temp


while True:
    visit = [[0]*n for _ in range(n)]
    flag = 0
    for i in range(n):
        for j in range(n):
            if visit[i][j] == 0:
                visit[i][j] = 1
                country = bfs(i, j)

                if len(country) > 1:
                    flag = 1
                    people = sum(arr[x][y] for x, y in country)//len(country)
                    for x, y in country:
                        arr[x][y] = people

    if flag == 0:
        print(time)
        break

    time += 1