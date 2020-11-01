#다익스트라 문제 플로이드 와샬로도 풀 수 있음
import sys
import heapq
INF = int(1e9)
input = sys.stdin.readline

N, E = map(int, input().split()) #정점, 간선
graph = [[] for _ in range(N + 1)] #정점과 연결된 정점과 거리 테이블
for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c)) # 양방향 간선이기 때문에 (반대로 가는 경우에 비용이 더적을수 있음)
v1, v2 = map(int, input().split())#반드시 거쳐야되는 정점
start = 1
def dijkstra(start):
    q = []
    distance = [INF] * (N + 1)
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    return distance
one = dijkstra(start) #시작점 1에서 정점들의 거리
v1_ = dijkstra(v1) #v1에서 정점들의 거리
v2_ = dijkstra(v2) #v2에서 정점들의 거리
answer = min(one[v1] + v1_[v2] + v2_[N], one[v2] + v2_[v1] + v1_[N])
print(-1 if answer >= INF else answer)