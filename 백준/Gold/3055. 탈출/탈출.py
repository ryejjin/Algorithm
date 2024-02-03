from collections import deque

def bfs():
    while w:
        i, j = w.popleft()
        for k in range(4):
            ni, nj = i+di[k], j+dj[k]
            if 0<=ni<r and 0<=nj<c:
                if water[ni][nj] == 0 and forest[ni][nj] == '.':
                    water[ni][nj] = water[i][j] + 1
                    w.append([ni, nj])

    while m:
        i, j = m.popleft()
        for k in range(4):
            ni, nj = i+di[k], j+dj[k]
            if 0<=ni<r and 0<=nj<c:
                if forest[ni][nj] == 'D':
                    return move[i][j]+1
                if move[ni][nj] == 0 and forest[ni][nj] != 'D' and forest[ni][nj] != 'X':
                    if not water[ni][nj] or water[ni][nj] > move[i][j] +1:
                        move[ni][nj] = move[i][j] +1
                        m.append([ni, nj])
    return 'KAKTUS'


r, c = map(int, input().split())
forest = [list(input()) for _ in range(r)]

di = [1, 0, -1, 0]
dj = [0, 1, 0, -1]

water = [[0]*c for _ in range(r)]
move = [[0]*c for _ in range(r)]

w, m = deque(), deque()

ci, cj = 0, 0
for i in range(r):
    for j in range(c):
        if forest[i][j] == 'S':
            m.append([i, j])
        elif forest[i][j] == '*':
            w.append([i, j])

print(bfs())