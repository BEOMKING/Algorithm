N, M = map(int, input().split())
City = [list(map(int, input().split())) for _ in range(N)]
H = []
CH = []
Distance = []
NewCH = []
MInimumDis = []
for r in range(N):
    for c in range(N):
        if City[r][c] == 1:
            H.append([r, c])
        elif City[r][c] == 2:
            CH.append([r, c])
for x, y in CH:
    count = 0
    for a, b in H:
        count += abs(x-a) + abs(y-b)
    Distance.append(count)
idx = sorted(Distance)

for i in range(M):
    NewCH.append(CH[Distance.index(idx[i])])
    idx = -1
for x,y in H:
    temp = abs(x - NewCH[0][0]) + abs(y - NewCH[0][1])
    for a, b in NewCH:
        count = abs(x - a) + abs(y - b)
        temp = min(temp, count)
    MInimumDis.append(temp)
print(sum(MInimumDis))
