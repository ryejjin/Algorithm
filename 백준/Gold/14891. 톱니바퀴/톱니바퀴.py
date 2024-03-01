from collections import deque

info = [deque(list(map(int, input()))) for _ in range(4)]
k = int(input())

def rotate(num, dis):
    visit[num] = True
    if 0 <= num-1:
        if not visit[num-1] and (info[num][6] != info[num-1][2]):
            rotate(num-1, -dis)
    if num+1 < 4:
        if not visit[num+1] and (info[num][2] != info[num+1][6]):
            rotate(num+1, -dis)
    info[num].rotate(dis)


for _ in range(k):
    num, dis = map(int, input().split())
    visit = [False for _ in range(4)]
    rotate(num-1, dis)

# 점수 계산
res = 0
for i in range(4):
    if info[i][0] == 1:
        res += 2**i

print(res)