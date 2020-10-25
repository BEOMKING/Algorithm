tanding, Variable, Price = map(int, input().split())
Count = 0
if Variable >= Price:
    print(-1)
else:
    Count = Standing // (Price - Variable) + 1
    print(Count)
#다시 풀어보는 걸 추천