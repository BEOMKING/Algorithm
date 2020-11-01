import math
M, N = map(int, input().split())
List = list(range(M, N + 1))
Decimal = []

for i in List:
    count = 0
    if i == 2:
        Decimal.append(2)
    if i % 2 != 0 and i != 1:
        for j in range(3, math.ceil(math.sqrt(i)) + 1):
            if i % j == 0:
                count += 1
                break
        if count == 0:
            Decimal.append(i)
for i in Decimal:
    print(i)