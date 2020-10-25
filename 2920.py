List = []
List = list(map(int, input().split(' ')))
Ascending = [1, 2 , 3, 4, 5, 6, 7, 8]
Dscending = [8, 7, 6, 5, 4, 3, 2, 1]

if List == Ascending:
    print('ascending')
elif List == Dscending:
    print('descending')
else:
    print('mixed')