import heapq
n, k = map(int, input().split())
visit = [0]*100001
INF = int(1e9)
dis = [INF] * 100001

def dikjstra(n):
    q = []
    heapq.heappush(q, [0, n])
    dis[n] = 0

    while q:
        time, now = heapq.heappop(q)

        if now == k:
            return dis[now]

        for next in (now*2, now-1, now+1):
            if 0<= next < 100001:
                if next == now*2:
                    if time < dis[next]:
                        dis[next] = time
                        heapq.heappush(q, [time, next])
                else:
                    temp = time + 1
                    if temp < dis[next]:
                        dis[next] = temp
                        heapq.heappush(q, [temp, next])

print(dikjstra(n))