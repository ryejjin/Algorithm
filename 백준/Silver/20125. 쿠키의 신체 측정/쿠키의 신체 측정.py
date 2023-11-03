n = int(input())
cookie = [list(input())+['_'] for _ in range(n)]+[['_' ]*(n+1)]

body = [[0]*(n+1) for _ in range(n+1)]
hi, hj = 0, 0
for i in range(n):
    for j in range(n):
        if cookie[i][j] == '*':
            if cookie[i-1][j] == '*' and cookie[i+1][j] == '*' and cookie[i][j-1]=='*' and cookie[i][j+1]=='*':
                body[i][j] = 9  # 심장
                hi, hj = i+1, j+1

for i in range(n):
    for j in range(n):
        if cookie[i][j] == '*':
            # 머리
            if body[i+1][j] == 9:
                body[i][j] = 8
            # 허리
            elif body[i-1][j] == 9:
                ni = i
                while cookie[ni][j] == '*':
                    body[ni][j] = 3
                    ni += 1
            # 왼팔
            elif body[i][j+1] == 9:
                nj = j
                while cookie[i][nj] == '*':
                    body[i][nj] = 1
                    nj -= 1
            # 오른팔
            elif body[i][j-1] == 9:
                nj = j
                while cookie[i][nj] == '*':
                    body[i][nj] = 2
                    nj += 1
            # 왼다리
            elif body[i-1][j+1] == 3:
                ni = i
                while cookie[ni][j] == '*':
                    body[ni][j] = 4
                    ni += 1
            # 오른다리
            elif body[i-1][j-1] == 3:
                ni = i
                while cookie[ni][j] == '*':
                    body[ni][j] = 5
                    ni += 1

cookie_body = [0]*5

for i in range(n):
    for j in range(n):
        if body[i][j] != 0:
            if body[i][j] != 8 and body[i][j] !=9:
                cookie_body[body[i][j]-1] += 1

print(hi, hj, end = ' ')
print()
print(*cookie_body)