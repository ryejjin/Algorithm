n, d = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [i for i in range(d+1)]

for i in range(d+1):
    dp[i] = min(dp[i], dp[i-1]+1)
    for s, e, w in arr:
        if i==s and e<=d:
            dp[e] = min(dp[e], dp[i]+w)

print(dp[-1])