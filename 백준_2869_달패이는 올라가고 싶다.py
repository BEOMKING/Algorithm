import math
A, B, V = map(int, input().split())
t = math.ceil((V - B) / (A - B))
print(t)

