H, M = map(int, input().split(' '))

if (0 <= H and H <= 23) and (0 <= M and M <= 59):
    if M < 45:
        if H == 0:
            print(H + 23, M + 15)
        else:
            print(H -1, M + 15)
    else:
        print(H, M - 45)