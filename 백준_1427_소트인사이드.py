N = list((input()))
S = 0
for i in range(len(N)):
    S += int(min(N)) * (10 ** i)
    N.remove(min(N))
print(S)

# nums = list(input())
# onums = sorted(nums, reverse=True)
# for n in onums:
# 	print(n, end='')