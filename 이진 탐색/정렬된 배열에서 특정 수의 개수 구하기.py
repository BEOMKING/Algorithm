from bisect import bisect_left, bisect_right
N, x = map(int, input().split())
Sequence = list(map(int, input().split()))
print(bisect_right(Sequence, x) -bisect_left(Sequence, x))
