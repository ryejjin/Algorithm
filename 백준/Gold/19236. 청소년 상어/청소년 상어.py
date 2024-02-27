import copy

fish = [[0]*4 for _ in range(4)]
direction = [[0]*4 for _ in range(4)]
res = 0

for i in range(4):
    info = list(map(int, input().split()))
    for j in range(0, 7, 2):
        fish[i][j//2] = info[j]
        direction[i][j//2] = info[j+1]-1

# ↑, ↖, ←, ↙, ↓, ↘, →, ↗
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, -1, -1, -1, 0, 1, 1, 1]

def find_fish(f, fish):
    for i in range(4):
        for j in range(4):
            if fish[i][j] == f:
                return i, j

def fish_move(x, y, fish, direction):
    for f in range(1, 17):
        position = find_fish(f, fish)
        if position:
            fx, fy = position[0], position[1]
            dir = direction[fx][fy]
            for i in range(8):
                nx, ny = fx+dx[dir], fy+dy[dir]
                if 0<=nx<4 and 0<=ny<4:
                    if not (nx == x and ny == y):
                        direction[fx][fy], direction[nx][ny] = direction[nx][ny], direction[fx][fy]
                        fish[fx][fy], fish[nx][ny] = fish[nx][ny], fish[fx][fy]
                        break
                dir = (dir+1)%8
                direction[fx][fy] = dir

def shark_position(x, y, fish, direction):
    dir = direction[x][y]
    position = []
    for w in range(4):
        nx, ny = x+dx[dir]*w, y+dy[dir]*w
        if 0<=nx<4 and 0<=ny<4 and fish[nx][ny] != -1:
            position.append([nx, ny])
    return position

def shark_move(x, y, score, fish, direction):
    global res
    fish = copy.deepcopy(fish)
    direction = copy.deepcopy(direction)
    score += fish[x][y]
    fish[x][y] = -1
    fish_move(x, y, fish, direction)
    possible_move = shark_position(x, y, fish, direction)

    if possible_move:
        for sx, sy in possible_move:
            shark_move(sx, sy, score, fish, direction)
    else:
        res = max(res, score)
        return

shark_move(0,0, 0, fish, direction)
print(res)