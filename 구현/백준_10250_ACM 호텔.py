T = int(input())
for _ in range(T):
    Floor, Ho, N = map(int, input().split())
    Room = 0
    if N <= Floor:
        Room = N * 100 + 1
        print(Room)
    elif N > Floor:
        Room = (N % Floor) * 100 + (N // Floor + 1)
        if N % Floor == 0:
            Room = Floor * 100 + N // Floor
        print(Room)