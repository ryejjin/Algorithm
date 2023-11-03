n, m = map(int, input().split())
dp = [list(map(int, input().split())) for _ in range(n)]

for i in range(1, m):
    dp[0][i] += dp[0][i-1]

for i in range(1, n):
    right = dp[i][:]
    left = dp[i][:]
    for j in range(m):
        if j == 0:
            right[j] += dp[i-1][j]
        else:
            right[j] += max(dp[i-1][j], right[j-1])

    for k in range(m-1, -1, -1):
        if k == m-1:
            left[k] += dp[i-1][k]
        else:
            left[k] += max(dp[i-1][k], left[k+1])

    for w in range(m):
        dp[i][w] = max(right[w], left[w])

print(dp[n-1][m-1])