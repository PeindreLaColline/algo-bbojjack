import sys

input = sys.stdin.readline

n = int(input())
S = [0] * (n + 1)
P = [0] * (n + 1)  # 경로 추적을 위한 리스트

for i in range(2, n + 1):
    S[i] = S[i - 1] + 1
    P[i] = i - 1

    if i % 2 == 0 and S[i] > S[i // 2] + 1:
        S[i] = S[i // 2] + 1
        P[i] = i // 2

    if i % 3 == 0 and S[i] > S[i // 3] + 1:
        S[i] = S[i // 3] + 1
        P[i] = i // 3

# 최소 연산 횟수 출력
print(S[n])

# 경로 추적
path = []
while n > 0:
    path.append(n)
    n = P[n]

# 경로 출력
print(' '.join(map(str, path)))
