r, c, n = map(int, input().split())
arr = [list(input()) for _ in range(r)]

di = [1, 0, -1, 0]
dj = [0, 1, 0, -1]

def explode(board):
    result = [['O'] * c for _ in range(r)]
    for i in range(r):
        for j in range(c):
            if board[i][j] == 'O':
                result[i][j] = '.'
                for w in range(4):
                    ni, nj = i + di[w], j + dj[w]
                    if 0 <= ni < r and 0 <= nj < c:
                        result[ni][nj] = '.'
    return result

if n == 1:
    for row in arr:
        print("".join(row))

elif n % 2 == 0:
    for _ in range(r):
        print("O" * c)

else:
    # After 2 seconds
    after_two = explode(arr)
    # After 4 seconds
    after_four = explode(after_two)

    if n % 4 == 3:
        for row in after_two:
            print("".join(row))
    else:
        for row in after_four:
            print("".join(row))
