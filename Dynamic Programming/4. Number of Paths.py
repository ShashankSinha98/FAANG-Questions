# https://practice.geeksforgeeks.org/problems/count-all-possible-paths-from-top-left-to-bottom-right/0

MOD = 10**9+7
t = int(input())

def no_of_paths(m,n):
    
    dp = [[0]*(n+1) for i in range(m+1)]

    for i in range(1,m+1):
       dp[i][1] = 1
       #print(dp)
    
    for i in range(1,n+1):
        dp[1][i] = 1
        #print(dp)
    
    for i in range(2,m+1):
        for j in range(2,n+1):
            dp[i][j] = (dp[i-1][j] + dp[i][j-1])%MOD
            #print(dp)

    #print(dp)
    return dp[m][n]%MOD




while t!=0:
    t-=1

    m,n = [int(i) for i in input().split()]
    res = no_of_paths(m,n)

    print(res)