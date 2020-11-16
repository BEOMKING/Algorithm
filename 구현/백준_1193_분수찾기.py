X = int(input())
row = 1 # 행렬 요소의 누적 개수
count = 1 # 찾는 값이 있는 열 번호
while True:
    if row >= X: # 주어진 번호가 누적개수보다 작다면
        row -= count # 누적 개수에서 방금 더한 count를 뺌
        X -= row # count번째 줄에서 몇 번째인지
        a = count + 1 - X
        b = X
        if count % 2: # 열이 홀수라면
            print('%d/%d' % (a, b))
        else:
            print('%d/%d' % (b, a))
        break
    else:
        count += 1
        row += count