A, B = map(int, input().split(' '))

A = (A // 100) + ((A % 100) - (A % 10)) + ((A % 10) * 100)
B = (B // 100) + ((B % 100) - (B % 10)) + ((B % 10) * 100)

if A > B:
    print(A)
elif A < B:
    print(B)