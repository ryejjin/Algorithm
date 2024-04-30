import sys
n = int(sys.stdin.readline())

room_se = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

room_se.sort(key = lambda x : (x[1], x[0]))

cnt = 0
end = 0

for time in room_se:
    if time[0] >= end :
        cnt += 1
        end = time[1]

print(cnt)