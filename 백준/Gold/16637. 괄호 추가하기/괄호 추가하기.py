n = int(input())
arr = list(input())
res = int(-1e9)

def cal(ele, x, y):
    if ele == '+':
        return x+y
    elif ele == '-':
        return x-y
    elif ele == '*':
        return x*y

def func(value, idx):
    global res
    if idx == n-1:
        res = max(res, value)
        return

    if idx+2 < n:
        temp = cal(arr[idx+1], value, int(arr[idx+2]))
        func(temp, idx+2)

    if idx+4 < n:
        temp_num = cal(arr[idx+3], int(arr[idx+2]), int(arr[idx+4]))
        func(cal(arr[idx+1], value, temp_num), idx+4)

func(int(arr[0]), 0)
print(res)