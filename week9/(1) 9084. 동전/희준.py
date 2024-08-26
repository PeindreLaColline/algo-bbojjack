import sys
input = sys.stdin.readline

t = int(input())                            // 테케 수
for _ in range(t):
    n = int(input())                        // 동전 수
    coins = list(map(int, input().split()))  // 동전 종류 저장 ( 얼마 짜린 지 )
    m = int(input())                        // 만들어야 할 금액

    d = [0] * (m + 1)                        // 동전 개수가 저장될 배열
    d[0] = 1                                


    for coin in coins:
        for i in range(coin,m + 1):
            d[i] += d[i - coin]            // 고른 동전부터 만들어야 할 금액까지 
                                            // i - 동전 금액 한 곳을 더해주기
    print(d[m])
