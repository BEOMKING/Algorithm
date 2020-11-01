# 조합을 사용한 내 풀이
from itertools import combinations

N, M = map(int, input().split())
K = list(map(int, input().split()))
# ball = []
# for i in range(1, len(K) + 1):
#     ball.append(i)
case = list(combinations(K, 2))
count = 0
for i in case:
    if i[0] == i[1]:
        pass
    else:
        count += 1
print(count)

# 조합을 사용하지 않는 최적의 풀이
n, m = map(int, input().split())
data = list(map(int, input().split()))

# 1부터 10까지의 무게를 담을 수 있는 리스트
array = [0] * 11

for x in data:
    # 각 무게에 해당하는 볼링공의 개수 카운트
    array[x] += 1

result = 0
# 1부터 m까지의 각 무게에 대하여 처리
for i in range(1, m + 1):
    n -= array[i] # 무게가 i인 볼링공의 개수(A가 선택할 수 있는 개수) 제외
    result += array[i] * n # B가 선택하는 경우의 수와 곱해주기

print(result)