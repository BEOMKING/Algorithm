ball =[11, 2, 9, 13, 24]
order = [9, 2, 13, 24, 11]
length = len(ball)
result = []
i = 0
while True:
    if ball[0] == order[i]:
        result.append(order[i])
        ball.remove(order[i])
        order.remove(order[i])

        i = 0
    elif ball[-1] == order[i]:
        result.append(order[i])
        ball.remove(order[i])
        order.remove(order[i])

        i = 0
    else:
        i += 1
    if len(result) == length:
        break
print(result)