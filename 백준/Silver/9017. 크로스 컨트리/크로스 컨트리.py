t = int(input())
for tc in range(t):
    n = int(input())
    info = list(map(int, input().split()))
    # 0 : 출전 선수, 1 : 점수의 합, 2 : 4명까지 확인했는지 체크, 3: 5번째 선수 점수
    team = [[0]*4 for _ in range(201)]

    # 출전 선수 카운트
    for i in info:
        team[i][0] += 1

    score = 1
    ans = int(1e9)  # 점수의 합
    res = 0     # 팀 넘버

    for i in info:
        if team[i][0] >= 6:
            if team[i][2] < 4:
                team[i][1] += score
                team[i][2] += 1
                score += 1
            elif team[i][2] == 4:
                team[i][2] += 1
                team[i][3] += score
                score += 1
            elif team[i][2] > 4:
                score += 1

    for i in range(1, 201):
        if team[i][1] != 0:
            if ans > team[i][1]:
                ans = team[i][1]
                res = i
            if ans == team[i][1]:
                if team[res][3] < team[i][3]:
                    continue
                else:
                    ans = team[i][1]
                    res = i

    print(res)