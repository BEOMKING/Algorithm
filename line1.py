from collections import Counter
answer = 0
boxes = [[1, 2], [3, 4], [5, 6]]
newboxes = []
for i in boxes:
    newboxes.append(i[0])
    newboxes.append(i[1])
count = Counter(newboxes)
number = list(count.values())
print(count)

for i in number:
    if i % 2 != 0:
        answer += 1
print(answer // 2)