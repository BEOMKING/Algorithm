year = int(input())
if 1 <= year and year <= 4000:
    if (year % 4 == 0):
        if (year % 100 == 0):
            if (year % 400 == 0):
                print('1')
            else:
                print('0')
        else:
            print('1')
    else:
        print('0')