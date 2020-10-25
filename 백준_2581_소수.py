M = int(input())
N = int(input())
Example = list(range(M, N + 1))
Decimal = []
for i in Example:
    count = 0
    if i == 2:
        Decimal.append(i)
    if i % 2 != 0 and i != 1:
        for j in range(1, (i // 2) + 1):
            if i % j == 0:
                count += 1
        if count == 1:
            Decimal.append(i)
if len(Decimal) == 0:
    print(-1)
else:
    print(sum(Decimal))
    print(Decimal[0])