place = input()
case = 0
row = int(place[1])
column = ord(place[0]) - ord('a') + 1

if column - 2 > 0:
    if row - 1 > 0:
        case += 1
    if row + 1 < 9:
        case += 1
if column + 2 < 9:
    if row - 1 > 0:
        case += 1
    if row + 1 < 9:
        case += 1
if row - 2 > 0:
    if column - 1 > 0:
        case += 1
    if column + 1 < 9:
        case += 1
if row + 2 < 9:
    if column - 1 > 0:
        case += 1
    if column + 1 < 9:
        case += 1
print(case)