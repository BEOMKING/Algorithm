N, M = map(int, input().split())  # N <= 500 M <= 10000
times = []
for i in range(N):  # 직접 연결된 도로를 통해 이동하는 시간 삽입 < 1000000
    times.append(list(map(int, input().split())))
customer = []
for i in range(M):  # 손님의 정보를 입력 C < 10000000000
    A, B, C = map(int, input().split())
customer.append((A, B, C))

for z in range(N):  # 직접 연결된 통로 정보로 최단 거리 계산
    for a in range(N):
        for b in range(N):
            times[a][b] = min(times[a][b], times[a][z] + times[z][b])

for i in customer:  # 손님의 이동 시간이 파티가 열리는 시간보다 작다면 가능
    if times[i[0] - 1][i[1] - 1] <= i[2]:
        print('Enjoy other party')
else:
    print('Stay here')
# 문제는 쉬웠으나 sys를 사용했을 때 12.6초
# 그냥 했을때 12.7초
# pypy3를 사용했을때 0.5초가 나옴