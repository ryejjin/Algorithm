n = int(input())
arr = list(map(int, input().split()))
ans = 0

def calc(x1, y1, x2, y2):
    return (y2-y1)/(x2-x1)

for (idx, value) in enumerate(arr):
    view_max = 0
    left_max = float('inf')
    right_max = -float('inf')
    for i in range(idx-1, -1, -1):
        slope = calc(idx+1, value, i+1, arr[i])
        if slope < left_max:
            left_max = slope
            view_max += 1

    for i in range(idx+1, n):
        slope = calc(idx+1, value, i+1, arr[i])
        if slope > right_max:
            right_max = slope
            view_max+=1

    ans = max(ans, view_max)

print(ans)