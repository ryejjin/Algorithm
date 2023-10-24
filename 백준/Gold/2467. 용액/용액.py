n = int(input())
lst = list(map(int, input().split()))


s, e = 0, n-1
start = end = 0
mix = int(10e10)

while s<e:
    temp = lst[s]+lst[e]
    if mix > abs(temp):
        mix = abs(temp)
        start, end = lst[s], lst[e]

    if temp <= 0:
        s+=1
    else:
        e-=1

print(start, end)