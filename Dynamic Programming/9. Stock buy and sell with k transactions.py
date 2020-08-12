# https://practice.geeksforgeeks.org/problems/maximum-profit/0
# TLE

import sys
t = int(input())

# O(k*n*n)
def max_profit_unoptimized(prices,n,k):

    dp = [[0]*(n+1) for i in range(k+1)]

    for i in range(1,k+1):
        for j in range(1,n+1):
            val = -sys.maxsize
            for m in range(1,j):
                val = max(val,prices[j-1]-prices[m-1]+dp[i-1][m])
            dp[i][j] = max(val,dp[i][j-1])
    
    return dp[k][n]

def max_profit_optimized(prices,n,k):

    dp = [[0]*(n+1) for i in range(k+1)]
    
    for i in range(1,k+1):
        maxdiff = -sys.maxsize
        for j in range(1,n+1):
            maxdiff = max(maxdiff,dp[i-1][j-1]-prices[j-1])
            dp[i][j] = max(maxdiff+prices[j-1],dp[i][j-1])
    
    return dp[k][n]
            


while t!=0:
    t-=1

    k = int(input())
    n = int(input())
    prices = [int(i) for i in input().split()]
    
    res = max_profit_optimized(prices,n,k)
    print(res)

