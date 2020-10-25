# 내 풀이
N = int(input())
count = 0
for h in range(N + 1):
    if '3' in str(h):
        count += 3600
    else:
        for m in range(60):
            if '3' in str(m):
                count += 60
            else:
                for s in range(60):
                    if '3' in str(s):
                        count += 1
print(count)

# 정답 풀이
N = int(input())
count = 0
for h in range(N + 1):
    for m in range(60):
        for s in range(60):
            if '3' in str(h) + str(m) + str(s):
                count += 1

print(count)