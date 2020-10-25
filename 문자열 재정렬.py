S = input()
Alphabet = []
Number = 0
for x in S:
    if ord(x) > 57:
        Alphabet.append(x)
    else:
        Number += int(x)
Alphabet.sort()
Sort = ''
for i in Alphabet:
    Sort += i

print(Sort, end='')
print(Number)
