n = int(input())
sum = 0

S = [0]*2
S[0] = 1
S[1] = 3

for i in range(2,n+1):
    if(i%2 ==0):
        S[0] = 2* S[1]+S[0]
    else:
        S[1] = 2*S[0] + S[1]

print(S[n%2]%9901)
