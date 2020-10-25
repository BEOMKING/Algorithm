import math
x, y, w, h = map(int, input().split())

print(min(x, y, w - x, h - y, math.sqrt((w - x) ** 2 + (h - y) ** 2)))