N, M = map(int, input().split())
Day = []
for i in range(N):
    Day.append(int(input()))
k = max(Day)
dk = 2 * max(Day)
change = ((dk + k) // 2)
while True:
    count = 0
    k = 0
    for i in Day:
        if k <= i:
            k = change
            k -= i
            count += 1
        else:
            k -= i
    if count == M:
        if change