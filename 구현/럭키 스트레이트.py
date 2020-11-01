N = int(input())

Score = [int(x) for x in str(N)]
left = sum(Score[0:len(Score) // 2])
right = sum(Score[len(Score) // 2:])

# for i in range(len(Score) // 2):
#     left += Score[i]
#     right += Score[-i - 1]

if left == right:
    print('LUCKY')
else:
    print('READY')
