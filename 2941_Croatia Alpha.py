Croatia = ['c=', 'c-', 'd-', 'lj', 'nj', 's=', 'z=']
Croatia3 = ['dz=']
Alpha = input()
Remove2 = []
Remove3 = []
for i in range(len(Alpha)):
    if Alpha[i:i+2] in Croatia:
        Remove2.append(Alpha[i:i+2])
    elif Alpha[i:i + 3] in Croatia3:
        Remove3.append(Alpha[i:i + 3])
print(len(Alpha) - len(Remove2) - len(Remove3))

# Croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
# Alpha = input()
# for i in Croatia:
#     Alpha = Alpha.replace(i, '0')
# print(len(Alpha))
