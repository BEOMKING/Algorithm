N = int(input())
if not (1 <= N <= 1000000):
    exit()

List = []
List = list(map(int, input().split(' ')))
'''
while True:
    List = list(input().split(' '))
    if len(List) == N:
        break
'''
List.sort()
print(List[0], List[N - 1]) #print(min(List), max(LIst))
