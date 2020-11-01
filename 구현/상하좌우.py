# 내 풀이 무식하게 모든 경우의 수를 나눔
N = int(input())
Plan = input().split()
nowy, nowx = 1, 1

for move in Plan:
    if move == 'L':
        if nowx - 1 < 1:
            pass
        else:
            nowx -= 1
    elif move == 'R':
        if nowx + 1 > N:
            pass
        else:
            nowx += 1
    elif move == 'U':
        if nowy - 1 < 1:
            pass
        else:
            nowy -= 1
    else:
        if nowy + 1 > N:
            pass
        else:
            nowy += 1
print(nowy, nowx)

# 최적의 풀이

# N 입력받기
n = int(input())
x, y = 1, 1
plans = input().split()

# L, R, U, D에 따른 이동 방향
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
move_types = ['L', 'R', 'U', 'D']

# 이동 계획을 하나씩 확인
for plan in plans:
    # 이동 후 좌표 구하기
    for i in range(len(move_types)):
        if plan == move_types[i]:
            nx = x + dx[i]
            ny = y + dy[i]
    # 공간을 벗어나는 경우 무시
    if nx < 1 or ny < 1 or nx > n or ny > n:
        continue
    # 이동 수행
    x, y = nx, ny

print(x, y)
