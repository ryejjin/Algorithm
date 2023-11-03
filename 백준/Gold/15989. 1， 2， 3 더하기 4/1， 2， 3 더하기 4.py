import sys
input = sys.stdin.readline

for tc in range(int(input())):
    n = int(input())
    dp = [0]*(n+1)
    if n == 1:
        print(1)
    elif n == 2:
        print(2)
    elif n == 3:
        print(3)
    else:
        dp[1] = 1
        dp[2] = 2
        dp[3] = 3
        for i in range(4, n+1):
            dp[i] = dp[i-3] + i//2 + 1

        print(dp[n])