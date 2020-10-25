def printstar(N):
    for i in range(N):
        print('***' * 3**2)
        print('* *' * 3**2)
        print('***' * 3**2)
        print()

print(printstar(int(input())))