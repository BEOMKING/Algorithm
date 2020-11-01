ran = list(range(1, 10001))
self = []
i = 1
while True:
    a = list(map(int, list(str(i))))
    Sum = i + sum(a)
    if Sum > 11000:
        break
    self.append(Sum)
    i += 1
for i in range(len(self)):
    if self[i] in ran:
        ran.remove(self[i])
for i in range(len(ran)):
    print(ran[i])