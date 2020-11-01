s = "abcabcdede"
answer = len(s) # 이 길이 이상으로는 나올수 없다
for cut in range(1, len(s) // 2 + 1): # 정해진 길이만큼 잘라야하므로 문자열 / 2 이상이 될 수 없다.
    apeach = [s[j:j + cut] for j in range(0, len(s), cut)] # cut 값으로 자른 문자열 리스트
    temp = apeach[0]
    count = 1
    string = ''
    for i in range(1, len(apeach)):
        if temp == apeach[i]:
            count += 1
        else:
            if count > 1:
                string += str(count)
            string += temp
            temp = apeach[i]
            count = 1
        if i == len(apeach) - 1:
            if apeach[-1] == apeach[-2]:
                string += str(count)
                string += temp
            else:
                string += temp

    if answer > len(string):
        answer = len(string)
print(answer)

# 최적의 풀이


def solution(s):
    answer = len(s)
    # 1개 단위(step)부터 압축 단위를 늘려가며 확인
    for step in range(1, len(s) // 2 + 1):
        compressed = ""
        prev = s[0:step] # 앞에서부터 step만큼의 문자열 추출
        count = 1
        # 단위(step) 크기만큼 증가시키며 이전 문자열과 비교
        for j in range(step, len(s), step):
            # 이전 상태와 동일하다면 압축 횟수(count) 증가
            if prev == s[j:j + step]:
                count += 1
            # 다른 문자열이 나왔다면(더 이상 압축하지 못하는 경우라면)
            else:
                compressed += str(count) + prev if count >= 2 else prev
                prev = s[j:j + step] # 다시 상태 초기화
                count = 1
        # 남아있는 문자열에 대해서 처리
        compressed += str(count) + prev if count >= 2 else prev
        # 만들어지는 압축 문자열이 가장 짧은 것이 정답
        answer = min(answer, len(compressed))
    return answer