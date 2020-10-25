N = int(input())
for j in range(N):
    count = 0
    Case = list(input())
    for i in range(len(Case)):
        T = 0
        if Case[i] == 'O':
            count += 1
            while True:
                T += 1
                if i - T >= 0:
                    if Case[i - T] == 'O':
                        count += 1
                    else:
                        break
                else:
                    break
        else:
            count += 0
    print(count)
# n = int(input()) 다른 풀이
# for i in range(n):
#     Num = input()
#     score = 0
#     cnt = 0
#     for j in range(len(Num)):
#         if Num[j] == 'O':
#             cnt += 1
#             score += cnt
#         elif Num[j] == 'X':
#             score += 0
#             cnt = 0
#     print(score)
