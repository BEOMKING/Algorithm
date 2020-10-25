C = int(input())
Out = []

for j in range(C):
    N = list(map(int, input().split()))
    if not (1 <= N[0] <= 1000):
        exit()
    Average = ((sum(N) - N[0]) / N[0])
    Sum = 0
    for i in range(N[0]):
        if not (0 <= N[i + 1] <= 100):
            exit()
        if Average < N[i + 1]:
            Sum += 1
    Out.append('%0.3f' % round(((Sum / N[0]) * 100), 3))      # 다시 풀어본다 *******************

for k in Out:
    print('%s%%' % k)

'''
C = int(input())
Out = []

for j in range(C):
    N = list(map(int, input().split()))
    Average = ((sum(N) - N[0]) / N[0])
    Sum = 0
    for i in range(N[0]):
        if Average < N[i + 1]:
            Sum += 1
    print('{0}%'.format('%0.3f' % round(((Sum / N[0]) * 100), 3)))
    '''