# 실패
key = [[0, 0, 0], [1, 0, 0], [0, 1, 1]]
lock = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]

def rotate(key):
    N = len(key)
    temp = [[0] * N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            temp[j][N - 1 - i] = key[i][j]
    N = temp

    return N

dx = [-1, 0, 1, 0] # 북 동 남 서
dy = [0, 1, 0, -1]

for direction in range(4):
    N = len(key)
    temp = [[0] * N for _ in range(N)]