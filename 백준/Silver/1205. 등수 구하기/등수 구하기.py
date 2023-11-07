n, score, p = map(int, input().split())
if n == 0:
    print(1 if p > 0 else -1)
else:
    arr = list(map(int, input().split()))
    arr.sort(reverse=True)
    rank = 1
    equal_score_count = 0
    for i in arr:
        if i > score:
            rank += 1
        if i == score:
            equal_score_count += 1
    if rank > p:
        print(-1)
    else:
        print(rank if rank <= p - equal_score_count else -1)