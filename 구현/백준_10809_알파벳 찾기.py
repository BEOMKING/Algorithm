import string

S = input()
Alpha = list(string.ascii_lowercase)
Alphabet = list(string.ascii_lowercase)

for i in range(len(S)):
    if S[i] in Alpha:
        Alpha[Alpha.index(S[i])] = S.index(S[i])
for j in range(len(Alpha)):
    if Alpha[j] in Alphabet:
        Alpha[j] = -1
for i in range(len(Alpha)):
    print(Alpha[i], end=' ')

#다른 풀이
#print(*map(input().find, map(chr, range(97, 123))), sep=' ')