N, M = map(int, input().split())
maze = []
for _ in range(N):
    maze.append(list(map(int, input())))
# distance = [[0] * M for _ in range(N)]
# def solution(x, y, dis):
#     if x <= -1 or x >= N or y <= -1 or y >= M:
#         return False
#     if maze[x][y] == 1:
#         maze[x][y] = 0
#         dis += 1
#         distance[x][y] = dis
#         solution(x - 1, y, dis)
#         solution(x + 1, y, dis)
#         solution(x, y - 1, dis)
#         solution(x, y + 1, dis)
# solution(0,0,0)
# print(distance[N-1][M-1])
from collections import deque
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]
def bfs(x,y):
    queue = deque()
    queue.append([x, y])
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if maze[nx][ny] == 0:
                continue
            if maze[nx][ny] == 1:
                maze[nx][ny] = maze[x][y] + 1
                queue.append([nx,ny])
    return maze[N-1][M-1]
print(bfs(0,0))