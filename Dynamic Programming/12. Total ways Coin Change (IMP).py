# https://practice.geeksforgeeks.org/problems/coin-change/0
# TODO
t = int(input())

def total_ways_recc(coins,c,n):
    if n==0:
        return 1
    
    if n<0:
        return 0
    
    if c<=0 and n>0:
        return 0

    return total_ways_recc(coins,c,n-coins[c-1]) + total_ways_recc(coins,c-1,n)

def total_ways_top_down(coins,c,n):
    global dp
    if n==0:
        return 1
    
    if n<0:
        return 0
    
    if c<=0 and n>0:
        return 0

    if dp[c][n] != -1:
        return dp[c][n]

    dp[c][n] =  total_ways_top_down(coins,c,n-coins[c-1]) + total_ways_top_down(coins,c-1,n)
    return dp[c][n]

def total_ways_bottom_up(coins,cl,n):

    dp = [0] *(n+1)
    dp[0] = 1

    for c in coins:
        for i in range(1,n+1):
            if i-c>=0:
                dp[i] = dp[i] + dp[i-c]

    return dp[n]



while t!=0:
    t-=1

    c = int(input())
    coins = [int(i) for i in input().split()]
    n = int(input())
    dp = [[-1]*(n+1) for i in range(c+1)]
    print(total_ways_bottom_up(coins,c,n))