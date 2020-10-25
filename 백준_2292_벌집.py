N = int(input())
Count = 1
i = 2
num = 6

if N == 1:
    print(1)
else:
    while True:
        Count += 1
        if N >= i and N < i + num:
            print(Count)
            break
        i += num
        num += 6
