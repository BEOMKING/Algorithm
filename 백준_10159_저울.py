N = int(input()) # 물건의 개수
M = int(input()) # 미리 측정된 물건 쌍의 개수
INF = int(10e9)
weight = [[INF] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if i == j:
            weight[i][j] = 0
for _ in range(M):
    a, b = map(int, input().split())
    weight[a-1][b-1] = 1

for a in range(N):
    for b in range(N):
        for c in range(N):
            weight[b][c] = min(weight[b][c], weight[b][a] + weight[a][c])
print(weight)
for i in weight:
    count = 0
    for j in i:
        if j == INF:
            count += 1
    print(count)