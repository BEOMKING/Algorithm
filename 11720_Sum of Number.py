N = int(input())
SUM = int(input())
OUT = 0
for i in range(N):
    OUT += (SUM % (10 ** (i + 1)) // (10 ** i))
print(OUT)

# 다른 풀이
# a = int(input())
# b = list(input())
# result = 0
#
# for i in b:
#         result += int(i)
# print(b)
# print(result)