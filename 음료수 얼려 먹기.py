N, M = map(int, input().split())
Ice = []
for i in range(N):
    Ice.append(list(map(int, input())))
result = 0

def dfs(x, y):
    if x <= -1 or x >= N or y <= -1 or y >= M:
        return False
    if Ice[x][y] == 0:
        Ice[x][y] = 1
        dfs(x - 1, y)
        dfs(x + 1, y)
        dfs(x, y - 1)
        dfs(x, y + 1)
        return True

for i in range(N):
    for j in range(M):
        if dfs(i, j) == True:
          result += 1
print(result)
