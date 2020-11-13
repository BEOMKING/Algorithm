import sys
input = sys.stdin.readline

N = int(input())
integer = [int(input()) for _ in range(N)]

average = int(round(sum(integer) / N, 0))

sor = sorted(integer)
mid = sor[N//2]

count = [0 for _ in range(-4000, 4001)]
for i in sor:
    count[i + 4000] += 1
frequency = []
for i in range(len(count)):
    if count[i] == max(count):
        frequency.append(i - 4000)
if len(frequency) > 1:
    fre = frequency[1]
else:
    fre = frequency[0]

ran = max(integer) - min(integer)

print(average)
print(mid)
print(fre)
print(ran)