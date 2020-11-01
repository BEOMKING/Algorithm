import math
Decimal = [2]
for i in range(3, 246913):
    count = 0
    if i % 2 != 0:
        for j in range(3, math.ceil(math.sqrt(i)) + 1):
           if i % j == 0:
               count += 1
               break
        if count == 0:
            Decimal.append(i)
while True:
    N = int(input())
    Count = 0
    if N == 0:
        break
    for i in Decimal:
        if N < i <= N * 2:
            Count += 1
    print(Count)