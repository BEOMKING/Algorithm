Sugar = int(input())

div = Sugar // 5
Count = 0
while div >= 0:
    if (Sugar % 5) % 3 == 0:
        Count = (div) + ((Sugar % 5) // 3)
        print(Count)
        break
    elif div == 0 and Sugar % 3 != 0:
        print(-1)
        break
    else:
        div -= 1
        if (Sugar - (5 * div)) % 3 == 0:
            Count = div + ((Sugar - (5 * div)) // 3)
            print(Count)
            break
