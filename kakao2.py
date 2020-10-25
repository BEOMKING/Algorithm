from itertools import combinations
from collections import Counter
orders = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
course = [2, 3, 4]
answer = []
count = 0
for cours in course:
    cour = []
    for coun in orders:
        if len(coun) >= cours:
            count += 1
    if count > 0:
        for order in orders:
            temp = [i for i in order]
            temp.sort()
            result = list(combinations(temp, cours))
            for re in result:
                cour.append(re)

        count = Counter(cour)
        max_value = max(list(count.values()))
        if max_value > 1:
            for key in list(count.keys()):
                if count[key] == max_value:
                    answer.append(key)
        count = 0
    else:
        break
answer.sort()
answer1 = []
answer2 = []
for i in answer:
    answer1.append(list(i))
for i in answer1:
    answer2.append(''.join(i))
print(answer2)