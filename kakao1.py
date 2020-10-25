answer = ''
new_id = "...!@BaT#*..y.abcdefghijklm"
new_id = new_id.lower()
SC = ['-', '_', '.']
new_id = [alpha for alpha in new_id]
remove = []
for alpha in new_id:
    if alpha.isdigit() == False and alpha.isalpha() == False and alpha not in SC:
        remove.append(alpha)
for i in remove:
    if i in new_id:
        new_id.remove(i)

count = 0
new_id1 = []
for alpha in new_id:
    if alpha == '.':
        count += 1
        if count > 1:
            count -= 1
        else:
            new_id1.append(alpha)
    else:
        count = 0
        new_id1.append(alpha)
if len(new_id1) > 0:
    if new_id1[0] == '.':
        del new_id1[0]
    if len(new_id1) > 1:
        if new_id1[-1] == '.':
            del new_id1[-1]


if len(new_id1) == 0:
    new_id1.append('a')
new_id1 = new_id1[:15]
if new_id1[-1] == '.':
    del new_id1[-1]

if len(new_id1) <= 2:
    while len(new_id1) < 3:
        new_id1.append(new_id1[-1])
for i in new_id1:
    answer += i
print(answer)