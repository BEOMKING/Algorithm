# 다익스트라
import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

N, M = map(int, input().split()) #N 헛간 개수 M 통로 개수
hudgan = [[] for _ in range(N + 1)] #헛간과 연결된 헛간 번호
loadcount = [INF] * (N + 1) #1번 헛간과의 거리 초기화
for _ in range(M): # 양방향이기 때문에 양쪽 모두 삽입
    A, B = map(int, input().split())
    hudgan[A].append(B)
    hudgan[B].append(A)
q = []
heapq.heappush(q, (0, 1)) #첫 번째 헛간과 거리 0 삽입
loadcount[1] = 0 #자기 자신으로 가는 거리 초기화
while q:
    dist, now = heapq.heappop(q)
    if loadcount[now] < dist: #이미 처리된 적이 있으면 무시
        continue
    for i in hudgan[now]: #현재 헛간과 연결된 곳 거리 체크
        if loadcount[now] + 1 < loadcount[i]: # 현재 헛간 + 1이 연결된 헛간의 거리보다 작다면 
            loadcount[i] = loadcount[now] + 1 # 거리 수정
            heapq.heappush(q, (loadcount[i], i)) # 다음 헛간 힙에 삽입
loadcount[0] = 0
for i in range(1, N + 1):
    if max(loadcount) == loadcount[i]:
        print(i, end=' ')
        print(max(loadcount), end=' ')
        print(loadcount.count(max(loadcount)))
        break