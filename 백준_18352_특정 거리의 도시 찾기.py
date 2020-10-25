from collections import deque

N, M, K, X = map(int, input().split())
Road = []
STC = []
for _ in range(M):
    Road.append(list(map(int, input().split())))

def dfs(Road, X, visited):
    queue = deque()
    queue.append(X)
    visited[X - 1] = True

    while queue:
        now = queue.popleft()
        

visited = [False] * N

