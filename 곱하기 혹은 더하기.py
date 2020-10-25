# 내 풀이 예외 사항을 좀 더 확인하고 효율적인 풀이 필요
N = input()
List = []
for i in N:
    List.append(int(i))
List.sort()
answer = 0

for str in List:
    if str == '0' or str == '1' or answer == 1:
        answer += int(str)
    elif answer == 0:
        answer = 1
        answer *= int(str)
    else:
        answer *= int(str)
print(answer)

# 최적의 풀이
data = input()

# 첫 번째 문자를 숫자로 변경하여 대입
result = int(data[0])

for i in range(1, len(data)):
    # 두 수 중에서 하나라도 '0' 혹은 '1'인 경우, 곱하기보다는 더하기 수행
    num = int(data[i])
    if num <= 1 or result <= 1:
        result += num
    else:
        result *= num

print(result)