t = int(input())
result = []
for _ in range(t):
    N, M = map(int, input().split())
    important = list(map(int, input().split()))
    order = M # 찾는 문서의 인덱스
    count = 0 # 나가는 순서
    while True: # 3
        if important[0] == max(important): # 첫째 값과 리스트의 최대값이 같다면
            count += 1 # 나가는 순서 증가
            del important[0] #큰 값 삭제
            if order == 0: # 첫째 값이 찾는 문서라면
               result.append(count)
               break
            order -= 1 #찾는 문서의 인덱스를 옮김
        else:
            q = important[0]
            del important[0]
            important.append(q)
            if order == 0:
                order = len(important) - 1
            else:
                order -= 1
for i in result:
    print(i)
# 이렇게 오래 걸릴게 아닌데 너무 헷갈리게 풀었다.