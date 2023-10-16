n, m, r = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

for _ in range(r):
    for i in range(min(n, m)//2):
        x, y = i, i
        temp = arr[x][y]

        for j in range(i+1, n-i):
            x = j
            prev = arr[x][y]
            arr[x][y] = temp
            temp = prev

        for j in range(i+1, m-i):
            y = j
            prev = arr[x][y]
            arr[x][y] = temp
            temp = prev

        for j in range(i+1, n-i):
            x = n-j-1
            prev = arr[x][y]
            arr[x][y] = temp
            temp = prev

        for j in range(i+1, m-i):
            y = m-j-1
            prev = arr[x][y]
            arr[x][y] = temp
            temp = prev

for i in range(n):
    print(*arr[i], end = ' ')
    print()