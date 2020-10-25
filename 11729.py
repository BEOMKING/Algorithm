def hanoi(disk):
    one = []
    two = []
    three = []
    for i in range(1, disk):
        one.append(i)
    while True:
        i = 0
        three.append(one[i])
        one.remove(i)
        print('1', '3')



num = int(input())
print(hanoi(num))

