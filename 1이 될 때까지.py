# 내 풀이
N, K = map(int, input().split())
count = 0

while N != 1:
    if N % K:
        N -= 1
        count += 1
    else:
        N = N // K
        count += 1
print(count)

# 값이 클 때 최소 시간 복잡도 풀이
n, k = map(int, input().split())
result = 0

while True:
    # N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
    target = (n // k) * k
    result += (n - target)
    n = target
    # N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
    if n < k:
        break
    # K로 나누기
    result += 1
    n //= k

# 마지막으로 남은 수에 대하여 1씩 빼기
result += (n - 1)
print(result)