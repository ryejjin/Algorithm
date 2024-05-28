def bfs(s):
    q = [s]
    visited[s] = 1
    while q:
        t = q.pop(0)
        for w in tree[t]:
            if visited[w] == 0:
                q.append(w)
                visited[w] = visited[t] + 1
    return visited

n = int(input())
s, e = map(int, input().split())
m = int(input())
tree = [[] for _ in range(n+1)]
visited = [0] * (n+1)
for _ in range(m):
    x, y = map(int, input().split())
    tree[x].append(y)
    tree[y].append(x)
lst = bfs(s)
print(lst[e]-1)