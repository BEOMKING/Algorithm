T = int(input())

people = [[1,2,3,4,5,6,7,8,9,10,11,12,13,14]]
for i in range(14):
    ho = []
    peoplesum = 0
    for j in range(14):
        peoplesum += people[i][j]
        ho.append(peoplesum)
    people.append(ho)

for _ in range(T):
    Floor = int(input())
    Ho = int(input())
    print(people[Floor][Ho - 1])

# Case = input()
# for _ in range(int(Case)):
#     k = int(input())
#     n = int(input())
#     num = [i for i in range(1, n + 1)]
#     for _ in range(k):
#         for j in range(1, n):
#             num[j] += num[j-1]
#     print(num[-1])