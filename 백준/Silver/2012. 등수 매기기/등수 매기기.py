n = int(input())
expect = [int(input()) for _ in range(n)]
expect.sort()

res = 0
for i in range(n):
    res += abs(i - expect[i] +1)

print(res)