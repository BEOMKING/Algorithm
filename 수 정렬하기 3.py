import sys # 계수 정렬 문제
input = sys.stdin.readline
print = sys.stdout.write

N = int(input())
M = [0] * (10001) # 최대 입력 값이 10000이므로 개수를 담을 리스트 생성
for i in range(N):
    M[int(input())] += 1 # 해당 위치에 + 1
for i in range(1, len(M)): # 리스트에서 카운트 숫자만큼 반복 출력
    if M[i] > 0:
        print((str(i)+'\n')*M[i])
# 시간과 메모리가 한정적인 문제라 sys의 사용과 배열의 크기를 한정시켜 시간을 줄이는 문제
