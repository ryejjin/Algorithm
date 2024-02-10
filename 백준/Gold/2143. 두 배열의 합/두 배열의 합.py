import sys, bisect
input = sys.stdin.readline

t = int(input())
n = int(input())
nArr = list(map(int, input().split()))
m = int(input())
mArr = list(map(int, input().split()))

nSum = []
mSum = []

# 각 배열의 누적합을 미리 계산
for i in range(n):
    temp = nArr[i]
    nSum.append(temp)
    for j in range(i+1, n):
        temp += nArr[j]
        nSum.append(temp)

for i in range(m):
    temp = mArr[i]
    mSum.append(temp)
    for j in range(i+1, m):
        temp += mArr[j]
        mSum.append(temp)

nSum.sort()
mSum.sort()

ans = 0
for i in range(len(nSum)):
    left = bisect.bisect_left(mSum, t-nSum[i])
    right = bisect.bisect_right(mSum, t-nSum[i])
    ans += (right-left)

print(ans)