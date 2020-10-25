import string
Case = int(input())
count = 0
Alpha = string.ascii_lowercase

for _ in range(Case):
    Group = []
    ex = input()
    for i in Alpha:
        left = ex.find(i) + 1
        right = ex.rfind(i) + 1
        num = ex.count(i)
        if right - left + 1 == num:
            Group.append('True')
        elif left == 0 and right == 0 and num == 0:
            Group.append('Not in')
        else:
            Group.append('False')
    if 'False' not in Group:
        count += 1
print(count)

# result = 0
# for i in range(int(input())):
#     word = input()
#     print(sorted(word, key=word.find))
#
#     if list(word) == sorted(word, key=word.find):
#         result += 1
# print(result)