logs = ["1901 10 50", "1909 10 50"]
div = [[0] * 101 for i in range(10000)]
person = []
answer = []
for i in logs:
    a, b, c = i.split()
    person.append(a)
    if div[int(a)][int(b)] == 0:
        div[int(a)][int(b)] = int(c)
    else:
        div[int(a)][int(b)] = max(div[int(a)][int(b)], int(c))
person = set(person)
person = list(person)
for i in range(len(person)):
    if div[int(person[0])].count(0) > 96:
        continue
    for j in range(i + 1, len(person)):
            if div[int(person[i])] == div[int(person[j])]:
                answer.append(person[i])
                answer.append(person[j])
answer = set(answer)
answer = list(answer)
answer.sort()
if len(answer) == 0:
    answer.append('None')
print(answer)
