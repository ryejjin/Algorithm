import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline
number = []

while True:
    try:
        number.append(int(input()))
    except:
        break

def postorder(s, e):
    if s > e:
        return
    mid = e+1

    for i in range(s+1, e+1):
        if number[s] < number[i]:
            mid = i
            break

    postorder(s+1, mid-1)
    postorder(mid, e)
    print(number[s])

postorder(0, len(number)-1)