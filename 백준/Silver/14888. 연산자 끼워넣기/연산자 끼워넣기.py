n = int(input())
num = list(map(int, input().split()))
add, sub, mul, div = list(map(int, input().split()))

# 초기화를 정수형으로 해줘야함
max_v = int(-1e9)
min_v = int(1e9)

#함수 구현
def dfs(cnt, result, add, sub, mul, div) :
    global max_v, min_v

    if cnt == n :                   #cnt가 n이 되었을 때 max와 min을 반환 (함수종료)
        max_v = max(result, max_v)
        min_v = min(result, min_v)
        return
    if add > 0 :
        dfs(cnt+1, result + num[cnt], add-1, sub, mul, div)
    if sub > 0 :
        dfs(cnt+1, result - num[cnt], add, sub-1, mul, div)
    if mul > 0 :
        dfs(cnt+1, result * num[cnt], add, sub, mul-1, div)
    if div > 0 :
        dfs(cnt+1, int(result/num[cnt]), add, sub, mul, div-1)

dfs(1, num[0], add, sub, mul, div)
print(max_v)
print(min_v)