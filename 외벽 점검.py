from itertools import permutations

n = 12
weak = [1, 5, 6, 10]
dist = [1, 2, 3, 4]

for i in range(1, len(dist) + 1):
    per = list(permutations(dist, i))
    for j in per:
