N = int(input())
Score = []
Score = list(map(int, input().split(' ')))
Max = max(Score)
Sum = 0
for i in range(len(Score)):
    Score[i] = Score[i] / Max * 100

for i in range(len(Score)):
    Sum += Score[i]

print('%0.2f' % (Sum / N)) #17m 54s