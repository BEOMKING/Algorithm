# 플로이드 와샬
# 자기 자신으로 가는 거리를 0으로 설정하고 특정 도시로 가는 경로와 오는 경로
# 가 존재하는 것 중에서 가장 작은것을 결과로 했다.
# 다른 풀이로는 자기 자신으로 가는 거리를 0으로 설정하지 않고 풀이하면 좀 더 짧게 할 수 있다.
INF = int(1e9)
V, E = map(int, input().split())
distance = [[INF] * (V + 1) for _ in range(V + 1)]
for _ in range(E):
    a, b, c = map(int, input().split())
    distance[a][b] = c
for i in range(1, V + 1):
    for j in range(1, V + 1):
        if i == j:
            distance[i][j] = 0
for k in range(1, V + 1):
    for i in range(1, V + 1):
        for j in range(1, V + 1):
            distance[i][j] = min(distance[i][j], distance[i][k] + distance[k][j])
result = []
for i in range(1, V + 1):
    for j in range(1, V + 1):
        if i != j and distance[i][j] < INF and distance[j][i] < INF:
            result.append(distance[i][j] + distance[j][i])
print(min(result)) if len(result) > 0 else print(-1)
