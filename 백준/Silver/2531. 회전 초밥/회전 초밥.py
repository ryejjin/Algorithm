n, d, k, c = map(int, input().split())
convey = [int(input()) for _ in range(n)]
eat_max = 0
for i in range(n):
    if i+k > n:
        eat = len(set(convey[i:n] + convey[:(i+k)%n] + [c]))
    else:
        eat = len(set(convey[i:i+k]+[c]))
    if eat > eat_max:
        eat_max = eat
print(eat_max)