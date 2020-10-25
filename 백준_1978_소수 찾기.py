N = int(input())
Decimal = list(map(int, input().split()))
count = 0

if len(Decimal) == N:
    for i in Decimal:
        deci = 2
        if i == 2:
            count += 1
        if i == 3:
            count += 1
        if i != 1 and i % 2 != 0 and i != 3:
            count += 1
            while deci <= i // 2:
                if i % deci == 0:
                    count -= 1
                    break
                deci += 1
print(count)