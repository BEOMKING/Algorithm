N = int(input())
Part = list(map(int, input().split()))
M = int(input())
Customer = list(map(int, input().split()))
# for c in Customer: 순차탐색
#     if c in Part:
#         print('yes', end=' ')
#     else:
#         print('no', end=' ')

# Comparison = [0] * 1000000 계수 정렬
# for i in Part:
#     Comparison[i - 1] = 1
# for i in Customer:
#     if Comparison[i - 1] == 1:
#         print('yes', end=' ')
#     else:
#         print('no', end=' ')

Part.sort()
def binarysearch(start, end, target):
    while start <= end:
        mid = (start + end) // 2
        if Part[mid] < target:
            start = mid + 1
        elif target == Part[mid]:
            return True
        else:
            end = mid - 1
    return False

for i in Customer:
    if binarysearch(0, len(Part) - 1, i) == True:
        print('yes', end=' ')
    else:
        print('no', end=' ')