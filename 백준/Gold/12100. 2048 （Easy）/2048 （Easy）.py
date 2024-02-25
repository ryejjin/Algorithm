import copy

n = int(input())
game = [list(map(int, input().split())) for _ in range(n)]

res = 0

def up(arr):
    for j in range(n):
        cursor = 0
        for i in range(n):
            if arr[i][j]:
                tmp = arr[i][j]
                arr[i][j] = 0
                if arr[cursor][j] == 0:
                    arr[cursor][j] = tmp
                elif arr[cursor][j] == tmp:
                    arr[cursor][j] *= 2
                    cursor += 1
                else:
                    cursor += 1
                    arr[cursor][j] = tmp
    return arr

def down(arr):
    for j in range(n):
        cursor = n-1
        for i in range(n-1, -1, -1):
            if arr[i][j]:
                tmp = arr[i][j]
                arr[i][j] = 0
                if arr[cursor][j] == 0:
                    arr[cursor][j] = tmp
                elif arr[cursor][j] == tmp:
                    arr[cursor][j] *= 2
                    cursor -= 1
                else:
                    cursor -= 1
                    arr[cursor][j] = tmp
    return arr

def left(arr):
    for i in range(n):
        cursor = 0
        for j in range(n):
            if arr[i][j]:
                tmp = arr[i][j]
                arr[i][j] = 0
                if arr[i][cursor] == 0:
                    arr[i][cursor] = tmp
                elif arr[i][cursor] == tmp:
                    arr[i][cursor] *= 2
                    cursor += 1
                else:
                    cursor += 1
                    arr[i][cursor] = tmp
    return arr

def right(arr):
    for i in range(n):
        cursor = n-1
        for j in range(n-1, -1, -1):
            if arr[i][j]:
                tmp = arr[i][j]
                arr[i][j] = 0
                if arr[i][cursor] == 0:
                    arr[i][cursor] = tmp
                elif arr[i][cursor] == tmp:
                    arr[i][cursor] *= 2
                    cursor -= 1
                else:
                    cursor -= 1
                    arr[i][cursor] = tmp
    return arr

def dfs(cnt, arr):
    global res
    if cnt == 5:
        for i in range(n):
            for j in range(n):
                if arr[i][j] > res:
                    res = arr[i][j]
        return

    for i in range(4):
        cArr = copy.deepcopy(arr)
        if i == 0:
            dfs(cnt+1, left(cArr))
        elif i == 1:
            dfs(cnt+1, right(cArr))
        elif i == 2:
            dfs(cnt+1, up(cArr))
        else:
            dfs(cnt+1, down(cArr))

dfs(0, game)
print(res)