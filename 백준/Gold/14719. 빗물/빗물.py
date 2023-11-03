h, w = map(int, input().split())
arr = list(map(int, input().split()))
rain = 0

wall_max = 0
idx = 0
for i in range(w):
    if arr[i] > wall_max:
        wall_max = arr[i]
        idx = i

wall = 0
for i in range(idx+1):
    if arr[i] > wall:
        wall = arr[i]
    rain += wall
wall_2 = 0

for k in range(w-1, idx, -1):
    if arr[k] > wall_2:
        wall_2 = arr[k]
    rain += wall_2

print(rain-sum(arr))