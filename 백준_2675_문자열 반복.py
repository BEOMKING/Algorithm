TestCase = int(input())
for num in range(TestCase):
    String = list(input())
    Output = []
    for alpha in range(len(String) - 2):
        Output.append(String[alpha + 2] * int(String[0]))
    print(''.join(Output))

# T = int(input())
#
# S = dict()
# for _ in range(T):
#     repeat, words = input().split()
#     output = ''
#     for word in words:
#         output += word * int(repeat)
#     print(output)