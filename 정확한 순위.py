N, M = map(int, input().split())
comparison = [[0] * (N + 1) for _ in range(N + 1)]
for i in range(M): #A B는 비교 가능하므로 1로 초기화
    A, B = map(int, input().split())
    comparison[A][B] = 1
for k in range(1, N + 1): #순위 비교가 가능한 학생들을 찾아 1로 초기화
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            if comparison[i][k] and comparison[k][j]: #i학생이 k학생과 순위 비교가 가능하고 k학생이 j학생과 비교 가능하면 i와 j학생은 비교 가능함
                comparison[i][j] = 1
for i in range(1, N + 1):
    for j in range(1, N + 1):
        if comparison[i][j] == 1: #순위 비교가 가능하면 역으로 순위비교도 가능한 것이므로 대칭 시켜줌
            comparison[j][i] = 1
exactly = 0
for i in range(1, N + 1): #자기 자신은 순위에서 제외하므로 count로 1을 주고 순위 비교가 안되는 사람이 나올때 마다 -1
    count = 1 #count가 0이 되어야 비교 안되는 대상이 없는 것이므로 출력
    for j in range(1, N + 1):
        if comparison[i][j] == 0:
            count -= 1
    if count == 0:
        exactly += 1
print(exactly)
# 또 다른 풀이
# INF = int(1e9)  # 무한을 의미하는 값으로 10억을 설정
#
# # 노드의 개수, 간선의 개수를 입력받기
# n, m = map(int, input().split())
# # 2차원 리스트(그래프 표현)를 만들고, 모든 값을 무한으로 초기화
# graph = [[INF] * (n + 1) for _ in range(n + 1)]
#
# # 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
# for a in range(1, n + 1):
#     for b in range(1, n + 1):
#         if a == b:
#             graph[a][b] = 0
#
# # 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
# for _ in range(m):
#     # A에서 B로 가는 비용을 1로 설정
#     a, b = map(int, input().split())
#     graph[a][b] = 1
#
# # 점화식에 따라 플로이드 워셜 알고리즘을 수행
# for k in range(1, n + 1):
#     for a in range(1, n + 1):
#         for b in range(1, n + 1):
#             graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
#
# result = 0
# # 각 학생을 번호에 따라 한 명씩 확인하며 도달 가능한지 체크
# for i in range(1, n + 1):
#     count = 0
#     for j in range(1, n + 1):
#         if graph[i][j] != INF or graph[j][i] != INF:
#             count += 1
#     if count == n:
#         result += 1
# print(result)