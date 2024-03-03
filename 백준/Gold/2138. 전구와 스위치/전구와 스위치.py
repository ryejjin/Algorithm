n = int(input())
current = list(map(int, input()))
goal = list(map(int, input()))

def switch(now, next):
    temp = now[:]
    cnt = 0
    for i in range(1, n):
        if temp[i-1] == next[i-1]:
            continue
        cnt += 1
        for j in range(i-1, i+2):
            if j<n:
                temp[j] = 1-temp[j]
    if temp == next:
        return cnt
    else:
        return 1e9

res = switch(current, goal)
current[0] = 1-current[0]
current[1] = 1-current[1]
res = min(res, switch(current, goal)+1)

if res != 1e9:
    print(res)
else:
    print(-1)