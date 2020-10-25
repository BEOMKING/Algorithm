N = int(input())
if N > 1000:
    exit()
count = 0
for i in range(1, N + 1):
    a = list(map(int, list(str(i))))
    if len(a) == 1:
        count += 1
    elif len(a) == 2:
        count += 1
    elif len(a) == 3:
        if a[0] - a[1] == a[1] - a[2]:
            count += 1
    else:
        if a[0] - a[1] == a[1] - a[2] == a[2] - a[3]:
            count += 1