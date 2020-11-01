# 내 답안

N, M = map(int, input().split())
Card = []
for _ in range(N):
    Card.append(list(map(int, input().split())))
Big = min(Card[0])
for row in Card:
    temp = min(row)
    if temp > Big:
        Big = temp
print(Big)

# min() 함수를 이용하는 빠른 답안

n, m = map(int, input().split())
result = 0
for i in range(n):
    data = list(map(int, input().split()))
    min_value = min(data)
    result = max(result, min_value)

# 2중 반복문 구조를 사용하는 답안

n, m = map(int, input().split())
result = 0
for i in range(n):
    data = list(map(int, input().split()))
    min_value = 10001
    for a in data:
        min_value = min(min_value, a)
    result = max(result, min_value)