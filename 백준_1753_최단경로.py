import sys
import heapq
INF = int(1e9)
input = sys.stdin.readline

V, E = map(int, input().split())
K = int(input())
distance = [INF] * (V + 1) #거리 초기화
graph = [[] for _ in range(V + 1)] #노드에 연결된 노드와 거리 삽입

for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append([v, w])

def dijkstra(K):
    q = []
    distance[K] = 0
    heapq.heappush(q, (distance[K], K))#자기 자신으로 가는 거리와 출발 노드
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist: #현재 노드의 최단 거리가 큐에 삽입된 거리보다 작으면 이미 처리된 것이므로 통과
            continue
        for i in graph[now]:
            cost = distance[now] + i[1] #현재 거리비용 + 인접 노드 비용
            if cost < distance[i[0]]: #비용의 합이 거리 테이블의 값보다 작으면 초기화
                distance[i[0]] = cost
                heapq.heappush(q, (distance[i[0]], i[0]))
    for i in range(1, V + 1):
        if distance[i] == INF:
            print('INF')
        else:
            print(distance[i])
dijkstra(K)