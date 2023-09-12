import copy

n, m = map(int, input().split())
office = []
cctv = []
result = int(1e9)
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

case = [
    [],
    [[0], [1], [2], [3]],
    [[0, 2], [1, 3]],
    [[0, 1], [1, 2], [2, 3], [3, 0]],
    [[0, 1, 2], [1, 2, 3], [2, 3, 0], [3, 0, 1]],
    [[0, 1, 2, 3]]
]

for i in range(n):
    data = list(map(int, input().split()))
    office.append(data)
    for j in range(m):
        if data[j] in [1, 2, 3, 4, 5]:
            cctv.append([data[j], i, j])
def fill(board, case, x, y):
    for i in case:
        nx = x
        ny = y
        while True:
            nx += dx[i]
            ny += dy[i]
            if nx<0 or ny<0 or nx>=n or ny>=m:
                break
            if board[nx][ny] == 6:
                break
            elif board[nx][ny] == 0:
                board[nx][ny] = 7

def dfs(depth, arr):
    global result
    if depth == len(cctv):
        cnt = 0
        for i in range(n):
            cnt += arr[i].count(0)
        result = min(result, cnt)
        return
    temp = copy.deepcopy(arr)
    cctv_num, x, y = cctv[depth]
    for i in case[cctv_num]:
        fill(temp, i, x, y)
        dfs(depth+1, temp)
        temp = copy.deepcopy(arr)


dfs(0, office)
print(result)