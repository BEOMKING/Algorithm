answers = [1, 3, 2, 4, 2, 6, 7, 8, 5, 6, 3, 1, 5]
num1, num2, num3 = 0, 0, 0
answer = []
for i in range(len(answers)):
    if (i + 1) % 5 == 0 and answers[i] == 5:
        num1 += 1
    elif answers[i] == (i + 1) % 5:
        num1 += 1

    if i % 2:
        if i % 8 == 1 and answers[i] == 1:
            num2 += 1
        elif i % 8 == 3 and answers[i] == 3:
            num2 += 1
        elif i % 8 == 5 and answers[i] == 4:
            num2 += 1
        elif i % 8 == 7 and answers[i] == 5:
            num2 += 1
    else:
        if answers[i] == 2:
            num2 += 1

    if (i % 10 == 0 or i % 10 == 1) and answers[i] == 3:
        num3 += 1
    elif (i % 10 == 2 or i % 10 == 3) and answers[i] == 1:
        num3 += 1
    elif (i % 10 == 4 or i % 10 == 5) and answers[i] == 2:
        num3 += 1
    elif (i % 10 == 6 or i % 10 == 7) and answers[i] == 4:
        num3 += 1
    elif (i % 10 == 8 or i % 10 == 9) and answers[i] == 5:
        num3 += 1

maxx = max(num1, num2, num3)
if maxx == num1:
    answer.append(1)
if maxx == num2:
    answer.append(2)
if maxx == num3:
    answer.append(3)
print(answer)