n = int(input())
m = int(input())
INF = int(1e9)
mincost = [[INF] * n for _ in range(n)] #버스 비용 초기화

for i in range(n): #자기 자신으로 가는 비용 0으로 초기화
    for j in range(n):
        if i == j:
            mincost[i][j] = 0

for _ in range(m): #노선이 하나가 아닐 수도 있기 때문에 INF가 아닐 때 최소 값 넣음
    a, b, c = map(int, input().split())
    if c < mincost[a - 1][b - 1]:
        mincost[a - 1][b - 1] = c

for k in range(n): #모든 점을 경유하는 최단 거리 비교
    for i in range(n):
        for j in range(n):
            mincost[i][j] = min(mincost[i][j], mincost[i][k] + mincost[k][j])
for i in mincost:
    for j in i:
        if j == INF:
            j = 0
        print(j, end=' ')
    print()

#이 문제 또한 pypy가 훨씬 빠른 속도를 가짐
#그리고 조금 더 꼼꼼하게 보기