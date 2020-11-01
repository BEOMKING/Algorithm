N, M, K = map(int, input().split())
List = list(map(int, input().split()))
List.sort(reverse=True)
answer = 0
count = 0

while M != 0:
    answer += List[0]
    M -= 1
    count += 1
    if count == K:
        answer += List[1]
        M -= 1
        count = 0

print(answer)