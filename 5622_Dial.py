String = list(input())
OutPut = []
for i in range(len(String)):
    if String[i] == 'A' or String[i] == 'B' or String[i] == 'C':
        OutPut.append(3)
    elif String[i] == 'D' or String[i] == 'E' or String[i] == 'F':
        OutPut.append(4)
    elif String[i] == 'G' or String[i] == 'H' or String[i] == 'I':
        OutPut.append(5)
    elif String[i] == 'J' or String[i] == 'K' or String[i] == 'L':
        OutPut.append(6)
    elif String[i] == 'M' or String[i] == 'N' or String[i] == 'O':
        OutPut.append(7)
    elif String[i] == 'P' or String[i] == 'Q' or String[i] == 'R' or String[i] == 'S':
        OutPut.append(8)
    elif String[i] == 'T' or String[i] == 'U' or String[i] == 'V':
        OutPut.append(9)
    elif String[i] == 'W' or String[i] == 'X' or String[i] == 'Y' or String[i] == 'Z':
        OutPut.append(10)
print(sum(OutPut))

# words = input().lower()
# s = ['abc','def','ghi','jkl','mno','pqrs','tuv','wxyz']
#
# time = 0
# for i in range(len(words)):
#     for j in s:
#         if(words[i] in j):
#             time += s.index(j) + 3
# print(time)
