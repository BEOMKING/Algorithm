#정렬
N = int(input())
student = []
for _ in range(N):
    student.append(input().split())
student.sort(key= lambda x: (-int(x[1]), int(x[2]), -int(x[3]), x[0]))
# 두 번째 원소를 기준으로 내림차순 정렬
# 두 번째 원소가 같으면, 세 번째 원소를 기준으로 오름차순
# 세 번째 원소가 같으면, 네 번째 원소를 기준으로 내림차순
# 그것도 같으면 첫 번째 원소를 기준으로 오름차순
for i in student:
    print(i[0])
#sort의 키값으로 람다를 사용하는 것이 중요
# 리스트에서 다중으로 정렬을 수행하는 것이 가능
# -를 설정하면 내림차순