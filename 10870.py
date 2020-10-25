n = int(input())
List = []
List.append(0)
List.append(1)
for i in range(n):
    List.append(List[i] + List[i + 1])

print(List[n])

# 재귀적 해결 필요
