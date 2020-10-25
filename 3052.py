A = int(input())
B = int(input())
C = int(input())
D = int(input())
E = int(input())
F = int(input())
G = int(input())
H = int(input())
I = int(input())
J = int(input())

List = [A, B, C, D, E, F, G, H, I, J]
List2 = []

for i in List:
    List2.append(i % 42)

print(len(list(set(List2)))) # set 함수의 사용 중복제거

'''
num_list = []
rem_list = []

for i in range(10):
    num_list.append(int(input()))

for num in num_list:
    rem = num % 42
    if rem in rem_list:
        pass
    else:
        rem_list.append(rem)
        
print(len(rem_list))
'''