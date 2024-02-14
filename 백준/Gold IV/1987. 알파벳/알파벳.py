r, c = map(int, input().split())
arr = [list(input()) for _ in range(r)]

def dfs(i, j, cnt):
    global ans
    ans = max(ans, cnt)
    for w in range(4):
        ni, nj = i+di[w], j+dj[w]
        if 0<=ni<r and 0<=nj<c:
            if arr[ni][nj] not in alpha:
                alpha.add(arr[ni][nj])
                dfs(ni, nj, cnt+1)
                alpha.remove(arr[ni][nj])


di = [-1, 1, 0, 0]
dj = [0, 0, -1, 1]
alpha = set()
alpha.add(arr[0][0])
ans = 0
dfs(0, 0, 1)

print(ans)