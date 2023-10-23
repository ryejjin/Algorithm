n = int(input())
arr = [list(input().split()) for _ in range(n)]

di = [1, 0, -1, 0]
dj = [0, 1, 0, -1]

def find_obstacle(i, j):
    global ans, obstacles

    for w in range(4):
        ni, nj = i+di[w], j+dj[w]
        if 0<=ni< n and 0<=nj<n:
            if arr[ni][nj] == 'S':
                obstacles = 0
                ans = 'NO'
                return
            elif arr[ni][nj] == 'O':
                continue
            elif arr[ni][nj] == 'T':
                continue

            for k in range(1, n):
                nni, nnj = ni+di[w]*k, nj+dj[w]*k
                if 0<=nni<n and 0<=nnj<n:
                    if arr[nni][nnj] == 'O' or arr[nni][nnj] == 'T':
                        break
                    elif arr[nni][nnj] == 'S':
                        if obstacles == 0:
                            ans = 'NO'
                            return
                        arr[ni][nj] = 'O'
                        obstacles -= 1
                        break

teachers = []
for i in range(n):
    for j in range(n):
        if arr[i][j] == 'T':
            teachers.append((i, j))

ans = 'YES'
obstacles = 3

for teacher in teachers:
    r, c = teacher
    find_obstacle(r, c)

print(ans)