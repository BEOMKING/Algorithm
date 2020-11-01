def solution(board, moves):
    answer = 0
    stack = []

    for i in moves:
        for j in range(len(board)):
            if board[j][i - 1]:
                stack.append(board[j][i - 1])
                board[j][i - 1] = 0
                if len(stack) > 1:
                    if stack[-1] == stack[-2]:
                        del stack[-1]
                        del stack[-1]
                        answer += 2
                break
    return answer
#문제 이해 시1발
''' 다른 사람 예시
def solution(board, moves):
    answer = 0
    bucket = []
    for move in moves:
        for i in range(len(board)):
            if board[i][move - 1]:
                bucket.append(board[i][move - 1])
                board[i][move - 1] = 0
                if len(bucket) > 1 and bucket[-1] == bucket[-2]:
                    answer = answer + 2
                    del bucket[-2:]
                break
    return answer
'''