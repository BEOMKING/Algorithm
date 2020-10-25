N, M = map(int, input().split()) # N 떡의 개수, M 요청한 떡의 길이
rice = list(map(int, input().split())) # N개 떡의 정보
start = 0 # 시작점
end = max(rice) # 가장 큰 떡의 길이
result = 0
while(start <= end):
    mid = (start + end) // 2
    customer = 0 # 손님이 가져갈 떡의 길이 합
    for cake in rice:
        if cake > mid:
            customer += (cake - mid)
    # if customer > M:
    #     start = mid + 1
    # elif customer == M:
    #     break
    # else:
    #     end = mid - 1
    if customer < M:
        end = mid - 1
    else:
        result = mid
        start = mid + 1
print(result)