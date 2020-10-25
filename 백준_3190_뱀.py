N = int(input())
K = int(input())
Location = [] # 사과 위치
Board = [[0] * N for i in range(N)] # 맵 정보

for _ in range(K): # 사과가 있는 곳 1로 표시
    a, b = map(int, input().split())
    Board[a][b] = 1

L = int(input())
Direction = [] # 방향 회전 정보
for _ in range(L):
    X, C = input().split()
    Direction.append([int(X), C])

dx = [0, -1, 0, 1] # 동 남 서 북
dy = [1, 0, -1, 0]

tail = 1
head = 1
second = 0
x = 0
y = 0
temp = 0

directnum = 0
while True:
    if second == Direction[directnum][0]:
        if Direction[directnum][1] == 'L':
            d -= 1
            if d < 0:
                d = 3
        else:
            d += 1
            if d > 3:
                d = 0

    second += 1
    x += 1
    temp = Board[y][x]
    Board[y][x] = head

    if temp == 'apple':
        second += 1
        Board[y][x] += tail
        Board[y][x - 1] = 0
        second += 1
    else:
        Board[y][x] += tail
        Board[y][x - 1] = 0
        second += 1

    Board[y][x] = head
    Board[0][0] = tail
    second += 1