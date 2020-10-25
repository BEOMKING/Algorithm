max = 1
N = 71
k = 3
for i in range(10):
    while True:
        if N % k != 0:
            max = max * (N % k)
        if N < k:
            break
        N = N // k
    k += 1
print(max, k)