N = int(input())
Y = int(input())
if N > 0 and Y > 0:
    print(1)
elif N < 0 and Y > 0:
    print(2)
elif N < 0 and Y < 0:
    print(3)
elif N > 0 and Y < 0:
    print(4)