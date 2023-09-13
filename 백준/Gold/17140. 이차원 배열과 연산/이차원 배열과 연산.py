R, C, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(3)]
time = 0
flag = 1
while flag:
    r = len(arr)
    c = len(arr[0])
    if r>=R and c>=C:
        if arr[R-1][C-1] == K:
            flag = 0
            break

    new_arr = []

    if len(arr) >= len(arr[0]):
        col_max = 0
        for i in range(len(arr)):
            temp = [0] * 101
            for j in range(len(arr[i])):
                temp[arr[i][j]] += 1
            tmp = []
            for k in range(1, 101):
                if temp[k] != 0:
                    tmp.append([k, temp[k]])
            tmp.sort(key=lambda x : (x[1], x[0]))
            ttmp = []
            for a in range(len(tmp)):
                ttmp.append(tmp[a][0])
                ttmp.append(tmp[a][1])
            new_arr.append(ttmp)
            col = len(ttmp)
            if col_max < col:
                col_max = col

        for l in range(len(new_arr)):
            if len(new_arr[l]) < col_max:
                for x in range(col_max-len(new_arr[l])):
                    new_arr[l].append(0)

    else:
        row_max = 0
        for i in range(len(arr[0])):
            temp = [0]*101
            for j in range(len(arr)):
                temp[arr[j][i]] += 1
            tmp = []
            for k in range(1, 101):
                if temp[k] != 0:
                    tmp.append((k, temp[k]))
            tmp.sort(key=lambda x : (x[1], x[0]))
            ttmp = []
            for a in range(len(tmp)):
                ttmp.append(tmp[a][0])
                ttmp.append(tmp[a][1])
            new_arr.append(ttmp)
            row = len(ttmp)
            if row_max < row:
                row_max = row

        for l in range(len(new_arr)):
            if len(new_arr[l]) < row_max:
                for x in range(row_max-len(new_arr[l])):
                    new_arr[l].append(0)
        new_arr = list(zip(*new_arr))

    arr = new_arr
    time += 1

    if time > 100:
        break

if flag:
    print(-1)
else:
    print(time)