def factorial(N):
    fact = 1
    for i in range(1, N + 1):
        fact *= i
    return fact
print(factorial(int(input())))

# 재귀적 해결 필요