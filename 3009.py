X = []
Y = []
for _ in range(3):
    x, y = map(int, input().split())
    X.append(x)
    Y.append(y)
for i in range(len(X)):
    if X.count(X[i]) == 1:
        x = X[i]
    if Y.count(Y[i]) == 1:
        y = X[i]
print(x, y)


