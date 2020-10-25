while True:
    x, y, z = map(int, input().split())
    if x == 0 and y == 0 and z == 0:
        break
    X = []
    ma = max(x, y, z)
    mi = min(x, y, z)
    X.append(x)
    X.append(y)
    X.append(z)
    mid = 0
    for i in X:
        if i != ma and i != mi:
            mid = i

    if mi ** 2 + mid ** 2 == ma ** 2:
        print('right')
    else:
        print('wrong')