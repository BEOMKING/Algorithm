A = int(input())
B = int(input())
C = int(input())
List = []

if not ((0 <= A < 1000) and (0 <= B < 1000) and (0 <= C < 1000)):
    exit()

Mul = A * B * C
List = list(map(int, list(str(Mul)))) # ***************************
print(List.count(0))
print(List.count(1))
print(List.count(2))
print(List.count(3))
print(List.count(4))
print(List.count(5))
print(List.count(6))
print(List.count(7))
print(List.count(8))
print(List.count(9))

# A = int(input())
# B = int(input())
# C = int(input())
# result = str(A * B * C)
# result = list(result)
# answer = [0] * 10
# for i in result:
#     answer[int(i)] += 1
# for i in answer:
#     print(i)