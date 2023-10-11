n = int(input())
lst = [0]
for _ in range(n):
    lst.append(int(input()))

def dfs(x):
    stack = [x]
    while stack:
        q = stack.pop()
        if visit[lst[q]] == 0:
            stack.append(lst[q])
            visit[q] = 1
        else:
            if q not in ans:
                ans.append(q)


ans = []

for i in range(1, n+1):
    visit = [0]*(n+1)
    visit[i] = 1
    dfs(lst[i])

ans.sort()
print(len(ans))
for i in range(len(ans)):
    print(ans[i])