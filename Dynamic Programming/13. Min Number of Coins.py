# https://practice.geeksforgeeks.org/problems/number-of-coins/0
# TLE, work in Java
import sys
t = int(input())

def min_coins(coins,total_coins,value):

    dp = [0]*(value+1)

    for i in range(1,value+1):
        temp = sys.maxsize
        for c in coins:
            if i-c>=0:
                temp = min(temp,dp[i-c])
        dp[i] = temp+1
    
    return dp[value]
                
    


while t!=0:
    t-=1
    value, total_coins = [int(i) for i in input().split()]
    coins = [int(i) for i in input().split()]

    ans = min_coins(coins,total_coins,value)
    print(ans)