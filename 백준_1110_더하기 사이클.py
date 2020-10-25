N = int(input())
FN = 0
SN = 0
RN = 0
OriginalN = N
Cycle = 0

if not (0 <= N <= 99):
    exit()

while True:
    FN = N // 10
    SN = N % 10
    RN = (FN + SN) % 10
    Cycle = Cycle + 1

    if (SN * 10) + RN == OriginalN:
        break
    else:
        N = (SN * 10) + RN ## 다시 풀어봐라

print(Cycle)