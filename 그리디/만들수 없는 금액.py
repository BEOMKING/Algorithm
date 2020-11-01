# 내 풀이 문제를 또 잘못 이해해서 + 생각만 하면 될 것을 x 생각을 하고 있었음, 정확한 이해 필요
from itertools import permutations

N = int(input())
Unit = list(map(int , input().split()))
money = []
for i in range(1, N + 1):
    permut = list(permutations(Unit, i))
    for j in permut:
        money.append(sum(j))
i = 1
while True:
    if i in money:
        i += 1
    else:
        print(i)
        break

# 순열을 사용하지 않는 최적의 풀이
n = int(input())
data = list(map(int, input().split()))
data.sort()

target = 1
for x in data:
    # 만들 수 없는 금액을 찾았을 때 반복 종료
    if target < x:
        break
    target += x

# 만들 수 없는 금액 출력
print(target)