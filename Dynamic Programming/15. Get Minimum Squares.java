# https://practice.geeksforgeeks.org/problems/get-minimum-squares/0
import math
t = int(input())

def min_squares(n):

    dp = [0]*(n+1)
    dp[1] = 1

    for i in range(2,n+1):
        if math.ceil(math.sqrt(i))*math.ceil(math.sqrt(i)) == i:
            dp[i] = 1
        else:
            dp[i] = i
            for j in range(1,math.ceil(i)+1):
                if j*j>i:
                    break
                else:
                    dp[i] = min(dp[i],dp[i-(j*j)]+1)

    return dp[n]



while t!=0:
    t-=1

    n = int(input())
    
    ans = min_squares(n)
    print(ans)