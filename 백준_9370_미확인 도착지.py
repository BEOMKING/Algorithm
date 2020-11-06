# 다익스트라 최단경로 알고리즘
# s ~ (g, h 중 짧은 거리) ~ (g, h 중 먼 거리) ~ (목적지 후보까지의 거리)가 목적지 후보까지의 최단거리가 같으면 목적지일 가능성이 있으므로 출력
# 문제를 이해하는데 어려움을 겪었다. 목적지 후보 중에 가장 가까운 곳을 가는 줄 알았으나
# 목적지 후보들의 최단거리와 g, h를 통과하여 가는 최단거리가 같은 후보들을 찾는 문제였다.
import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

result = []
T = int(input())
for _ in range(T):
    n, m, t = map(int, input().split()) # n 교차로 m 도로 t 목적지 후보
    s, g, h = map(int, input().split()) # s 출발지 g h를 경유
    destination = [] # 목적지
    graph = [[] for _ in range(n + 1)] # 연결 교차로 테이블

    for _ in range(m):
        a, b, d = map(int, input().split())
        graph[a].append((b, d)) # 양방향 간선
        graph[b].append((a, d))

    for _ in range(t):
        destination.append(int(input())) # 목적지 후보 리스트

    def dijkstra(s):
        distance = [INF] * (n + 1)
        distance[s] = 0
        q = []
        heapq.heappush(q, (0, s))

        while q:
            dist, now = heapq.heappop(q)
            if distance[now] < dist: # 이미 처리된 적이 있으면 태스
                continue
            for desti, cos in graph[now]:
                cost = dist + cos
                if cost < distance[desti]:
                    distance[desti] = cost
                    heapq.heappush(q, (cost, desti))
        return distance

    one = dijkstra(s) # 출발지에서의 최단경로 테이블
    if one[g] < one[h]: # 출발지에서 g, h 중 가까운 곳을 찾음
        onetotwo = one[g] # 출발지에서 g로 가는 거리
        two = dijkstra(g) # g에서의 최단 경로 테이블
        twotothree = two[h] # g에서 h까지 거리
        three = dijkstra(h) # h에서의 최단 경로 테이블
    else:
        onetotwo = one[h]
        two = dijkstra(h)
        twotothree = two[g]
        three = dijkstra(g)

    answer = []
    for i in destination:
        dist = onetotwo + twotothree + three[i] # 목적지 후보까지의 거리
        if dist == one[i]: # 목적지 후보까지의 거리와 최단거리가 같다면
            answer.append(i)
    answer.sort() # 오름차순이므로 정렬
    result.append(answer) # 결과 리스트에 추가
for i in result:
    for j in i:
        print(j, end=' ')
    print('')